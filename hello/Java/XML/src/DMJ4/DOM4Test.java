package DMJ4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4Test {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/YYK?useUnicode=true&characterEncoding=utf-8";
    public static String USERNAME = "root";
    public static String PASSWORD = "123456";
    private static Connection connection = null;
    private static String PET = "DMJ4.Pet";

    public static void write(File file, ArrayList<Pet> arrayList) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element pets = document.addElement("pets");
        for (Pet p : arrayList) {
            Element pet = pets.addElement("pet");
            pet.addAttribute("id", String.valueOf(p.getId()));
            pet.addElement("name").setText(p.getName());
            double d = p.getPrice();
            pet.addElement("price").setText(String.valueOf(d));
            pet.addElement("species").setText(p.getSpecies());
            pet.addElement("color").setText(p.getColor());
        }
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
        document.write(out);
        out.flush();
        out.close();
    }

    public static ArrayList<Pet> read(File file) {
        SAXReader r = new SAXReader();
        ArrayList<Pet> arrayList = new ArrayList<Pet>();
        try {

            Document document = r.read(file);
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            for (Element ele : list) {
                Pet pet = new Pet();

                String id = ele.attributeValue("id");
                List<Element> list2 = ele.elements();

                pet.setId(Integer.valueOf(id));
                pet.setName(list2.get(0).getText());
                pet.setColor(list2.get(3).getText());
                pet.setPrice(Double.valueOf(list2.get(1).getText()));
                pet.setSpecies(list2.get(2).getText());
                arrayList.add(pet);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    // 更新
    public static void retrunData(Connection connection, ArrayList<Pet> arrayList)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sql = "insert into pet_shop(id,name,color, price,species)values(?,?,?,?,?)";
        String sql2 = "update pet_shop set name=?,color=?,price=?,species=? where id = ?";
        PreparedStatement pS = connection.prepareStatement(sql2);
        for (int i = 0; i < arrayList.size(); i++) {
            pS.setInt(5, arrayList.get(i).getId());
            pS.setString(1, arrayList.get(i).getName());
            pS.setString(2, arrayList.get(i).getColor());
            pS.setDouble(3, arrayList.get(i).getPrice());
            pS.setString(4, arrayList.get(i).getSpecies());
            pS.execute();
        }

    }

    // 查询所有
    public static ArrayList<Pet> getArray(Connection connection)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> clazz = Class.forName(PET);
        Field[] fields = clazz.getDeclaredFields();
        ArrayList<Pet> array = new ArrayList<Pet>(fields.length);
        String sql = "select * from pet_shop";
        PreparedStatement pS = connection.prepareStatement(sql);
        ResultSet r = pS.executeQuery();
        while (r.next()) {
            Pet pet = (Pet) clazz.newInstance();
            for (int i = 1; i < 6; i++) {
                fields[i - 1].setAccessible(true);
                if (i == 1) {
                    fields[i - 1].set(pet, Integer.valueOf(r.getString(i)));
                } else if (i == 4) {

                    fields[i - 1].set(pet, Double.valueOf(r.getString(i)));

                } else {
                    fields[i - 1].set(pet, r.getString(i));
                }

            }
            array.add(pet);
            System.out.println();
        }

        return array;
    }

    //主方法
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        File file = new File("/Users/yao/IdeaProjects/hello/Java/XML/src/DMJ4/pet.xml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        // From DataBases
        try {

            ArrayList<Pet> arrayList = getArray(connection);
            write(file, arrayList);

        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
//From XML
        try {
            ArrayList<Pet> array = read(file);
            System.out.println(array.size());
            for (Pet pet : array) {
                System.out.println(pet);
            }
            retrunData(connection, array);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }

    }
}
