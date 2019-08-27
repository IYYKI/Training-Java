package dao;


import model.Staff;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesDao {

    //查询所有
    public ArrayList<Staff> selectAll(){
        String sql = "select * from staff";
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Staff> al = new ArrayList<>();
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Staff st = new Staff();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setDepartment(rs.getString("department"));
                st.setSalary(rs.getInt("salary"));
                int sexNumber = rs.getInt("sex");
                if(sexNumber==0) {
                    st.setSex("女");
                }else {
                    st.setSex("男");
                }
                al.add(st);
            }
            return al;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return al;
    }

    //根据sql 查询
    public ArrayList<Staff> selectBySql(String sql){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Staff> al = new ArrayList<>();
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Staff st = new Staff();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setDepartment(rs.getString("department"));
                st.setSalary(rs.getInt("salary"));
                int sexNumber = rs.getInt("sex");
                if(sexNumber==0) {
                    st.setSex("女");
                }else{
                    st.setSex("男");
                }
                al.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return al;
    }

    //根据id 查询数据库中是否已存在,返回布尔类型
    public Boolean selectIsExist(int id) {
        String sql = "select id from staff where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return false;
    }

    //根据id 查询数据库中是否已存在,id
    public int selectExist(int id) {
        String sql = "select id from staff where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idExist = -1;
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                idExist = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return idExist;
    }

    //添加至数据库
    public void addStaff(Staff staff) {
        String sql = "insert into staff values(?,?,?,?,?)";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);

            ps.setInt(1, staff.getId());
            ps.setString(2, staff.getName());
            String s = staff.getSex();
            int sex = -1;
            if("男".equals(s)) {
                sex = 1;
            }else if("女".equals(s)) {
                sex = 0;
            }
            ps.setInt(3, sex);
            ps.setString(4, staff.getDepartment());
            ps.setInt(5, staff.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, ps, con);
        }
    }

    //根据ID删除
    public void deleteById(int id) {
        String sql = "delete from staff where id=?";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, ps, con);
        }
    }

    //根据ID修改
    public void updateById(Staff staff,int idOld) {
        String sql = "update staff set id=?,name=?,sex=?,department=?,salary=? where id=?";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, staff.getId());
            ps.setString(2, staff.getName());
            String s = staff.getSex();
            int sex = -1;
            if("男".equals(s)) {
                sex = 1;
            }else if("女".equals(s)) {
                sex = 0;
            }
            ps.setInt(3, sex);
            ps.setString(4, staff.getDepartment());
            ps.setInt(5, staff.getSalary());
            ps.setInt(6, idOld);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, ps, con);
        }
    }


}

