import javax.swing.*;
import java.awt.*;

public class MessageDialog extends JDialog {

    private String message;

    public MessageDialog(String title, String message) {
        setTitle(title);
        this.message = message;
        setSize(400,150);
        setResizable(false);

        setLayout(new FlowLayout(FlowLayout.CENTER,10,20));

        JLabel label = new JLabel();

        label.setIcon(new ImageIcon("images/infoIcon.png"));

        JLabel label1 = new JLabel(message);
        label1.setFont(new Font("Times new Roman",Font.BOLD,16));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        getContentPane().add(label);
        getContentPane().add(label1);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
