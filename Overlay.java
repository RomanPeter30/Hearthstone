import java.awt.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Overlay extends JFrame {

    private static final long serialVersionUID = 1L;
    Logic logic = new Logic(this);
    KeyListener keyListener = new KeyListener(logic);
    int xHands;
    int yHands;
    int addHands;
    int x, y;

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

        if(!logic.started) {
            g.drawString("S", 1400, 900);
        } else if(!logic.selected) {
            g.drawString("Choose number of Cards 3 or 4", 400,300);
        } else if(!logic.confirmed) {
            int xChoose = 400;
            int yChoose = 300;

            //SelectCard Numeration
            if(logic.getHandcards() == 6) {
                for(int i = 1; i <= logic.getHandcards() - 2; i++) {
                    g.drawString("" + i, xChoose, yChoose);
                    xChoose = xChoose + 350;
                }
            } else if (logic.getHandcards() == 4) {
                xChoose = 620;
                for(int i = 1; i <= logic.getHandcards() - 1; i++) {
                    g.drawString("" + i, xChoose, yChoose);
                    xChoose = xChoose + 350;
                }
            }
            g.drawString("C", 850, 860);
        } else {
            xHands = 0;
            yHands = 1000;
            addHands = 0;

            //HandCards Numeration
            switch(logic.getHandcards()) {
                case 1:
                    xHands = 920;
                    break;
                case 2:
                    xHands = 840;
                    addHands = 140;
                    break;
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
                    addHands = 110;
                    break;
                case 6:
                    xHands = 690;
                    addHands = 90;
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
            int i;
            for(i = 1; i <= logic.getHandcards(); i++) {
                g.drawString("" + i, xHands, yHands);
                xHands = xHands + addHands;
            }

            //Reset xHands
            xHands = xHands - (i * addHands);

            //Minion Numeration
            if(logic.getFriendlyMinions()%2 != 0) {
                x = 540;
                y = 600;
                for (i = 1; i <= 7; i++) {
                    g.drawString("" + i, x, y);
                    x = x + 140;
                }
            } else {
                x = 610;
                y = 600;
                for(i = 1; i <= 6; i++) {
                    g.drawString("" + i, x, y);
                    x = x + 140;
                }
            }

            if(logic.getEnemyMinions()%2 != 0) {
                x = 540;
                y = 400;
                for (i = 1; i <= 7; i++) {
                    g.drawString("" + i, x, y);
                    x = x + 140;
                }
            } else {
                x = 610;
                y = 400;
                for(i = 1; i <= 6; i++) {
                    g.drawString("" + i, x, y);
                    x = x + 140;
                }
            }

            //Reset x
            x = x - (i * 140);

            g.drawString("Handcards:"+ logic.getHandString(), 1300, 1070);
            g.drawString("Friendly Minions: " + logic.getFriendlyMinionsString(), 440, 540);
            g.drawString("Enemy Minions: " + logic.getEnemyMinionsString(), 440, 480);
            g.drawString("E", 1660, 500);
            if(!logic.attack && !logic.playCard) {
                g.drawString("A", 400, 600);
            } else if (logic.playCard) {
                g.drawString("P", 400, 600);
            } else {
                g.drawString("T" , 400, 400);
            }

            if(logic.spell) {
                g.drawString("S", 1300, 500);
            }

            if(logic.heroPower) {
                g.drawString("Press S to choose target", 1300, 500);
                g.drawString("Press Backspace if no target", 1300, 540);
            }

            if(logic.friendly) {
                g.drawString("Friendly", 1300, 700);
            }
        }
    }

    public static void main(String[] args) {
        Overlay overlay = new Overlay();
        overlay.keyListener.start(overlay.logic);
        overlay.logic.start();
        overlay.logic.setEnemyMinions(0);
        overlay.logic.setFriendlyMinions(0);
        while(true) {
            overlay.repaint();
        }
    }

}
