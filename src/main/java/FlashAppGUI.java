import javax.swing.*;
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



        // create a panel
        JPanel p = new JPanel();

        JLabel j1 = new JLabel("Choose Mode: ");
        JButton b = new JButton("LIFO");
        JButton c = new JButton("FIFO");

        // add actionlistener to button
        b.addActionListener(this);
        c.addActionListener(this);

        // add button to panel
        p.add(j1);
        p.add(b);
        p.add(c);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(400, 400);

        f.show();


    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("LIFO")) {
            deckLIFO = new CardStack();
            while (!ans.equals("no")) {
                String word = JOptionPane.showInputDialog(f, "Enter word: ");
                String definition = JOptionPane.showInputDialog(f, "Enter definition: ");
                deckLIFO.push(new Flashcard(word, definition));

                String reply = JOptionPane.showInputDialog(f,"Make another? yes or no: ");
                ans = reply;
            }
            while (!deckLIFO.empty()){
                String defn  = deckLIFO.peek().getDefinition();
                String term = deckLIFO.peek().getTerm();
                JOptionPane.showMessageDialog(null,defn);
                String ans = JOptionPane.showInputDialog(null,"What term? ");
                String reply = "";
                if (ans.equalsIgnoreCase(term)){
                    JOptionPane.showMessageDialog(null,"That is the correct answer" );
                }
                else{
                    JOptionPane.showMessageDialog(null,"That is not the correct answer");
                }
                deckLIFO.pop();
            }


            System.exit(0);

        }
        else if (s.equals("FIFO")) {
            deckFIFO = new CardQueue();
            while (!ans.equals("no")) {
                String word = JOptionPane.showInputDialog(f, "Enter word: ");
                String definition = JOptionPane.showInputDialog(f, "Enter definition: ");
                deckFIFO.offer(new Flashcard(word, definition));

                String reply = JOptionPane.showInputDialog(f,"Make another? yes or no: ");
                ans = reply;
            }
            while (!deckFIFO.empty()){
                String defn  = deckFIFO.peek().getDefinition();
                String term = deckFIFO.peek().getTerm();
                JOptionPane.showMessageDialog(null,defn);
                String ans = JOptionPane.showInputDialog(null,"What term? ");
                String reply = "";
                if (ans.equalsIgnoreCase(term)){
                    JOptionPane.showMessageDialog(null,"That is the correct answer" );
                }
                else{
                    JOptionPane.showMessageDialog(null,"That is not the correct answer");
                }
                deckFIFO.poll();
            }


            System.exit(0);

        }

    }

}
