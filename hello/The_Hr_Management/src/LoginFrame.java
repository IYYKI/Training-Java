import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    Container containerPane;
    JPanel panelTop = new JPanel();
    JPanel panelMid = new JPanel();
    JPanel panelBut = new JPanel();
    JLabel Top = new JLabel();
    JLabel Names = new JLabel();
    JLabel Pwd = new JLabel();
    JLabel Model = new JLabel();
    JLabel Null = new JLabel();
    JTextField Namefield = new JTextField(15);
    JPasswordField Pwdfield = new JPasswordField(15);
    JComboBox cmb = new JComboBox();
    JButton button1 = new JButton("��½");
    JButton button2 = new JButton("ȡ��");
    int ss;
    LoginFrame(){
        Names.setText("�� �֣�");
        Pwd.setText("�� �룺");
        Model.setText("�û���");
        Null.setText(" ");
        String [] s1 = {"����Ա���ο�"};
        cmb.addItem(s1[0]);
        cmb.addItem(s1[1]);
        panelTop.add(Names);
        panelTop.add(Namefield);
        panelMid.add(Pwd);
        panelMid.add(Pwdfield);
        panelMid.add(Model);
        panelMid.add(cmb);
        panelBut.add(button1);
        panelBut.add(button2);
        containerPane = this.getContentPane();
        
    }
}
