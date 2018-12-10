import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlashAppGUI extends JFrame implements ActionListener {

    /** This class creates the GUI and handles the user
     * interaction with the GUI. This utilizes JavaSwing
     * to create a GUI.**/

    private CardStack deckLIFO;
    private CardQueue deckFIFO;
    private CardRand deckRAND;
    private ArrayList<Flashcard> cards;
    private JFrame f;
    private JPanel flashcard;
    private JLabel card;
    private int pos;
    private String ans = "";
    boolean term = true;
    boolean browseMode = false;
    private int score = 0;

    /**Constructor creates the GUI and makes it match
     * the current system's look.**/
    public FlashAppGUI(){
        // create a new frame
        f = new JFrame("FlashApp");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPanel();
        cards = new ArrayList<>();
    }

    /**Creates the main panel of the GUI and creates the buttons,
     * labels, etc. **/
    private void mainPanel(){
        // create panels and panes
        JSplitPane mainMenu = new JSplitPane();
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.PAGE_AXIS));
        JPanel top = new JPanel();
        JPanel modes = new JPanel(); //will go in top

        JSplitPane bottom = new JSplitPane();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.PAGE_AXIS));
        flashcard = new JPanel(); //will go in bottom
        JPanel buttons = new JPanel(); //will go in bottom

        //sets up the split panes
        mainMenu.setOrientation(JSplitPane.VERTICAL_SPLIT);
        mainMenu.setTopComponent(top);
        mainMenu.setBottomComponent(bottom);
        mainMenu.setDividerLocation(90);
        bottom.setOrientation(JSplitPane.VERTICAL_SPLIT);
        bottom.setTopComponent(flashcard);
        bottom.setDividerLocation(200);
        bottom.setBottomComponent(buttons);
        mainMenu.setEnabled(false);
        bottom.setEnabled(false);

        //spice up that layout, set window size and panel layout
        setPreferredSize(new Dimension(400,400));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(mainMenu);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.add(modes);

        //create all components
        JLabel intro = new JLabel("Welcome to FlashApp!");
        JLabel j1 = new JLabel("Choose Mode: ");
        JButton LIFO = new JButton("LIFO");
        JButton FIFO = new JButton("FIFO");
        JButton RAND = new JButton("Random");
        JButton create = new JButton("Create flashcard set");
        JButton browse = new JButton("Browse cards");
        JButton next = new JButton("Next");
        JButton prev = new JButton("Previous");
        JButton flip = new JButton("Flip");
        card = new JLabel();
        card.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JButton edit = new JButton("Edit");
        JButton exit = new JButton("Exit");

        // add actionlistener to button
        LIFO.addActionListener(this);
        FIFO.addActionListener(this);
        RAND.addActionListener(this);
        create.addActionListener(this);
        browse.addActionListener(this);
        next.addActionListener(this);
        prev.addActionListener(this);
        flip.addActionListener(this);
        edit.addActionListener(this);
        exit.addActionListener(this);

        // add button to panel
        modes.add(intro);
        modes.add(j1);
        modes.add(LIFO);
        modes.add(FIFO);
        modes.add(RAND);
        modes.add(create);
        modes.add(browse);
        flashcard.add(card);
        buttons.add(edit);
        buttons.add(flip);
        buttons.add(next);
        buttons.add(prev);
        buttons.add(exit);
        // add panel to frame
        f.add(mainMenu);

        // set the size of frame
        f.setSize(400, 400);
        pack();
        f.show();
    }

    /**This method handles all of the button actions
     * and calls the appropriate methods based on
     * the button pressed.**/
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("LIFO")) {
            f.hide();
            lifoMode();
            f.show();
        }
        else if (s.equals("FIFO")) {
            f.hide();
            fifoMode();
            f.show();
        }
        else if (s.equals("Random")){
            f.hide();
            randMode();
            f.show();

        }
        else if (s.equals("Create flashcard set")){
            f.hide();
            ans = "yes";
            createDeck();
            f.show();
        }
        else if (s.equals("Browse cards")){
            if (cards.isEmpty()){
                JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
            }
            else if (browseMode){
                browseMode = false;
                card.setText("Browse Mode is now off.");
            }
            else{
                pos = 0;
                browseMode = true;
                browseModeNext(0);
            }
        }
        else if (s.equals("Next")){
            if (browseMode) {
                if (pos == cards.size()) {
                    JOptionPane.showMessageDialog(null, "There are no more cards.");
                } else {
                    pos++;
                    browseModeNext(pos);
                }
                term = true;
            }
            else{
                card.setText("You must enable Browse Mode to use this feature.");
            }
        }
        else if (s.equals("Previous")){
            if (browseMode) {
                if (pos == 0) {
                    JOptionPane.showMessageDialog(null, "There are no more cards.");
                } else {
                    pos--;
                    browseModePrev(pos);
                }
                term = true;
            }
            else{
                card.setText("You must enable Browse Mode to use this feature.");
            }
        }
        else if (s.equals("Flip")){
            if (browseMode) {
                if (term) {
                    card.setText(cards.get(pos).getDefinition());
                    term = false;
                    setBackgroundColor();
                } else {
                    card.setText(cards.get(pos).getTerm());
                    term = true;
                    setBackgroundColor();
                }
            }
            else{
                card.setText("You must enable Browse Mode to use this feature.");
            }
        }
        else if (s.equals("Edit")){
            if (browseMode) {
                if (term) {
                    cards.get(pos).setTerm(JOptionPane.showInputDialog("Enter a new term for this card:"));
                    card.setText(cards.get(pos).getTerm());

                } else {
                    cards.get(pos).setDef(JOptionPane.showInputDialog("Enter a new definition for this card:"));
                    card.setText(cards.get(pos).getDefinition());
                }
            }
            else{
                card.setText("You must enable Browse Mode to use this feature.");
            }
        }
        else if (s.equals("Exit")){
            System.exit(0);
        }
    }

    /**This method changes the background color of the flashcard based on
     * the current background color.**/
    private void setBackgroundColor(){
        if (flashcard.getBackground() == Color.GRAY){
            flashcard.setBackground(Color.PINK);
        }
        else{
            flashcard.setBackground(Color.GRAY);
        }
    }
    /**This method creates the deck based on user input.
     * The user enters the term and definition and then
     * enters yes or no if they want to continue entering
     * cards. **/
    private void createDeck(){
        cards.clear();
        while (!ans.equalsIgnoreCase("no")){
            String word = JOptionPane.showInputDialog(f, "Enter term: ");
            String definition = JOptionPane.showInputDialog(f, "Enter definition for " + word + ": ");
            cards.add(new Flashcard(word, definition));
            ans = JOptionPane.showInputDialog(f, "Make another?  Type yes or no: ");
            ////work on this below, currently not functioning
            if (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")) {
                 ans = JOptionPane.showInputDialog(f, "That was not a valid input. Try again.\n" +
                        "Make another? Type yes or no:");
            }
        }

    }

    /**This method handles the fifo mode which
     * quizzes the user about the flashcards in
     * the order they were entered in. **/
    private void fifoMode(){
        deckFIFO = new CardQueue();
        score = 0;
        if (cards.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
        }
        for (int i = 0; i < cards.size(); i++){
            deckFIFO.offer(cards.get(i));
        }
        while (!deckFIFO.empty()){
            String term = deckFIFO.peek().getTerm();
            String input = JOptionPane.showInputDialog(null,"What term goes with " + deckFIFO.peek().getDefinition() + "?");
            checkAnswer(input, term);
            deckFIFO.poll();
        }
        JOptionPane.showMessageDialog(null,"Your total score was " + score + ".");
    }

    /**This method handles the lifo mode which
     * quizzes the user about the flashcards in
     * the reverse order they were entered in. **/
    private void lifoMode() {
        deckLIFO = new CardStack();
        score = 0;
        if (cards.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
        }
        for (int i = 0; i < cards.size(); i++){
            deckLIFO.push(cards.get(i));
        }
        while (!deckLIFO.empty()){
            String term = deckLIFO.peek().getTerm();
            String input = JOptionPane.showInputDialog(null,"What term goes with " + deckLIFO.peek().getDefinition()+ "?");
            checkAnswer(input, term);
            deckLIFO.pop();
        }
        JOptionPane.showMessageDialog(null,"Your total score was " + score + ".");
    }

    /**This method handles the random mode which
     * randomly chooses flashcards from the set
     * to quiz the user.**/
    private void randMode(){
        deckRAND = new CardRand();
        score = 0;
         if (cards.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
        }
        for (int i = 0; i < cards.size(); i++){
            deckRAND.add(cards.get(i));
        }
        while (!deckRAND.isArrEmpty()){
            Flashcard card = deckRAND.getRandom();
            String term = card.getTerm();

            String input = JOptionPane.showInputDialog(null,"What term goes with " + card.getDefinition()+ "?");
            checkAnswer(input, term);
            deckRAND.remove(card);
        }
        JOptionPane.showMessageDialog(null,"Your total score was " + score + ".");
    }

    /**This method checks to see if the user input is the correct
     * answer**/
    private void checkAnswer(String input, String term){
        if (input.equalsIgnoreCase(term)){
            JOptionPane.showMessageDialog(null,"That is the correct answer!" );
            score++;
            JOptionPane.showMessageDialog(null,"Your score: " + score);
        }
        else{
            JOptionPane.showMessageDialog(null,"That is not the correct answer.");
        }
    }

    /**This method handles the next button action
     * and switches the label to show the next flashcard.**/
    private void browseModeNext(int position){
        if (cards.isEmpty()){
            JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
        }
        else if (position < cards.size()){
            card.setText(cards.get(position).getTerm());
            setBackgroundColor();
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no more cards.");
            pos = cards.size()-1;
        }
    }

    /**This method handles the previous button action
     * and switches the label to the previous flashcard.**/
    private void browseModePrev(int position){
        if (cards.isEmpty()){
            JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
        }
        else if (position >= 0){
            card.setText(cards.get(position).getTerm());
            setBackgroundColor();
        }
    }

}
