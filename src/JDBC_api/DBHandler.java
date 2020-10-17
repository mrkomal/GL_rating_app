package JDBC_api;

import JDBC_api.connection.DBConnection;
import JDBC_api.models.FlavourInfoModel;
import JDBC_api.models.NewFlavourModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHandler {

    private Connection connection;

    public int getFlavourID(String flavour) throws SQLException {
        String query = "SELECT id FROM ice_cream_flavours WHERE flavour = \"%s\"";
        query = String.format(query, flavour);

        establishConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int id = -1;
        if(rs.next()) {
            id = rs.getInt("id");
        }
        closeConnection();

        return id;
    }

    public FlavourInfoModel getFlavourInfo(int ID) throws SQLException {
        String query = "SELECT fr.rate, pi.purchase_date, fi.info "
                        +"FROM flavour_rates fr "
                        +"INNER JOIN purchase_info pi "
                            +"USING(id) "
                        +"INNER JOIN flavours_info fi "
                            +"USING(id) "
                        +"WHERE id = %d";
        query = String.format(query, ID);

        establishConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        FlavourInfoModel newModel = new FlavourInfoModel();
        if(rs.next()) {
            int id = rs.getInt("rate");
            String date = rs.getDate("purchase_date").toString();
            String desc = rs.getString("info");
            newModel.setFlavourInfoModel(String.valueOf(id), date, desc);
        }
        closeConnection();

        return newModel;
    }

    public void addNewFlavour(NewFlavourModel newFlavourModel) throws SQLException {
        ArrayList<String> queries = new ArrayList<>();
        queries.add(String.format("INSERT INTO ice_cream_flavours VALUES(DEFAULT, \"%s\")",
                newFlavourModel.getName()));
        queries.add(String.format("INSERT INTO flavour_rates VALUES(LAST_INSERT_ID(), %d)",
                newFlavourModel.getRate()));
        queries.add("INSERT INTO purchase_info VALUES(LAST_INSERT_ID(), CURDATE())");
        queries.add(String.format("INSERT INTO flavours_info VALUES(LAST_INSERT_ID(), \"%s\")",
                newFlavourModel.getDescription()));

        establishConnection();
        for (String query : queries) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        closeConnection();
    }

    public ArrayList<String> getRanking(int numOfPositions) throws SQLException {
        String query = "SELECT fr.rate, icf.flavour "
                        +"FROM flavour_rates fr "
                        +"INNER JOIN ice_cream_flavours icf "
                            +"USING(id) "
                        +"ORDER BY fr.rate DESC "
                        +"LIMIT %d;";
        query = String.format(query, numOfPositions);

        establishConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<String> flavours = new ArrayList<>();

        while(rs.next()) {
            flavours.add(rs.getString("flavour"));
        }
        closeConnection();

        return flavours;
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
