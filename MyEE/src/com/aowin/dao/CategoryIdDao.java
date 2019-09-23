package com.aowin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aowin.model.CategoryId;
import com.aowin.util.DBConnection;

public class CategoryIdDao
{
    public boolean deleteCategory(String id){
        boolean flag=false;
        DBConnection DBCon = new DBConnection();
        String sql="delete from category where CategoryID="+id;
        int i=DBCon.executeUpdate(sql);
        if(i!=0){
            flag=true;
        }
        DBCon.close();
        return flag;
    }

    public boolean modifyCategory(String id,String name,String remark){
        boolean flag=false;
        DBConnection DBCon = new DBConnection();
        String sql="update category set Name='"+name+"',Remark='"+remark+"' where CategoryID="+id;
        int i=DBCon.executeUpdate(sql);
        if(i!=0){
            flag=true;
        }
        DBCon.close();
        return flag;
    }

    public boolean addNewCategoryId(String id,String name,String remark){
        boolean flag=false;
        DBConnection DBCon = new DBConnection();
        String sql="insert into category values ("+Integer.parseInt(id)+",'"+name+"','"+remark+"')";
        int i=DBCon.executeUpdate(sql);
        if(i!=0){
            flag=true;
        }
        DBCon.close();
        return flag;
    }



    public String getlastCategoryId(){
        String id;
        DBConnection DBCon = new DBConnection();
        String sql="select CategoryID from category group by CategoryID";
        ResultSet rs=DBCon.executeQuery(sql);
        try
        {
            if(rs.last()){
                id=rs.getString(1);
            }else{
                id="";
            }
            DBCon.close();
            return id;
        } catch (SQLException e)
        {
            System.out.println("DAO CategoryIdDao " + e.getMessage());
            System.out.println("DAO CategoryIdDao " + e.getCause());
        }
        return "";

    }
    @SuppressWarnings("unchecked")
    public List getAll()
    {
        DBConnection DBCon = new DBConnection();
        List<CategoryId> list = new ArrayList<CategoryId>();
        String sql="select * from category";
        ResultSet rs=DBCon.executeQuery(sql);
        try
        {
            while (rs.next()){
                CategoryId categoryId = new CategoryId();
                categoryId.setId(rs.getString(1));
                categoryId.setName(rs.getString(2));
                categoryId.setRemark(rs.getString(3));
                list.add(categoryId);
            }
        } catch (SQLException e)
        {
            System.out.println("DAO CategoryIdDao " + e.getMessage());
            System.out.println("DAO CategoryIdDao " + e.getCause());
        }
        DBCon.close();
        return list;

    }
}
