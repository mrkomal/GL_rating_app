package frame.panel;

import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel implements Runnable {

    private int width;
    private int height;

    private JPanel rightPanel;
    private Color rightFragmentCol = Color.CYAN.brighter();
    private String rightFragmentTitle = "Rezultat:";

    private JPanel leftPanel;
    private Color leftFragmentCol = Color.LIGHT_GRAY;
    private String leftFragmentTitle = "Dane wejściowe:";
    private JLabel iceCreamNameLabel = new JLabel("Podaj nazwę smaku dnia:");
    private JTextField iceCreamNameField = new JTextField(20);

    private boolean isRunning = false;
    private Thread thread;

    public AppPanel(int width, int height) {
        this.width = width;
        this.height = height;
        setSize(new Dimension(width, height));
        //setFocusable(true);
        //requestFocusInWindow();

        init();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if(thread == null){
            thread = new Thread(this,"AppThread");
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.print("Thread OK");
    }

    void init(){
        setLayout(new BorderLayout());

        rightPanel = new ScreenFragment(width/2-15, height, rightFragmentCol, rightFragmentTitle);

        leftPanel = new ScreenFragment(width/2, height, leftFragmentCol, leftFragmentTitle);
        leftPanel.add(iceCreamNameLabel);
        leftPanel.add(iceCreamNameField);

        add( rightPanel, BorderLayout.EAST );
        add( leftPanel, BorderLayout.WEST );
    }
}
