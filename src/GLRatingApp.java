import file_reader.FileReader;
import frame.Window;

import java.sql.SQLException;

public class GLRatingApp {

    public static void main(String[] args) throws SQLException {
        GLRatingApp glRatingApp = new GLRatingApp();
        glRatingApp.launch();
    }

    private void launch() throws SQLException {
        new Window();
    }
}
