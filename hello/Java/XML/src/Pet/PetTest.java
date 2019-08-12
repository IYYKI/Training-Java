package Pet;

import Pet.util.PetUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class PetTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        connection = PetUtil.getConnection();
        try {
            // 添加数据库对象
            System.out.println("添加数据库对象");
            PetUtil.addObject(connection);
            // 删除数据库对象
        //    PetUtil.deletePet(1, connection);
            PetUtil.changePrice(567.65);
            System.out.println("颜色查询");
            PetUtil.selectColor(connection, "red");
            System.out.println("ID查询");
            PetUtil.selectID(connection, 2);
            System.out.println("名字查询");
            PetUtil.selectName(connection, "d");
            System.out.println("种类查询");
            PetUtil.selectSpeices(connection, "dog");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
