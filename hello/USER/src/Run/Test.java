package Run;

import Dao.UserDao;
import USER.User;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = in.next();
        System.out.println("请输入密码：");
        String password = in.next();
        UserDao userDao = new UserDao();
        User u = userDao.queryByUserNameAndPassword(userName,password);
        if (u == null) {
            System.out.println("账号不存在或密码错误");
            while (true) {
                System.out.println("请选择：1.注册新用户  2.退出系统");
                String s = in.next();
                if ("注册新用户".equals(s) || "1".equals(s) || "1.注册新用户".equals(s)) {
                    // 注册新用户
                    System.out.println("要开始注册新用户啦！");
                    userDao.insertUser();
                } else if ("退出系统".equals(s) || "2".equals(s) || "2.退出系统".equals(s)) {
                    System.out.println("程序结束");
                    return;
                } else {
                    break;
                }
            }
        } else {
            System.out.println("此用户已经存在！\n用户信息：" + u + "\n程序结束");
        }

    }

}
