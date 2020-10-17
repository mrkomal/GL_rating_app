package controller;

public enum Comment {
    FLAVOUR_DOES_NOT_EXIST("Brak danych do wyświetlenia. Nigdy nie próbowałeś podanego smaku."),
    FLAVOUR_EXISTS("Podany smak znajduje się w bazie. Informacje zostały wyświetlone."),
    FLAVOUR_ADD("Pomyślnie dodano nowy smak i twoje odczucia."),
    FLAVOUR_RANKING_RETURNED("Ranking został wyświetlony.");

    public final String commentText;

    Comment (String commentText) {
        this.commentText = commentText;
    }
}
