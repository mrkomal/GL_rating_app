package frame.panel.screen_fragments;

import javax.swing.*;
import java.awt.*;

public class ScreenFragment extends JPanel {

    public ScreenFragment(int width, int height, Color color, String etchedBorderTitle){
        setPreferredSize(new Dimension(width, height));
        setBackground(color);
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), etchedBorderTitle));
    }
}
