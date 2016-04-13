/**
 * Created by han on 16-4-12.
 */
package Swing;

import javax.swing.*;
import java.awt.*;

public class  Button1 extends JFrame{
    private JButton b1 = new JButton("我是按钮");
    public Button1(){
        setLayout(new FlowLayout());
        add(b1);
    }

    public static void main(String[] args) {
        run(new Button1(), 200, 100);
    }

    public static void run(JFrame jf, int width, int height){
        JButton jb = new JButton("我是按钮");
//        jf.add(jb);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //默认关闭操作
        jf.setSize(width, height);
        jf.setVisible(true);
    }

}
