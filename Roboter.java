import javafx.scene.input.MouseButton;

import java.awt.*;
import java.awt.event.InputEvent;

public class Roboter {

    Robot r;

    public void start() throws AWTException{
        this.r = new Robot();
    }

    public void startGame() {
        r.mouseMove(1400, 900);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void confirm() {
        r.mouseMove(970, 860);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void endTurn() {
        r.mouseMove(1560, 500);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void attack(int x, int times) {
        r.mouseMove(x + (times * 140), 400);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void select(int x, int times) {
        r.mouseMove(x + (times * 350), 500);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void playCard(int xHands, int addHands, int code) {
        r.mouseMove(xHands + (code * addHands), 1000);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void posToPlay(int x, int code) {
        r.mouseMove(x + (code * 140), 600);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void chooseAttackCard(int x, int code) {
        r.mouseMove(x + (code * 140), 600);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
