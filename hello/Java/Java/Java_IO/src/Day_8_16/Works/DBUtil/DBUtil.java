package Day_8_16.Works.DBUtil;

import Day_8_16.Works.MyDataBase.Database;

import java.sql.*;


public class DBUtil {


    public static Connection getCon(Database db) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(db.getPassword()+db.getUrl()+db.getUser());
        Connection con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());

        System.out.println(db);
        return con;

    }

//    public static void close(ResultSet rs, Statement ps, Connection con) {
//
//        try {
//             rs.close();
//            if (ps != null)   ps.close();
//            if (con != null)  con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

}

