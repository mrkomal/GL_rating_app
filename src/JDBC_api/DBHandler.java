package JDBC_api;

import JDBC_api.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {

    private Connection connection;

    public int getIceCreamID(String name) throws SQLException {
        String query = "SELECT id FROM ice_cream_flavours WHERE flavour = \"%s\"";
        query = String.format(query, name);

        establishConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int id = -1;
        if(rs.next()) {
            id = rs.getInt("id");
        }
        closeConnection();

        System.out.println(id);
        return id;
    }

    private void establishConnection() throws SQLException {
        this.connection = new DBConnection().getConnection();
    }

    private void closeConnection() throws SQLException {
        if(this.connection != null) {
            connection.close();
        }
    }

}
