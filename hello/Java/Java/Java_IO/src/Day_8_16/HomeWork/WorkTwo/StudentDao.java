package Day_8_16.HomeWork.WorkTwo;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Day_8_16.HomeWork.utl.DBUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class StudentDao {


    public void addAllStudent(File file) {
        String sql="insert into student values(?,?,?,?)";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            Document document = new SAXReader().read(file);
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            for(Element ele:list) {
                int id = Integer.valueOf(ele.attributeValue("id"));
                String name = ele.elementText("name");
                String sex = ele.elementText("sex");
                int age = Integer.valueOf(ele.elementText("age"));
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, sex);
                ps.setInt(4, age);
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, ps, con);
        }
    }

    public ArrayList<Student> selectAllStudent(File file) {
        ArrayList<Student> al = new ArrayList<>();
        String sql="select * from student";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setSex(rs.getString("sex"));
                s.setAge(rs.getInt("age"));
                al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return al;
    }

}
