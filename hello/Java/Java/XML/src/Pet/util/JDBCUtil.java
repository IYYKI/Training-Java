package Pet.util;



import Pet.Model.User;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/yyk";
    public static String USERNAME = "root";
    public static String PASSWORD = "123456";
    private static Connection connection = null;
    private static String USER = "Pet.Model.User";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //运行方法
    public static void run(Connection connection)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ArrayList<String> arrayList = getArr();
        boolean check = checkName(connection, arrayList.get(0));
        if (check) {
            if (checkPassword(connection, arrayList.get(0), arrayList.get(1))) {
                selectUser(connection, arrayList.get(0));
            } else {
                System.err.println("密码错误!!!");
                return;
            }

        } else {
            System.err.println("该用户不存在,是否创建新用户? 请输入  		是   	或   	否");
            String string = new Scanner(System.in).next();
            if (string.equals("是")) {
                setUser(arrayList, connection);
            }
            System.err.println("已退出");
        }

    }

    //设置值方法
    public static String setValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入:		");
        return scanner.next();

    }

    // 小查询
    public static ArrayList<String> getArr()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(USER);
        Field[] fields = clazz.getDeclaredFields();
        User user = (User) clazz.newInstance();
        ArrayList<String> array = new ArrayList<String>(fields.length);
        for (int i = 0; i < 2; i++) {
            System.out.print(fields[i].getName() + "       ");
            fields[i].setAccessible(true);
            String str = setValue();
            fields[i].set(user, str);
            array.add(str);
        }

        return array;
    }

    //返回对象属性值的数组
    public static ArrayList<String> getArray()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(USER);
        Field[] fields = clazz.getDeclaredFields();
        User user = (User) clazz.newInstance();
        ArrayList<String> array = new ArrayList<String>(fields.length);
        for (Field field : fields) {
            System.out.print(field.getName() + "       ");
            field.setAccessible(true);
            String str = setValue();
            field.set(user, str);
            array.add(str);

        }

        return array;
    }

    //PrepareStatement 修改SQL语句占位符 添加用户
    public static void setUser(ArrayList<String> str, Connection connection) throws SQLException {
        String sql = "insert into user(Username,passwd,name,birthday,bobby,address,telephone)values(?,?,?,?,?,?,?)";
        PreparedStatement pS = connection.prepareStatement(sql);

        try {
            for (int i = 1; i <= str.size(); i++) {
                pS.setString(i, str.get(i - 1));
            }
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("异常!");

        }

    }

    //用户存在 查询出其信息并输出
    public static void selectUser(Connection connection, String name) throws SQLException {
        String sql = "select * from user where name=?";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setString(1, name);
        ResultSet r = pS.executeQuery();
        while (r.next()) {
            for (int i = 1; i < 8; i++) {
                System.out.print(r.getString(i) + "		");
            }

        }

    }

    //判断是否有用户
    public static boolean checkName(Connection connection, String name) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select name from user");
        while (resultSet.next()) {
            if (name.equals(resultSet.getString(1))) {
                System.out.println("存在该用户!");
                return true;
            }
        }
        statement.close();
        return false;
    }


    //判断密码正确
    public static boolean checkPassword(Connection connection, String name, String password) throws SQLException {
        PreparedStatement st = connection.prepareStatement("select password from user where name=?");
        st.setString(1, name);
        ResultSet resultSet = st.executeQuery();
        while (resultSet.next()) {
            if (password.equals(resultSet.getString(1))) {
                System.out.println("密码正确!");
                return true;
            }

        }
        st.close();
        return false;
    }

}
