import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.awt.*;

public class ParsePageClass extends JFrame{

    private String pgeAddress = "https://ru.wikipedia.org/wiki/Рабочая_партия_Финляндии";
    private boolean wasRedact = true;
    private String compareStr = "\t\t\t\t\t\t\t\t<li id=\"footer-info-lastmod\"> Эта страница в последний раз была отредактирована 26 ноября 2017 в 13:28.</li>";

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

        menu.add(about);
        menuBar.add(menu);

        getContentPane().add(articleNameLabel);
        getContentPane().add(articleNameField);

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
