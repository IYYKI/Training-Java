package Calculator;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("计算器");
        add(new myPanel());
        pack();
    }
}
