package PersonInfo.SubmitAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Submit {
    public void tijiao(String WTextField, String XTextField,
                       String X1TextField) throws Exception {
        String JDriver = "sun.jdbc.odbc.jdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:redsun";
        Class.forName(JDriver);
        Connection con = DriverManager.getConnection(connectionURL);
        Statement stmt = con.createStatement();
        System.out.println("连接数据库成功!");
        String query1 =
                "update 系统用户 set 密码 = " + XTextField + ",用户类 = '" + X1TextField + "'" + " where 职工号 = '" + WTextField + "'";
        System.out.println("******" + XTextField + " " + X1TextField);
        stmt.executeQuery(query1);
        stmt.close();
        con.close();
    }
}
