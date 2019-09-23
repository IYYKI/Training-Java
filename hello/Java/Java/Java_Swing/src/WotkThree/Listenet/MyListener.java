package WotkThree.Listenet;


import WotkThree.Transfer.Transfer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {
    private Transfer tf;

    public MyListener(Transfer tf) {
        this.tf = tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if ("转移".equals(str)) {
            String str1 = tf.getJtf().getText();
            String str2 = tf.getJtf2().getText();

            tf.getJtf().setText(str2);
            tf.getJtf2().setText(str1);

        }
    }

}
