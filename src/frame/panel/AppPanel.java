package frame.panel;

import controller.DisplayManager;
import frame.panel.screen_fragments.ScreenFragment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AppPanel extends JPanel{

    private int width;
    private int height;

    private JPanel rightPanel;
    private Color rightFragmentCol = Color.CYAN;
    private String rightFragmentTitle = "Rezultat:";
    private JLabel iceCreamRate = new JLabel("Przyznana ocena: ");
    private JLabel iceCreamDate = new JLabel("Ostatni raz serwowany: ");
    private JLabel iceCreamInfo = new JLabel("Twoje uwagi dotyczące smaku: ");
    private JLabel ranking = new JLabel("Dotychczasowy ranking:");
    private JLabel firstPlace = new JLabel("#1 ");
    private JLabel secondPlace = new JLabel("#2 ");
    private JLabel thirdPlace = new JLabel("#3 ");

    private JPanel leftPanel;
    private Color leftFragmentCol = Color.LIGHT_GRAY;
    private String leftFragmentTitle = "Dane wejściowe:";
    private JLabel iceCreamNameLabel = new JLabel("Podaj nazwę smaku dnia:");
    private JTextField iceCreamNameField = new JTextField(20);
    private JButton checkButton = new JButton("Sprawdź");
    private JLabel otherChoice = new JLabel("Albo dodaj nowy smak do bazy danych:");
    private JLabel addIceCreamNameLabel = new JLabel("Smak:");
    private JTextField addIceCreamNameField = new JTextField(20);
    private JLabel addIceCreamRateLabel = new JLabel("Ocena (1-10):");
    private JTextField addIceCreamRateField = new JTextField(20);
    private JLabel addIceCreamInfoLabel = new JLabel("Komentarz (opcjonalnie):");
    private JTextField addIceCreamInfoField = new JTextField(20);
    private JButton enterButton = new JButton("Potwierdź");

    private JPanel bottomPanel;
    private Color bottomFragmentCol = Color.pink;
    private String bottomFragmentTitle = "Komentarz: ";
    private JLabel actionInfo = new JLabel("Wykonane zadanie: ");

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
        //displayManager.getInputData("Czekoladowe");

        //right site
        rightPanel = new ScreenFragment(width/2-15, height*5/6, rightFragmentCol, rightFragmentTitle);
        rightPanel.setLayout(new GridLayout(10,1));
        rightPanel.add(iceCreamRate);
        rightPanel.add(iceCreamDate);
        rightPanel.add(iceCreamInfo);

        JPanel spacePanelR = new JPanel();
        spacePanelR.setBackground(rightFragmentCol);
        rightPanel.add(spacePanelR);

        rightPanel.add(ranking);
        rightPanel.add(firstPlace);
        rightPanel.add(secondPlace);
        rightPanel.add(thirdPlace);
        //iceCreamRate.setText(iceCreamRate.getText() + " aaa");

        //left site
        leftPanel = new ScreenFragment(width/2, height*5/6, leftFragmentCol, leftFragmentTitle);
        leftPanel.setLayout(new GridLayout(13,1));
        leftPanel.add(iceCreamNameLabel);
        leftPanel.add(iceCreamNameField);
        leftPanel.add(checkButton);
        checkButton.addActionListener(new checkButtonActionListener());

        JPanel spacePanelL = new JPanel();
        spacePanelL.setBackground(leftFragmentCol);
        leftPanel.add(spacePanelL);

        leftPanel.add(otherChoice);
        leftPanel.add(addIceCreamNameLabel);
        leftPanel.add(addIceCreamNameField);
        leftPanel.add(addIceCreamRateLabel);
        leftPanel.add(addIceCreamRateField);
        leftPanel.add(addIceCreamInfoLabel);
        leftPanel.add(addIceCreamInfoField);
        leftPanel.add(enterButton);
        enterButton.addActionListener(new enterButtonActionListener());

        //bottom
        bottomPanel = new ScreenFragment(width, height/6, bottomFragmentCol, bottomFragmentTitle);
        bottomPanel.setLayout(new GridLayout(1,1));
        bottomPanel.add(actionInfo);

        add( rightPanel, BorderLayout.EAST );
        add( leftPanel, BorderLayout.WEST );
        add( bottomPanel, BorderLayout.SOUTH);
    }

    class checkButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked check");
        }
    }

    class enterButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked enter");
        }
    }
}
