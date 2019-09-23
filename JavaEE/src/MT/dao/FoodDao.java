package MT.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MT.model.Food;
import MT.util.DBUtil;

public class FoodDao {
    //查询 所有食品的方法
    public ArrayList<Food> queryAll() throws SQLException{
        ArrayList<Food> al=new ArrayList<>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from food";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int fid = rs.getInt("foodid");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String pic = rs.getString("pic");
                al.add(new Food(fid, name, price, pic));
            }
            return al;
        } finally {
            DBUtil.close(rs, ps, con);
        }
    }
    public ArrayList<Food> query(int foodid) throws SQLException{
        ArrayList<Food> al=new ArrayList<>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from food where foodid=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, foodid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int fid = rs.getInt("foodid");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String pic = rs.getString("pic");
                al.add(new Food(fid, name, price, pic));
            }
            return al;
        } finally {
            DBUtil.close(rs, ps, con);
        }
    }
}
