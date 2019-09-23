package Pet.util;



import Pet.Dog.Pet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetUtil {

    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/yyk?useUnicode=true&characterEncoding=utf-8";
    public static String USERNAME = "root";
    public static String PASSWORD = "123456";
    private static Connection connection = null;
    private static String PET = "Pet.Dog.Pet";

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

    // ???????????
    public static void addObject(Connection connection)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ArrayList<String> arrayList = getArray();

        setPet(arrayList, connection);

    }

    //???????
    public static void deletePet(int id, Connection connection) throws SQLException {
        String sql = "delete  from pet_shop  where id = ?";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setInt(1, id);

        int result = pS.executeUpdate();
        System.out.println(result);
    }

    //??????
    public static void changePrice(Double dou) throws SQLException {
        String sql = "update  pet_shop set price=? where species='dog'";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setDouble(1, dou);
        pS.execute();
        System.out.println();
    }



    // ?????????
    public static String setValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入:		");
        return scanner.next();

    }

    // ??????????????????
    public static ArrayList<String> getArray()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(PET);
        Field[] fields = clazz.getDeclaredFields();
        Pet pet = (Pet) clazz.newInstance();
        ArrayList<String> array = new ArrayList<String>(fields.length);
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i].getName() + "       ");
            fields[i].setAccessible(true);
            String str = setValue();
            if (i == 0) {
                fields[i].set(pet, Integer.valueOf(str));

            } else if (i == 3) {
                fields[i].set(pet, Double.valueOf(str));

            } else {
                fields[i].set(pet, str);
            }
            array.add(str);
        }

        return array;
    }

    // PrepareStatement ???SQL????λ?? ??????
    public static void setPet(ArrayList<String> str, Connection connection) throws SQLException {
        String sql = "insert into pet_shop(id,name,color,price,species)values(?,?,?,?,?)";
        PreparedStatement pS = connection.prepareStatement(sql);

        try {
            for (int i = 1; i <= str.size(); i++) {
                if (i==1){
                    pS.setInt(i,Integer.valueOf(str.get(i-1)));
                }else if (i==4){
                    pS.setDouble(i,Double.valueOf(str.get(i-1)));
                }else

                pS.setString(i, str.get(i - 1));
            }
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("!");

        }

    }

    // ID??????
    public static void selectID(Connection connection, int id) throws SQLException {
        String sql = "select * from pet_shop where id=?";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setInt(1, id);
        ResultSet r = pS.executeQuery();
        while (r.next()) {
            for (int i = 1; i < 6; i++) {
                System.out.print(r.getString(i) + "		");
            }
            System.out.println();

        }

    }

    // ?????????
    public static void selectColor(Connection connection, String color) throws SQLException {
        String sql = "select * from pet_shop where color= ?";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setString(1, color);
        ResultSet r = pS.executeQuery();
        while (r.next()) {
            for (int i = 1; i < 6; i++) {
                System.out.print(r.getString(i) + "		");
            }
            System.out.println();
        }

    }

    // ?????????
    public static void selectName(Connection connection, String name) throws SQLException {
        String sql = "select * from pet_shop where name=?";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setString(1, name);
        ResultSet r = pS.executeQuery();
        while (r.next()) {
            for (int i = 1; i < 6; i++) {
                System.out.print(r.getString(i) + "		");
            }

        }
        System.out.println();

    }

    // ?????????
    public static void selectSpeices(Connection connection, String species) throws SQLException {
        String sql = "select * from pet_shop where species=?";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setString(1, species);
        ResultSet r = pS.executeQuery();
        while (r.next()) {
            for (int i = 1; i < 6; i++) {
                System.out.print(r.getString(i) + "		");
            }
            System.out.println();
        }

    }

}
