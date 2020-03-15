import java.awt.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Overlay extends JFrame {

    private static final long serialVersionUID = 1L;
    Logic logic;

    public Overlay() {

        this.logic = new Logic();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Double width = screenSize.getWidth();
        Double height = screenSize.getHeight();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setSize(width.intValue(), height.intValue());
        this.setPreferredSize(new Dimension(width.intValue(), height.intValue()));
        this.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
        this.setLayout(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Handcards:" , 1300, 1070);
        g.drawString("Friendly Minions: ", 440, 540);
        g.drawString("Enemy Minions: ", 440, 480);
        g.drawString("E", 1660, 500);
        g.fillRect(100,  200,20, 50);
    }

    public static void main(String[] args) {
        Overlay overlay = new Overlay();
        overlay.logic.start();
        overlay.logic.setHandcards(3);
    }

}
