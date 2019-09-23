package MT.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MT.model.Cart;
import MT.util.DBUtil;

public class AddCartDao {

    public ArrayList<Cart> selectCart(String account) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cart> array = new ArrayList();
        try {
            con = DBUtil.getCon();
            String sql = "select * from cart where account=? and status=0";
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("cartid");
                int fid = rs.getInt("foodid");
                String acc = rs.getString("account");
                array.add(new Cart(cid, acc, fid));

            }
            return array;
        } finally {
            DBUtil.close(null, ps, con);
        }

    }
    public boolean settleCart(String account, int cartid) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getCon();
            String sql = "update cart status=1 where account=? and cartid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.setInt(2, cartid);
            return ps.execute();

        } finally {
            DBUtil.close(null, ps, con);
        }
    }
    public boolean deleteCart(String account, int cartid) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getCon();
            String sql = "delete from cart where account=? and cartid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.setInt(2, cartid);
            return ps.execute();

        } finally {
            DBUtil.close(null, ps, con);
        }
    }
    public boolean AddCart(String account, int fooid) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getCon();
            String sql = "insert into cart(account,foodid) values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.setInt(2, fooid);
            return ps.execute();

        } finally {
            DBUtil.close(null, ps, con);
        }
    }
}
