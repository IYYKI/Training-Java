package ClassWorks.Servlet.Day_8_29_WorkOne.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    //将加载驱动  获得连接  关闭连接 封装在该类中
    //加载驱动只要执行一次就可
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载 成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获得连接对象的方法
    public static Connection getCon() throws SQLException {
        Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/yyk", "root", "123456");
        return con;
    }

    //关闭数据库连接
    public static void close(ResultSet rs,Statement ps,Connection con) {
        try {

            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null) con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}