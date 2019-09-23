package ClassWorks.Servlet.Day_8_29_WorkOne.Dao;
import ClassWorks.Servlet.Day_8_29_WorkOne.Util.DBUtil;
import ClassWorks.Servlet.Day_8_29_WorkOne.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User selectByUserAndPwd(String account, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from people where account=? and password=?";
        try {
            con = DBUtil.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()) {
                user = new User();
                user.setUsername(rs.getString("account"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                if(rs.getInt("sex")==0) {
                    user.setSex("girl");
                }else {
                    user.setSex("man");
                }
                user.setCareer(rs.getString("professional"));
                user.setSalary(rs.getInt("salary"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, con);
        }
        return user;
    }
}
