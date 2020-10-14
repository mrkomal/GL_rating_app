package JDBC_api.connection;

import file_reader.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection implements IConnection {

    private ArrayList<String> properties;

    public DBConnection(){
        FileReader reader = new FileReader("C:\\Users\\admin\\Desktop\\java\\database_info.txt");
        this.properties = reader.read();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(setDatabaseURL(), setUserName(), setPassword());
    }

    @Override
    public String setDatabaseURL() {
        String databaseURL = "jdbc:mysql://localhost:3306/gl_ranking";
        return databaseURL;
    }

    @Override
    public String setUserName() {
        return properties.get(0);
    }

    @Override
    public String setPassword() {
        return properties.get(1);
    }

}
