package controller;

import JDBC_api.DBHandler;
import JDBC_api.models.FlavourInfoModel;
import JDBC_api.models.NewFlavourModel;
import frame.panel.AppPanel;

import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayManager {

    private DBHandler dbHandler;
    private AppPanel appPanel;

    public DisplayManager(AppPanel appPanel) {
        this.appPanel = appPanel;
        dbHandler = new DBHandler();
    }

    public void getFlavourInfo(String flavour) throws SQLException {
        //check if flavour exists in DB
        boolean flavourExists = false;
        int ID = dbHandler.getFlavourID(flavour);
        if(ID != -1) {
            flavourExists = true;
        }

        //conditional statement: if flavour exists get other info from DB
        FlavourInfoModel flavourInfo = new FlavourInfoModel();
        if(flavourExists){
            flavourInfo = dbHandler.getFlavourInfo(ID);
        }

        //update interface variables with obtained data
        appPanel.editJLabelText(appPanel.iceCreamRatePH, flavourInfo.getRate());
        appPanel.editJLabelText(appPanel.iceCreamDatePH, flavourInfo.getDate());
        appPanel.editJLabelText(appPanel.iceCreamInfoPH, flavourInfo.getDescription());

        //update comment with performed action
        if(flavourExists) {
            appPanel.editJLabelText(appPanel.actionInfo, Comment.FLAVOUR_EXISTS.commentText);
        } else {
            appPanel.editJLabelText(appPanel.actionInfo, Comment.FLAVOUR_DOES_NOT_EXIST.commentText);
        }
    }

    public void getCurrentRanking() throws SQLException {
        //get data from DB
        ArrayList<String> flavoursFromDB = dbHandler.getRanking(appPanel.numOfPlacesInRank);
        while (flavoursFromDB.size() < appPanel.numOfPlacesInRank) {
            flavoursFromDB.add("Brak");
        }

        //update interface variables with obtained data
        appPanel.editJLabelText(appPanel.firstPlace, String.format(
                "#1 %s", flavoursFromDB.get(0)));
        appPanel.editJLabelText(appPanel.secondPlace, String.format(
                "#2 %s", flavoursFromDB.get(1)));
        appPanel.editJLabelText(appPanel.thirdPlace, String.format(
                "#3 %s", flavoursFromDB.get(2)));

        //update comment with performed action
        appPanel.editJLabelText(appPanel.actionInfo, Comment.FLAVOUR_RANKING_RETURNED.commentText);
    }

    public void addNewFlavour(NewFlavourModel newFlavourModel) throws SQLException {
        //create new row for each table with given data
        dbHandler.addNewFlavour(newFlavourModel);

        //update comment with performed action
        appPanel.editJLabelText(appPanel.actionInfo, Comment.FLAVOUR_ADD.commentText);
    }

}
