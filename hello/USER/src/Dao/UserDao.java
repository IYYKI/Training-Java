package Dao;

import USER.User;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDao {
    Scanner in = new Scanner(System.in);

    //根据  用户名、密码    进行查询
    public User queryByUserNameAndPassword(String userName, String password) {
        String sql = "select * from user where userName=? and password=?";
        User u = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.加载静态代码块，找到了驱动。(Driver)
            //2.调用了getCon方法，连接了数据库。DriverManager.getConnection();
            con = DBUtil.getCon();
            //3.执行SQL语句
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            //4.执行sql语句，并返回结果
            rs = ps.executeQuery();
            //处理结果
            while(rs.next()) {
                u = new User();
                u.setUserName(rs.getString("userName"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
                u.setBirthday(rs.getString("birthday"));
                u.setHobby(rs.getString("hobby"));
                u.setAddress(rs.getString("address"));
                u.setContactNumber(rs.getString("contactNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return u;
    }

    //根据  用户名  进行查询
    public User queryByUserName(String userName) {
        String sql = "select * from user where userName=?";
        User u = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.加载静态代码块，找到了驱动。(Driver)
            //2.调用了getCon方法，连接了数据库。DriverManager.getConnection();
            con = DBUtil.getCon();
            //3.执行SQL语句
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            //4.执行sql语句，并返回结果
            rs = ps.executeQuery();
            //处理结果
            while(rs.next()) {
                u = new User();
                u.setUserName(rs.getString("userName"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
                u.setBirthday(rs.getString("birthday"));
                u.setHobby(rs.getString("hobby"));
                u.setAddress(rs.getString("address"));
                u.setContactNumber(rs.getString("contactNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return u;
    }

    //增加用户
    public void insertUser() {

        //检测用户名是否已存在
        String userName = null;
        while(true) {
            System.out.println("请输入userName:");
            userName = in.next();
            User u = queryByUserName(userName);
            if(u != null) {
                System.out.println("用户名" + u.getUserName() + "已存在，请重新输入！");
            }else {
                break;
            }
        }

        System.out.println("请输入password:");
        String password = in.next();
        System.out.println("请输入name:");
        String name = in.next();
        System.out.println("请输入sex:");
        String sex = in.next();
        System.out.println("请输入birthday:");
        String birthday = in.next();
        System.out.println("请输入address:");
        String address = in.next();
        System.out.println("请输入hobby:");
        String hobby = in.next();
        System.out.println("请输入contactNumber:");
        String contactNumber = in.next();

        String sql = "insert into user(userName,password,name,sex,birthday,address,hobby,contactNumber) values(?,?,?,?,?,?,?,?)";
        User u = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            ps.setString(3,name);
            ps.setString(4,sex);
            ps.setString(5,birthday);
            ps.setString(6,address);
            ps.setString(7,hobby);
            ps.setString(8,contactNumber);
            int flag = ps.executeUpdate();
            if(flag > 0 ) {
                System.out.println("注册成功");
            }else {
                System.out.println("注册失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

