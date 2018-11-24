import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashAppGUI extends JFrame implements ActionListener {
    private CardStack deck = new CardStack();
    private JFrame f;
    private String ans = "";
    public FlashAppGUI(){
        // create a new frame
        f = new JFrame("FlashApp");



        // create a panel
        JPanel p = new JPanel();

        JButton b = new JButton("click");

        // add actionlistener to button
        b.addActionListener(this);

        // add button to panel
        p.add(b);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(400, 400);

        f.show();


    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
//            // create a dialog Box
//            JDialog d = new JDialog(f, "dialog Box");
//
//            // create a label
//            JLabel l = new JLabel("Stuff");
//
//            d.add(l);
//
//            // setsize of dialog
//            d.setSize(100, 100);

            // set visibility of dialog
//            d.setVisible(true);
            while (!ans.equals("no")) {
                String word = JOptionPane.showInputDialog(null, "Enter word: ");
                String definition = JOptionPane.showInputDialog(null, "Enter definition: ");
                deck.push(new Flashcard(word, definition));

                String reply = JOptionPane.showInputDialog(null,"Make another? yes or no: ");
                ans = reply;
            }
            while (!deck.empty()){
                String defn  = deck.peek().getDefinition();
                String term = deck.peek().getTerm();
                JOptionPane.showMessageDialog(null,defn);
                String ans = JOptionPane.showInputDialog(null,"What term? ");
                String reply = "";
                if (ans.equalsIgnoreCase(term)){
                    JOptionPane.showMessageDialog(null,"That is the correct answer" );
                }
                else{
                    JOptionPane.showMessageDialog(null,"That is not the correct answer");
                }
                deck.pop();
            }

            System.exit(0);

        }
    }

}
