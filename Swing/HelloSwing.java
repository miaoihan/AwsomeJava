package Swing;

import javax.swing.*;

/**
 * Created by han on 16-4-12.
 */
public class HelloSwing {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Hello");
        JButton jb = new JButton("我是按钮");
        jf.add(jb);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //默认关闭操作
        jf.setSize(300, 100);
        jf.setVisible(true);
    }
}
