package frame.panel;

import controller.DisplayManager;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class AppPanel extends JPanel{

    private int width;
    private int height;

    private JPanel rightPanel;
    private Color rightFragmentCol = Color.CYAN.brighter();
    private String rightFragmentTitle = "Rezultat:";
    private JLabel iceCreamRate = new JLabel("Przyznana ocena:");

    private JPanel leftPanel;
    private Color leftFragmentCol = Color.LIGHT_GRAY;
    private String leftFragmentTitle = "Dane wejściowe:";
    private JLabel iceCreamNameLabel = new JLabel("Podaj nazwę smaku dnia:");
    private JTextField iceCreamNameField = new JTextField(20);

    private boolean isRunning = false;
    private Thread thread;

    private DisplayManager displayManager;

    public AppPanel(int width, int height) throws SQLException {
        this.width = width;
        this.height = height;
        setSize(new Dimension(width, height));
        //setFocusable(true);
        //requestFocusInWindow();

        init();
    }

    void init() throws SQLException{
        setLayout(new BorderLayout());
        displayManager = new DisplayManager();
        displayManager.getInputData("aaa");

        rightPanel = new ScreenFragment(width/2-15, height, rightFragmentCol, rightFragmentTitle);
        rightPanel.add(iceCreamRate);
        iceCreamRate.setText(iceCreamRate.getText() + " aaa");

        leftPanel = new ScreenFragment(width/2, height, leftFragmentCol, leftFragmentTitle);
        leftPanel.add(iceCreamNameLabel);
        leftPanel.add(iceCreamNameField);

        add( rightPanel, BorderLayout.EAST );
        add( leftPanel, BorderLayout.WEST );
    }
}
