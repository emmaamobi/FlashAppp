

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class FlashAppGUI extends JFrame implements ActionListener {
    private CardStack deckLIFO;
    private CardQueue deckFIFO;
    private ArrayList<Flashcard> cards;
    private JFrame f;
    private JLabel card;
    private int pos;
    private String ans = "";
    private String[] options = {"LIFO","FIFO"};
    private JComboBox c1;
    boolean term = true;
    boolean browseMode = false;
    public FlashAppGUI(){
        // create a new frame
        f = new JFrame("FlashApp");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPanel();
        cards = new ArrayList<Flashcard>();

    }
    public void mainPanel(){
        // create panels and panes
        JSplitPane mainMenu = new JSplitPane();
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.PAGE_AXIS));
        JPanel top = new JPanel();
        JPanel modes = new JPanel(); //will go in top

        JSplitPane bottom = new JSplitPane();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.PAGE_AXIS));
        JPanel flashcard = new JPanel(); //will go in bottom
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
        JButton create = new JButton("Create flashcard set");
        JButton browse = new JButton("Browse cards");
        JButton next = new JButton("Next");
        JButton prev = new JButton("Previous");
        JButton flip = new JButton("Flip");
        card = new JLabel();
        card.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JButton edit = new JButton("Edit");
       //JLabel instructions = new JLabel("");
        //JTextField field = new JTextField();
        JButton exit = new JButton("Exit");

        // add actionlistener to button
        LIFO.addActionListener(this);
        FIFO.addActionListener(this);
        create.addActionListener(this);
        browse.addActionListener(this);
        next.addActionListener(this);
        prev.addActionListener(this);
        flip.addActionListener(this);
        edit.addActionListener(this);
        //field.addActionListener(this);
        exit.addActionListener(this);

        // add button to panel
        modes.add(intro);
        modes.add(j1);
        modes.add(LIFO);
        modes.add(FIFO);
        modes.add(create);
        modes.add(browse);
        flashcard.add(card);
        //flashcard.add(instructions);
        buttons.add(edit);
        buttons.add(flip);
        buttons.add(next);
        buttons.add(prev);
        //flashcard.add(field);
        buttons.add(exit);
        // add panel to frame
        f.add(mainMenu);

        // set the size of frame
        f.setSize(400, 400);
        pack();
        f.show();
    }

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
        else if (s.equals("Create flashcard set")){
            f.hide();
            ans = "yes";
            createDeck();
            f.show();
        }
        else if (s.equals("Browse cards")){
            browseMode = true;
            browseModeNext(0);
        }
        else if (s.equals("Next")){
            if (browseMode) {
                if (pos == cards.size()) {
                    JOptionPane.showMessageDialog(null, "There are no more cards.");
                } else {
                    pos++;
                    browseModeNext(pos);
                }
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
                } else {
                    card.setText(cards.get(pos).getTerm());
                    term = true;
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
    public void createDeck(){
        cards.clear();
        while (!ans.equalsIgnoreCase("no")){
            String word = JOptionPane.showInputDialog(f, "Enter term: ");
            String definition = JOptionPane.showInputDialog(f, "Enter definition for " + word + ": ");
            cards.add(new Flashcard(word, definition));
            System.out.println(cards.toString());
            ans = JOptionPane.showInputDialog(f, "Make another?  Type yes or no: ");
            ////work on this below, currently not functioning
            if (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")) {
                 ans = JOptionPane.showInputDialog(f, "That was not a valid input. Try again.\n" +
                        "Make another? Type yes or no:");
            }
        }

    }

    public void fifoMode(){
        deckFIFO = new CardQueue();
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
    }

    public void lifoMode() {
        deckLIFO = new CardStack();
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
    }
    public void checkAnswer(String input, String term){
        if (input.equalsIgnoreCase(term)){
            JOptionPane.showMessageDialog(null,"That is the correct answer!" );
        }
        else{
            JOptionPane.showMessageDialog(null,"That is not the correct answer.");
        }
    }

    public void browseModeNext(int position){
        if (cards.isEmpty()){
            JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
        }
        else if (position < cards.size()){
            card.setText(cards.get(position).getTerm());
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no more cards.");
            pos = cards.size()-1;
        }
    }
    public void browseModePrev(int position){
        if (cards.isEmpty()){
            JOptionPane.showMessageDialog(null, "You must create a flashcard set first.");
        }
        else if (position >= 0){
            card.setText(cards.get(position).getTerm());
        }
    }
}
