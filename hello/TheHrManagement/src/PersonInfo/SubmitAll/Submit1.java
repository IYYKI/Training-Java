package PersonInfo.SubmitAll;

import java.sql.*;

public class Submit1 {
    public void tijiao(String Wno, String Wname, String Waddress, String Wphoneno, String Wdepart,
                       String Wsalary, String Wtime, String Woccup) throws Exception {
        String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:redsun";

        Class.forName(JDriver);
        // Connect the ODBC resource.
        Connection con = DriverManager.getConnection(connectionURL);
        Statement stmt = con.createStatement();
        System.out.println("连接数据库成功!");
        String query1 = "update  员工信息 set 姓名= '" + Wname + "',地址='" + Waddress + "'," +
                "电话= '" + Wphoneno + "',部门='" + Wdepart + "'+工资= '" + Wsalary + "',参加工作时间='" + Wtime + "'," +
                "职务='" + Woccup + "'" + " where 职工号='" + Wno + "'";
        System.out.println("******" + Wname + " " + Waddress + " " + Wphoneno + " " + Wdepart + " " + Wsalary
                + " " + Wtime + " " + Woccup);
        stmt.executeUpdate(query1);

        stmt.close();
        con.close();
    }
}