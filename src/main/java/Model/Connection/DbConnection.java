package Model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://194.67.105.79:5432/library_films_test_db", "library_films_test", "12345");
    }

    public Connection getConnection() {
        return connection;
    }

    private static DbConnection instance = null;

    public static DbConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }
}
