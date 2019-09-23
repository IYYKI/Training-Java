package PersonInfo.AddAll;

import java.sql.*;

public class Add1 {
    public void tianjia(String Wno, String Wpwd, String Wuserclass) throws Exception {


        String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:redsun";


        Class.forName(JDriver);
        // Connect the ODBC resource.
        Connection con = DriverManager.getConnection(connectionURL);
        String query1 = "insert into 系统用户(职工号,密码,用户类) values(?,?,?)";
        PreparedStatement prep = con.prepareStatement(query1);
        prep.setString(1, Wno);
        prep.setString(2, Wpwd);
        prep.setString(3, Wuserclass);
        prep.executeUpdate();
        con.close();
    }
}