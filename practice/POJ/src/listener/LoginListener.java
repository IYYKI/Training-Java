package listener;


import dao.UserDao;
import view.LoginView;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private LoginView lv;
    private Boolean flag = false;

    public LoginListener(LoginView lv) {
        this.lv = lv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if ("登录".equals(str)) {
            String username = lv.getJtf1().getText();
            String password = new String(lv.getJpf2().getPassword());
            UserDao userDao = new UserDao();
            flag = userDao.selectByUserAndPwd(username, password);
            if (flag == true) {
                //新建主窗口
                new MainView();
                //隐藏登录窗口
                lv.getJframe().setVisible(false);
            } else {
                lv.getError().setText("账号或密码错误");
                lv.getJtf1().setText("");
                lv.getJpf2().setText("");
            }
        } else if ("取消".equals(str)) {
            System.exit(0);
        }
    }

}
