package controller;

import JDBC_api.DBHandler;

import java.sql.SQLException;

public class DisplayManager {

    private DBHandler dbHandler;

    public DisplayManager() {
        dbHandler = new DBHandler();
    }

    public void getFlavourInfo(String flavour) throws SQLException {
        //check if flavour exists in DB

        //conditional statement: if flavour exists get other info from DB

        //update interface variables with obtained data

        //update comment with performed action

    }

    public void getCurrentRanking() throws SQLException {
        //get data from DB

        //check data length (if smaller than 3 then, add default text)

        //update interface variables with obtained data

        //update comment with performed action

    }

    public void addNewFlavour() throws SQLException {
        //create new row for each table with given data

        //update comment with performed action

    }

}
