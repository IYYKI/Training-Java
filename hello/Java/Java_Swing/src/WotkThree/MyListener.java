package WotkThree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyListener implements ActionListener {
    Change one;
    Change two;

    public MyListener(Change one, Change two) {
        super();
        this.one = one;
        this.two = two;
    }

    public MyListener(Test01 text) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if ("转移".equals(str)) {
            String string = one.getTextField().getText();
            two.setTextField(string);
        }
    }

}
