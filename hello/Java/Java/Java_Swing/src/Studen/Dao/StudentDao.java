package Studen.Dao;

import Studen.DBUtil.DBUtil;
import Studen.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

    public Student selectByStuno(int id) {
        String sql = "select * from student where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student stu = null;
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                stu = new Student();
                stu.setId(id);
                stu.setName(rs.getString("name"));
                stu.setClassRoom(rs.getString("ClassRoom"));
                stu.setResults(rs.getDouble("results"));
                return stu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return stu;
    }
}

