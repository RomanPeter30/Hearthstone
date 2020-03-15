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
        int xHands = 0;
        int yHands = 1000;
        int addHands = 0;
        switch(logic.getHandcards()) {
            case 1:
                //Todo
            case 2:
                //Todo
            case 3:
                xHands = 800;
                addHands = 120;
                break;
            case 4:
                xHands = 740;
                addHands = 120;
                break;
            case 5:
                xHands = 700;
                addHands = 100;
                break;
            case 6:
                xHands = 690;
                addHands = 80;
                break;
            case 7:
                xHands = 660;
                addHands = 70;
                break;
            case 8:
            case 9:
                xHands = 650;
                addHands = 60;
                break;
            case 10:
                xHands = 640;
                addHands = 50;
                break;
        }
        int x = 540;
        int y = 400;
        super.paint(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        for(int i = 1; i <= logic.getHandcards(); i = i + 1) {
            g.drawString("" + i, xHands, yHands);
            xHands = xHands + addHands;
        }
        for(int i = 0; i <= 1; i = i + 1) {
            for(int j = 1; j <= 7; j = j + 1) {
                g.drawString("" + j, x, y);
                x = x + 140;
            }
            x = 540;
            y = 600;
        }
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
