package MT.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MT.util.DBUtil;

public class UserDao {
    //登录 user
    public Object[] queryAll(String account,String password) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Object[] objects=new Object[4];
        objects[0]=false;
        objects[1]=account;
        objects[2]=password;
        try {
            con = DBUtil.getCon();
            String sql = "select * from user where account=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                String pass = rs.getString("password");
                objects[3]=rs.getString("name");
                if (pass.equals(password)) {
                    objects[0]=true;
                    return objects;
                }else {
                    return objects;
                }
            }
            return objects;
        } finally {
            DBUtil.close(rs, ps, con);
        }
    }
}
