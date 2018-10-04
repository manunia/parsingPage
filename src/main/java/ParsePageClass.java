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
    private String pgeAddress = "https://ru.wikipedia.org/wiki/";

    private String[] day;
    private String[] month;
    private String[] year;

    private String compareStr = "\t\t\t\t\t\t\t\t<li id=\"footer-info-lastmod\"> Эта страница в последний раз была отредактирована 26 ноября 2017 в 13:28.</li>";
    private boolean wasRedact = true;

    private JLabel articleNameLabel;
    private JTextField articleNameField;
    private JLabel dateLabel;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
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

        //добавим слушатель на текстовое поле
        articleNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                articleName = articleNameField.getText();
                pgeAddress +=  articleName;
            }
        });

        //добави слушатель на кнопку
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                articleName = articleNameField.getText();
//                pgeAddress +=  articleName;
                try {
                    URL url = new URL(pgeAddress);
                    try {
                        LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
                        String string = reader.readLine();
                        while (string != null) {
                            System.out.println(string);

                            string = reader.readLine();
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

        getContentPane().add(confirmButton);

        setJMenuBar(menuBar);
        setLocationRelativeTo(null);
        setVisible(true);

//        try {
//            URL url = new URL(pgeAddress);
//
//            try {
//                LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
//                String string = reader.readLine();
//                while (string != null) {
//                    //System.out.println(string);
//
//                    if (string.equalsIgnoreCase(compareStr)){
//                        System.out.println("Статья не была отредактирована!");
//                        System.out.println(string);
//                        wasRedact = false;
//                        break;
//                    }
//                    string = reader.readLine();
//
//                }
//                System.out.println(wasRedact);
//                if (wasRedact) {
//                    System.out.println("Внимание! Статья была отредактирована!");
//                }
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (MalformedURLException ex) {
//            ex.printStackTrace();
//        }
    }
}
