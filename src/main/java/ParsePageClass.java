import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ParsePageClass extends JFrame{

    private String articleName;
    private String day;
    private String month;
    private String year;
    private String hour;
    private String minute;
    private boolean wasRedact = true;

    private JLabel articleNameLabel;
    private JTextField articleNameField;
    private JLabel dateLabel;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JLabel timeLabel;
    private JTextField hourField;
    private JTextField minuteField;
    private JButton confirmButton;
    private JMenuBar menuBar;

    public ParsePageClass() {

        super("Wikipedia article redact");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,400);

        setLayout(new FlowLayout());

        articleNameLabel = new JLabel("Enter your article name: ");
        articleNameField = new JTextField(20);
        dateLabel = new JLabel("Enter your last redacting date: ");
        dayComboBox = new JComboBox();
        monthComboBox = new JComboBox();
        yearComboBox = new JComboBox();
        confirmButton = new JButton("Confirm");
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("About");
        JMenuItem about = new JMenuItem("About");

        //create ComboBox model for day
        int[] days = new int[31];
        for (int i = 0; i < days.length; i++) {
            days[i] = i + 1;
        }
        DefaultComboBoxModel dayModel = new DefaultComboBoxModel();
        for (int i = 0; i < days.length; i++) {
            dayModel.addElement(days[i]);
        }
        dayComboBox.setModel(dayModel);
        //create ComboBox model for month
        String[] months = {"января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря"};
        DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
        for (int i = 0; i < months.length; i++) {
            monthModel.addElement(months[i]);
        }
        monthComboBox.setModel(monthModel);
        //create ComboBox model for years
        int[] years = new int[20];
        for (int i = 0; i < 20; i++) {
            years[i] = i + 2001;
        }
        DefaultComboBoxModel yearModel = new DefaultComboBoxModel();
        for (int i = 0; i < years.length; i++) {
            yearModel.addElement(years[i]);
        }
        yearComboBox.setModel(yearModel);

        //добави слушатель на кнопку
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                articleName = articleNameField.getText();
                day = String.valueOf(dayComboBox.getSelectedItem());
                month = String.valueOf(monthComboBox.getSelectedItem());
                year = String.valueOf(yearComboBox.getSelectedItem());
                String pgeAddress = "https://ru.wikipedia.org/wiki/" + articleName;
                String compareStr = "\t\t\t\t\t\t\t\t<li id=\"footer-info-lastmod\"> Эта страница в последний раз была отредактирована " + day + " " + month + " " + year + " в 13:28.</li>";

                System.out.println("Искомая строка:\n" + compareStr);
                System.out.println("Найденная строка:");
                try {
                    URL url = new URL(pgeAddress);
                    try {
                        LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
                        String string = reader.readLine();
                        while (string != null) {
                            //System.out.println(string);
                            if (string.equalsIgnoreCase(compareStr)){
                                System.out.println("Статья не была отредактирована!");
                                System.out.println(string);
                                wasRedact = false;
                                break;
                            }
                            string = reader.readLine();
                        }
                        System.out.println(string);
                        System.out.println(wasRedact);
                        if (wasRedact) {
                            System.out.println("Внимание! Статья была отредактирована!");
                        }
                        reader.close();
                    } catch (IOException ex1) {
                        ex1.printStackTrace();
                    }
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        menu.add(about);
        menuBar.add(menu);

        getContentPane().add(articleNameLabel);
        getContentPane().add(articleNameField);
        getContentPane().add(dateLabel);
        getContentPane().add(dayComboBox);
        getContentPane().add(monthComboBox);
        getContentPane().add(yearComboBox);

        getContentPane().add(confirmButton);

        setJMenuBar(menuBar);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
