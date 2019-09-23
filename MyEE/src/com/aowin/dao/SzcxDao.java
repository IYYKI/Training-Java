package com.aowin.dao;

import com.aowin.model.Szcx;
import com.aowin.util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SzcxDao
{
    @SuppressWarnings("unchecked")
    public List search(String startTime, String endTime, String inOrOut,
                       String payType, String id)
    {

        DBConnection DBCon = new DBConnection();
        List<Szcx> list = new ArrayList<Szcx>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = sdf.format(new Date());
        String sql;
        String poid;
        String startTimex;
        String endTimex;
        String payTypex;
        if (startTime == null || startTime.equals(""))
        {
            startTimex = "1945-10-01";
        } else
        {
            startTimex = startTime;
        }
        if (endTime == null || endTime.equals(""))
        {
            endTimex = nowTime;
        } else
        {
            endTimex = endTime;
        }
        if (payType == null)
        {
            payTypex = "";
        } else
        {
            payTypex = payType;
        }
        if (id == null || id.equals(""))
        {
            poid = "";
        } else
        {
            poid = id;
        }
        if (inOrOut.trim().equals("in"))
        {
            sql = "select * from pomain where CreateTime >='" + startTimex
                    + "' and CreateTime<='" + endTimex
                    + "' and PayType like '%" + payTypex
                    + "%' and POID like '%" + poid + "%'";
        } else
        {
            sql = "select * from somain where CreateTime >='" + startTimex
                    + "' and CreateTime<='" + endTimex
                    + "' and PayType like '%" + payTypex
                    + "%' and SOID like '%" + poid + "%'";
        }


        ResultSet rs = DBCon.executeQuery(sql);
        try
        {
            while (rs.next())
            {
                Szcx s = new Szcx();
                s.setId(rs.getString(1));
                s.setMomey(rs.getString("POTotal"));
                s.setPayType(rs.getString("PayType"));
                s.setTime(rs.getString("CreateTime"));
                s.setUser(rs.getString("StockUser"));
                list.add(s);
            }
        } catch (SQLException e)
        {
            System.out.println("DAO getUsers " + e.getMessage());
            System.out.println("DAO getUsers " + e.getCause());
        }
        DBCon.close();
        return list;

    }
}
