package com.aowin.dao;

import com.aowin.model.User;
import com.aowin.util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDao {


    public boolean modifyUser(String account, String password, String name,
                              String status, ArrayList authorityList) {
        boolean flag = false;
        DBConnection DBCon = new DBConnection();
        String sql1 = "update scmuser set Password='" + password + "' , Name='"
                + name + "' , Status='" + status + "' where Account='"
                + account + "'";
        String[] sql = new String[authorityList.size()];
        ArrayList sqls = new ArrayList();
        sqls.add(sql1);
        String sqlDelet = "delete from usermodel where Account='" + account
                + "'";
        sqls.add(sqlDelet);
        for (int i = 0; i < authorityList.size(); i++) {
            sql[i] = "insert into usermodel values ('" + account + "','"
                    + authorityList.get(i) + "') ";
            sqls.add(sql[i]);
        }
        flag = DBCon.executeBatch(sqls);
        DBCon.close();
        return flag;
    }

    @SuppressWarnings("unchecked")
    public boolean registUser(String account, String password, String name,
                              ArrayList authorityList) {
        DBConnection DBCon = new DBConnection();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String date = s.format(new Date());
        boolean flag = false;
        String sql1 = "insert into scmuser values ('" + account + "','"
                + password + "','" + name + "','" + date + "','1')";
        String[] sql = new String[authorityList.size()];
        ArrayList sqls = new ArrayList();
        sqls.add(sql1);
        for (int i = 0; i < authorityList.size(); i++) {
            sql[i] = "insert into usermodel values ('" + account + "','"
                    + authorityList.get(i) + "') ";
            sqls.add(sql[i]);
        }
        flag = DBCon.executeBatch(sqls);
        DBCon.close();
        return flag;
    }

    public User getUser(String Account, String Password) {
        DBConnection DBCon = new DBConnection();
        User user = new User();
        String sql = "select * from scmuser where Account='" + Account
                + "' and Password='" + Password + "' and status = '1'";
        ResultSet rs = DBCon.executeQuery(sql);

        try {
            if (rs.next()) {
                user.setAccount(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setName(rs.getString(3));
                user.setCreateDate(rs.getString(4));
                user.setStatus(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("DAO" + e.getMessage());
        }
        DBCon.close();
        return user;
    }

    @SuppressWarnings({"unchecked", "unchecked"})
    public List getUsers(String account) {
        DBConnection DBCon = new DBConnection();
        List<User> userList = new ArrayList<User>();
        String sql;
        if (account == null || account.equals("")
                || account.trim().equals("�����˺Ų�ѯ")) {
            sql = "select * from scmuser ";
        } else {
            sql = "select * from scmuser where Account like '%" + account
                    + "%'";
        }
        ResultSet rs = DBCon.executeQuery(sql);
        try {
            while (rs.next()) {
                User user = new User();
                user.setAccount(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setName(rs.getString(3));
                user.setCreateDate(rs.getString(4));
                user.setStatus(rs.getString(5));
                user.setAuthorityList(this.getAuthorityByAccount(rs
                        .getString(1)));
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println("DAO getUsers " + e.getMessage());
            System.out.println("DAO getUsers " + e.getCause());
        }
        DBCon.close();
        return userList;
    }

    @SuppressWarnings("unchecked")
    public List getAuthorityByAccount(String Account) {
        DBConnection DBCon = new DBConnection();
        List list = new ArrayList();
        String sql = "select ModelName from scmuser u ,usermodel m,systemmodel s where u.Account=m.Account and s.ModelCode=m.ModelCode and u.Account='"
                + Account + "'";
        ResultSet rs = DBCon.executeQuery(sql);
        try {
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("DAO getAuthorityByAccount " + e.getMessage());
        }
        DBCon.close();
        return list;
    }

    public boolean existAccount(String account) {
        DBConnection DBCon = new DBConnection();
        boolean flag = false;
        String sql = "select * from scmuser where Account = '" + account + "'";
        ResultSet rs = DBCon.executeQuery(sql);
        try {
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("DAO existAccount " + e.getMessage());
        }
        DBCon.close();
        return flag;

    }
}
