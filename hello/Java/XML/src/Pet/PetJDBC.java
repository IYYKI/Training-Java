package Pet;

import Pet.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;


public class PetJDBC {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        try {
            connection = JDBCUtil.getConnection();
            JDBCUtil.run(connection);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {

            connection.close();

        }

    }
}
