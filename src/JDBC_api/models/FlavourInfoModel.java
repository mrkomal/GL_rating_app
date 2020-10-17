package JDBC_api.models;

public class FlavourInfoModel {

    private String rate;
    private String date;
    private String description;

    public void setFlavourInfoModel(String rate, String date, String description) {
        this.rate = rate;
        this.date = date;
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
