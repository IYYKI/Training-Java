package Util;

import java.sql.*;

    public class DBUtil{

        static {
            try {
                // 1.选择驱动 Driver------(Class.forName)
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // 2.连接 Connection------(DriverManager.getConnection)
        public static Connection getCon() throws SQLException {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yyk",
                    "root", "123456");
            return con;
        }

        // 3.关闭数据库的连接(先执行的最后关闭) 进入顺序：con,ps,rs 注:PreParedStatement是Statement的子类，所以传参可用父类（多态）
        public static void close(ResultSet rs, Statement ps, Connection con) {

            try {
                if (rs != null)   rs.close();
                if (ps != null)   ps.close();
                if (con != null)  con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

