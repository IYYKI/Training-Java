package PersonInfo.SubmitAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Submit1 {
    public void tijiao(String Wno, String Wname, String Waddress, String Wphoneno, String Wdepart
    ,String Wsalary,String Wtime,String Woccup)throws Exception {
        String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String connectionURL = "jdbc:odbc:redsun";
        Class.forName(JDriver);
        Connection con = DriverManager.getConnection(connectionURL);
        Statement stmt = con.createStatement();
        System.out.println("连接数据库成功");
        String query1 = "update 员工信息 set 姓名 = '"+Wname+"',地址='"+Waddress+"',"+
                "电话='"+Wphoneno+"',部门="+Wdepart+"'+工资='"+Wsalary+"',工龄='"+Wtime+"',"+"职务='"+Woccup+"'"+
                " where 职工号='"+Wno+"";
        stmt.executeQuery(query1);
        stmt.close();
        con.close();
}
}
