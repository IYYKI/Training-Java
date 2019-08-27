package PersonInfo.AddAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Add1 {
    public void tianjia(String Wno,String Wpwd,
                        String Wuserclass)throws Exception{
        String JDriver = "sun.dbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:redsun";
        Class.forName(JDriver);
        Connection con = DriverManager.getConnection(connectionURL);
        String query1 = "insert into 系统用户(职工号,密码,用户类)values(?,?,?)";
        PreparedStatement prep = con.prepareStatement(query1);
        prep.setString(1,Wno);
        prep.setString(2,Wpwd);
        prep.setString(3,Wuserclass);
        prep.executeUpdate();
        con.close();
    }
}
