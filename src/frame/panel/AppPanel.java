package frame.panel;

import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel {

    public AppPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocusInWindow();
    }
}
