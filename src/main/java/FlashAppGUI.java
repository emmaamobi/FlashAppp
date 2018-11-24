import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashAppGUI extends JFrame implements ActionListener {
    private CardStack deck = new CardStack();
    private JFrame f;
    private String ans = "";
    public FlashAppGUI(){
        // create a new frame
        f = new JFrame("frame");



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
            // create a dialog Box
            JDialog d = new JDialog(f, "dialog Box");

            // create a label
            JLabel l = new JLabel("this is a dialog box");

            d.add(l);

            // setsize of dialog
            d.setSize(100, 100);

            // set visibility of dialog
            d.setVisible(true);
            while (!ans.equals("no")) {
                String word = JOptionPane.showInputDialog(null, "Enter word: ");
                String definition = JOptionPane.showInputDialog(null, "Enter definition: ");
                deck.push(new Flashcard(word, definition));

                String reply = JOptionPane.showInputDialog(null,"Make another? yes or no: ");
                ans = reply;
            }
            while (!deck.empty()){
                System.out.println(deck.pop());
            }

        }
    }

}
