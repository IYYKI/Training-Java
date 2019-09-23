package com.aowin.dao;

import com.aowin.model.Somain;
import com.aowin.util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class SomainDao
{
    @SuppressWarnings("unchecked")
    public List getByCreatTime(String startTime,String endTime){
        List<Somain> list =new ArrayList<Somain>();
        DBConnection DBCon = new DBConnection();
        String sql="select * from somain where CreateTime >='"+startTime+"' and CreateTime <= '"+endTime+"'";
        ResultSet rs=DBCon.executeQuery(sql);
        try
        {
            while(rs.next()){
                Somain somain=new Somain();
                somain.setSoid(rs.getInt(1));
                somain.setCreateTime(rs.getString(4));
                somain.setPoTotal(rs.getFloat(6));
                somain.setStatusx(rs.getInt(10));
                list.add(somain);
            }
        } catch (SQLException e)
        {
            System.out.println("DAO SomainDao " + e.getMessage());
            System.out.println("DAO SomainDao " + e.getCause());
        }

        DBCon.close();
        return list;
    }
    public boolean getInPreMoney(int soid, String account)
    {
        boolean flag = false;
        DBConnection DBCon = new DBConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        String sql= "update somain set Status=2 , PrePayTime='" + time
                + "' ,PrePayUser='" + account + "' where SOID="+soid;
        int result = DBCon.executeUpdate(sql);
        if (result!=0)
        {
            flag = true;
        }
        DBCon.close();
        return flag;

    }


    public boolean getInMoney(int soid, String account, String payType)
    {
        boolean flag = false;
        DBConnection DBCon = new DBConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        int sta = 0;
        String sql;
        if (payType.equals("货到付款"))
        {
            sta = 3;
            sql = "update somain set Status=" + sta + " , PayTime='" + time
                    + "' ,PayUser='" + account + "' where SOID="+soid;
        } else if (payType.equals("款到发货"))
        {
            sta = 2;
            sql = "update somain set Status=" + sta + " , PayTime='" + time
                    + "' ,PayUser='" + account + "' where SOID="+soid;
        } else
        {
            sta = 4;
            sql = "update somain set Status=" + sta + " , PrePayTime='" + time
                    + "' ,PrePayUser='" + account + "' where SOID="+soid;
        }
        int result = DBCon.executeUpdate(sql);
        if (result!=0)
        {
            flag = true;
        }
        DBCon.close();
        return flag;

    }

    @SuppressWarnings("unchecked")
    public List showTab(String payType)
    {
        DBConnection DBCon = new DBConnection();
        int sta = 0;
        if (payType.equals("货到付款"))
        {
            sta = 2;
        } else if (payType.equals("款到发货"))
        {
            sta = 1;
        } else
        {
            sta = 3;
        }
        String sql = "select * from somain where PayType='" + payType
                + "' and Status <=" + sta;
        List<Somain> somainList = new ArrayList<Somain>();
        ResultSet rs = DBCon.executeQuery(sql);
        try
        {
            while (rs.next())
            {
                Somain somain = new Somain();
                somain.setSoid(Integer.parseInt(rs.getString(1)));
                somain.setCustomerCode(rs.getString(2));
                somain.setAccount(rs.getString(3));
                somain.setCreateTime(rs.getString(4));
                somain.setTipFee(Float.parseFloat(rs.getString(5)));
                somain.setProductTotal(Float.parseFloat(rs.getString(6)));
                somain.setPoTotal(Float.parseFloat(rs.getString(7)));
                somain.setPayType(rs.getString(8));
                somain.setPrePayFee(Float.parseFloat(rs.getString(9)));
                somain.setStatusx(Integer.parseInt(rs.getString(10)));
                somain.setRemark(rs.getString(11));
                somain.setStockTime(rs.getString(12));
                somain.setStockUser(rs.getString(13));
                somain.setPayTime(rs.getString(14));
                somain.setPayUser(rs.getString(15));
                somain.setPrePayTime(rs.getString(16));
                somain.setPrePayUser(rs.getString(17));
                somain.setEndTime(rs.getString(18));
                somain.setEndUser(rs.getString(19));
                somainList.add(somain);
            }
        } catch (SQLException e)
        {
            System.out.println("DAO SomainDao " + e.getMessage());
            System.out.println("DAO SomainDao " + e.getCause());
        }
        DBCon.close();
        return somainList;
    }

}

