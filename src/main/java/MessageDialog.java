import javax.swing.*;

public class MessageDialog extends JFrame {

    private String message;

    public MessageDialog(String title, String message) {
        super(title);
        this.message = message;
        setSize(300,150);
        setResizable(false);
    }
}
