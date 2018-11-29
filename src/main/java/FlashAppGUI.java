import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FlashAppGUI extends JFrame implements ActionListener {
    private CardStack deckLIFO;
    private CardQueue deckFIFO;
    private JFrame f;
    private String ans = "";
    private String[] options = {"LIFO","FIFO"};
    private JComboBox c1;
    public FlashAppGUI(){
        // create a new frame
        f = new JFrame("FlashApp");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPanel();

    }
    public void mainPanel(){
        // create a panel
        JPanel mainMenu = new JPanel();

        JLabel intro = new JLabel("Welcome to FlashApp!\n");
        JLabel j1 = new JLabel("Choose Mode: ");
        JButton LIFO = new JButton("LIFO");
        JButton FIFO = new JButton("FIFO");
        JButton exit = new JButton("Exit");

        // add actionlistener to button
        LIFO.addActionListener(this);
        FIFO.addActionListener(this);
        exit.addActionListener(this);

        // add button to panel
        mainMenu.add(intro);
        mainMenu.add(j1);
        mainMenu.add(LIFO);
        mainMenu.add(FIFO);
        mainMenu.add(exit);

        // add panel to frame
        f.add(mainMenu);

        // set the size of frame
        f.setSize(400, 400);

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
        else if (s.equals("Exit")){
            System.exit(0);
        }
    }

    public void fifoMode(){
        deckFIFO = new CardQueue();
        while (!ans.equalsIgnoreCase("no")) {
            String word = JOptionPane.showInputDialog(f, "Enter term: ");
            String definition = JOptionPane.showInputDialog(f, "Enter definition for " + word+ ": ");
            deckFIFO.offer(new Flashcard(word, definition));
            ans = JOptionPane.showInputDialog(f,"Make another?  Type yes or no: ");
            ////work on this below, currently not functioning
            if (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")){
                ans = JOptionPane.showInputDialog(f,"That was not a valid input. Try again.\n" +
                        "Make another? Type yes or no:");
            }
        }
        while (!deckFIFO.empty()){
            String defn  = deckFIFO.peek().getDefinition();
            String term = deckFIFO.peek().getTerm();
            String reply = JOptionPane.showInputDialog(null,"What term goes with " + defn+ "?");
            if (reply.equalsIgnoreCase(term)){
                JOptionPane.showMessageDialog(null,"That is the correct answer!");
            }
            else{
                JOptionPane.showMessageDialog(null,"That is not the correct answer.");
            }
            deckFIFO.poll();
        }
    }

    public void lifoMode(){
        deckLIFO = new CardStack();
        while (!ans.equals("no")) {
            String word = JOptionPane.showInputDialog(f, "Enter term: ");
            String definition = JOptionPane.showInputDialog(f, "Enter definition for " + word +": ");
            deckLIFO.push(new Flashcard(word, definition));

            String reply = JOptionPane.showInputDialog(f,"Make another? Type yes or no: ");
            ans = reply;
        }
        while (!deckLIFO.empty()){
            String defn  = deckLIFO.peek().getDefinition();
            String term = deckLIFO.peek().getTerm();
            String ans = JOptionPane.showInputDialog(null,"What term goes with " + defn+ "?");
            String reply = "";
            if (ans.equalsIgnoreCase(term)){
                JOptionPane.showMessageDialog(null,"That is the correct answer!" );
            }
            else{
                JOptionPane.showMessageDialog(null,"That is not the correct answer.");
            }
            deckLIFO.pop();
        }
    }
}
