package Swing;

import javax.swing.*;

/**
 * Created by han on 16-4-24.
 */
public class Windows1 {
    private JPanel panel1;
    private JTextField tname;
    private JLabel name;
    private JButton button1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Windows1");
        JLabel jb = new JLabel();
        frame.setContentPane(new Windows1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
