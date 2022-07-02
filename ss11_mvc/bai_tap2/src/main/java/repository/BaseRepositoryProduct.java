package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepositoryProduct {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo3";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0934857429z";
    private static Connection connection;

    public BaseRepositoryProduct() {

    }

    public Connection getConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
