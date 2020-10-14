package controller;

import JDBC_api.DBHandler;

import java.sql.SQLException;

public class DisplayManager {

    private DBHandler dbHandler;

    public DisplayManager() {
        dbHandler = new DBHandler();
    }

    public void getInputData(String input) throws SQLException {
        dbHandler.getIceCreamID("Czekoladowe");
    }
    /*
    @Override
    public void addNotify() {
        super.addNotify();

        if(thread == null){
            thread = new Thread(this,"AppThread");
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.print("Thread OK");
    }

     */
}
