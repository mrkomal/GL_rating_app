package frame.panel;

import JDBC_api.models.NewFlavourModel;
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
    private JLabel iceCreamDate = new JLabel("Ostatni raz jedzony: ");
    private JLabel iceCreamInfo = new JLabel("Twoje uwagi dotyczące smaku: ");
    public JLabel iceCreamRatePH = new JLabel("");
    public JLabel iceCreamDatePH = new JLabel("");
    public JLabel iceCreamInfoPH = new JLabel("");
    private JLabel ranking = new JLabel("Dotychczasowy ranking:");
    public int numOfPlacesInRank = 3;
    public JLabel firstPlace = new JLabel("#1 ");
    public JLabel secondPlace = new JLabel("#2 ");
    public JLabel thirdPlace = new JLabel("#3 ");
    private JButton loadButton = new JButton("Załaduj ranking");

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
    public JLabel actionInfo = new JLabel("Uruchomiono program.");

    private DisplayManager displayManager;

    public AppPanel(int width, int height) throws SQLException {
        this.width = width;
        this.height = height;
        setSize(new Dimension(width, height));

        init();
    }

    void init() throws SQLException{
        setLayout(new BorderLayout());
        displayManager = new DisplayManager(this);

        //right site
        rightPanel = new ScreenFragment(width/2-15, height*5/6, rightFragmentCol, rightFragmentTitle);
        rightPanel.setLayout(new GridLayout(12,1));
        rightPanel.add(iceCreamRate);
        rightPanel.add(iceCreamRatePH);
        rightPanel.add(iceCreamDate);
        rightPanel.add(iceCreamDatePH);
        rightPanel.add(iceCreamInfo);
        rightPanel.add(iceCreamInfoPH);

        JPanel spacePanelR = new JPanel();
        spacePanelR.setBackground(rightFragmentCol);
        rightPanel.add(spacePanelR);

        rightPanel.add(ranking);
        rightPanel.add(firstPlace);
        rightPanel.add(secondPlace);
        rightPanel.add(thirdPlace);
        rightPanel.add(loadButton);
        loadButton.addActionListener(new loadButtonActionListener());

        //left site
        leftPanel = new ScreenFragment(width/2, height*5/6, leftFragmentCol, leftFragmentTitle);
        leftPanel.setLayout(new GridLayout(12,1));
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
            try {
                String inputFlavour = iceCreamNameField.getText();
                displayManager.getFlavourInfo(inputFlavour);
                iceCreamNameField.setText("");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class enterButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String inputFlavour = addIceCreamNameField.getText();
                int inputRate = Integer.parseInt(addIceCreamRateField.getText());
                String inputInfo = addIceCreamInfoField.getText();
                displayManager.addNewFlavour(new NewFlavourModel(
                        inputFlavour,
                        inputRate,
                        inputInfo));
                addIceCreamNameField.setText("");
                addIceCreamRateField.setText("");
                addIceCreamInfoField.setText("");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class loadButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                displayManager.getCurrentRanking();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void editJLabelText (JLabel jlabel, String newText) {
        jlabel.setText(newText);
    }
}
