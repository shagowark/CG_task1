import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;
    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);

        dp = new DrawPanel();
        this.add(dp);
    }

}
