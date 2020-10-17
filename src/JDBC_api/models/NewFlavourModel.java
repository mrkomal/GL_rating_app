package JDBC_api.models;

public class NewFlavourModel {

    private int rate;
    private String name;
    private String description;

    public NewFlavourModel(String name, int rate,  String description) {
        this.rate = rate;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }
}
