package JDBC_api;

import JDBC_api.connection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DBHandler {

    private Connection connection;

    public void establishConnection() throws SQLException {
        this.connection = new DBConnection().getConnection();
    }

    public void closeConnection() throws SQLException {
        if(this.connection != null) {
            connection.close();
        }
    }
}
