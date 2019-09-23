package MT.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MT", "root", "123456");
        return con;
    }

    public static void close(ResultSet rs,Statement ps,Connection con) {
        try {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null) con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}