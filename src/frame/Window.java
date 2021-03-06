package frame;

import frame.panel.AppPanel;
import javax.swing.*;
import java.sql.SQLException;

public class Window implements IWindowProperties {

    private JFrame window;

    public Window() throws SQLException {
        window = new JFrame();
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setContentPane(new AppPanel(WINDOW_WIDTH, WINDOW_HEIGHT));
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle(WINDOW_TITLE);
        window.setVisible(true);
    }
}
