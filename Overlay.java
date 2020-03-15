import java.awt.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Overlay extends JFrame {

    private static final long serialVersionUID = 1L;
    Logic logic = new Logic();
    KeyListener keyListener = new KeyListener(logic);

    public Overlay() {
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
        g.drawString("Handcards:"+ logic.getHandString(), 1300, 1070);
        g.drawString("Friendly Minions: " + logic.getFriendlyMinionsString(), 440, 540);
        g.drawString("Enemy Minions: " + logic.getEnemyMinionsString(), 440, 480);
        g.drawString("E", 1660, 500);
    }

    public static void main(String[] args) {
        Overlay overlay = new Overlay();
        overlay.keyListener.start(overlay.logic);
        overlay.logic.start();
        overlay.logic.setEnemyMinions(0);
        overlay.logic.setFriendlyMinions(0);
        overlay.logic.setHandcards(3);
        while(true) {
            overlay.repaint();
        }
    }

}
