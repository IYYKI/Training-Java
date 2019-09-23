package PersonInfo.AddAll;

import java.sql.*;

public class Add {

    public void tianjia(String Wno, String Wname, String Waddress, String Wphoneno, String Wdepart, String Wsalary
            , String Wtime, String Woccup) throws Exception {


        String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:redsun";


        Class.forName(JDriver);
        // Connect the ODBC resource.
        Connection con = DriverManager.getConnection(connectionURL);
        System.out.println("******数据库连接成功！");
        String str = "insert into 员工信息(职工号,姓名,地址,电话,部门,工资,参加工作时间,职务) values(?,?,?,?,?,?,?,?)";
        PreparedStatement prep = con.prepareStatement(str);
        prep.setString(1, Wno);
        prep.setString(2, Wname);
        prep.setString(3, Waddress);
        prep.setString(4, Wphoneno);
        prep.setString(5, Wdepart);
        prep.setString(6, Wsalary);
        prep.setString(7, Wtime);
        prep.setString(8, Woccup);
        prep.executeUpdate();
        con.close();
    }
}