package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0934857429z";
    private static Connection connection;

    public BaseRepository() {

    }

    public Connection getConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return connection;
    }

}
