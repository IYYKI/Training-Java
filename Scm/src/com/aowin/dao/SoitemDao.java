package com.aowin.dao;

import com.aowin.model.Soitem;
import com.aowin.util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SoitemDao
{
    public Soitem getSoitemBySoid(int soid)
    {
        Soitem soItem = new Soitem();
        DBConnection DBCon = new DBConnection();
        String sql="select * from soitem where SOID="+soid;
        ResultSet rs=DBCon.executeQuery(sql);
        try
        {
            if (rs.next()){
                soItem.setSoid(rs.getInt(1));
                soItem.setProductCode(rs.getString(2));
                soItem.setUnitPrice(rs.getFloat(3));
                soItem.setNum(rs.getInt(4));
                soItem.setUnitName(rs.getString(5));
                soItem.setItemPrice(rs.getFloat(6));
            }
        } catch (SQLException e)
        {
            System.out.println("DAO SoitemDao " + e.getMessage());
            System.out.println("DAO SoitemDao " + e.getCause());
        }
        DBCon.close();
        return soItem;
    }
}

