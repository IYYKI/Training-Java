package com.aowin.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public addServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        this.doPost(request, response);
        out.flush();
        out.close();
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     * 1	CustomerCode	客户编号	VARCHAR(20)
     * 2	Name	名称	VARCHAR(100)
     * 3	Password	密码	VARCHAR(20)
     * 4	Contactor	联系人	VARCHAR(10)
     * 5	Address	地址	VARCHAR(100)
     * 6	Postcode	邮政编码	VARCHAR(8)
     * 7	Tel	电话	VARCHAR(20)
     * 8	Fax	传真	VARCHAR(20)
     * 9	CreateDate	创建日期	VARCHAR(20)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("到了Servlet！！！");
        response.setContentType("text/html;charset=gb2312");
        request.setCharacterEncoding("gb2312");
        PrintWriter out = response.getWriter();
        String CustomerCode = request.getParameter("coustomercode");   //获取客户编号
        String Name = request.getParameter("name");    //获取姓名
        String Contactor = request.getParameter("contactor");//获取联系人
        String Address = request.getParameter("address"); //获取地址
        String Postcode = request.getParameter("postcode"); //获取邮政编码
        String Tel = request.getParameter("tel"); //获取联系方式
        String Fax = request.getParameter("fax"); //获取传真
        String CreatDate = request.getParameter("careateDate");//获取创建日期
        Connection conn = null; //声明一个Connection对象，用来连接数据库
        PreparedStatement pstmt = null; //声明PreparedStatement对象，用来向数据库插入数据条数据
        try {
            //连接到MySQL数据库中的bank数据库模式
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("创建驱动成功！");
            //连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scm", "root", "123456");
            System.out.println("连接数据库成功！");
            //插入数据的SQL语句
            String sql = "INSERT INTO Customer() VALUES(?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            //设置插入数据的顺序
            pstmt.setString(1, CustomerCode);
            pstmt.setString(2, Name);
            pstmt.setString(3, Contactor);
            pstmt.setString(4, Address);
            pstmt.setString(5, Postcode);
            pstmt.setString(6, Tel);
            pstmt.setString(7, Fax);
            pstmt.setString(8, CreatDate);
            int result = pstmt.executeUpdate();
            //判断执行结果
            if (result == 1) {
                out.print("插入数据成功！");
            }else {
                out.print("插入数据失败！请重新插入！");
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
