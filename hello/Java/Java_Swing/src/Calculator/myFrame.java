package Calculator;

import javax.swing.*;

class myFrame extends JFrame {
    public myFrame() {
        setTitle("计算器");
        add(new myPanel());
        pack();
    }
}