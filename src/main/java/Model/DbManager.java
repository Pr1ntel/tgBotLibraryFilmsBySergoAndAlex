package Model;

import Model.Connection.DbConnection;
import Model.Tables.TableFilms;
import Model.Tables.TableStyleFilms;

import java.sql.Connection;
import java.sql.SQLException;

public class DbManager {
    private TableStyleFilms tableStyleFilms;
    private TableFilms tableFilms;

    private DbManager() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        tableFilms = new TableFilms(connection);
        tableStyleFilms = new TableStyleFilms(connection);
    }

    public TableStyleFilms getTableStyleFilms() {
        return tableStyleFilms;
    }

    public TableFilms getTableFilms() {
        return tableFilms;
    }

    private static DbManager instance;

    public static DbManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbManager();
        }
        return instance;
    }
}
