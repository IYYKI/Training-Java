package Studen.Run;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Studen.Dao.StudentDao;
import Studen.model.Student;

public class MyListener implements ActionListener{
    private Studen.Run.StudentQuery stu;

    public MyListener(Studen.Run.StudentQuery stu) {
        this.stu = stu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if("查询".equals(str)) {
            String  s = stu.getJtf1().getText();
            int id = Integer.parseInt(s);
            StudentDao sd = new StudentDao();

            Student st = sd.selectByStuno(id);
            if(st==null) {
                JOptionPane.showMessageDialog(null, "查无此人");
                stu.getJtf1().setText("");
                stu.getJtf2().setText("");
                stu.getJtf3().setText("");
                stu.getJtf4().setText("");
            }else {
                stu.getJtf2().setText(st.getName());
                stu.getJtf3().setText(st.getClassRoom());
                stu.getJtf4().setText(String.valueOf(st.getResults()));
            }
        }else if("清空".equals(str)) {
            stu.getJtf1().setText("");
            stu.getJtf2().setText("");
            stu.getJtf3().setText("");
            stu.getJtf4().setText("");
        }
    }

}

