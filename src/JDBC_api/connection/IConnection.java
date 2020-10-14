package JDBC_api.connection;

public interface IConnection {
    /*
    To establish connection server, userName and password are required. User is forced by interface
    to define these features without imposing the way of doing this.
    Advantage: user have a choice to put data strictly in a code or set the properties from file
     and make them invisible for the app.
     */

    String setDatabaseURL();
    String setUserName();
    String setPassword();

}
