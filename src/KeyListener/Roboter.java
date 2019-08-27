package KeyListener;

import java.awt.*;
import java.awt.event.InputEvent;

public class Roboter {

    Robot robot;
    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        robot.mouseMove(1,1);
        pressMouseLeft();
    }

    public void choosePlace(int i) {
        switch (i) {
            case 2:
                robot.mouseMove(490, 590);
                pressMouseLeft();
                break;
            case 3:
                robot.mouseMove(720, 590);
                pressMouseLeft();
                break;
            case 4:
                robot.mouseMove(850, 590);
                pressMouseLeft();
                break;
            case 5:
                robot.mouseMove(1000, 590);
                pressMouseLeft();
                break;
            case 6:
                robot.mouseMove(1125, 590);
                pressMouseLeft();
                break;
            case 7:
                robot.mouseMove(1200, 590);
                pressMouseLeft();
                break;
            case 8:
                robot.mouseMove(1330, 590);
                pressMouseLeft();
                break;
        }
    }

    public void chooseTarget(int i) {
        switch (i) {
            case 2:
                robot.mouseMove(490, 420);
                pressMouseLeft();
                break;
            case 3:
                robot.mouseMove(720, 420);
                pressMouseLeft();
                break;
            case 4:
                robot.mouseMove(850, 420);
                pressMouseLeft();
                break;
            case 5:
                robot.mouseMove(1000, 420);
                pressMouseLeft();
                break;
            case 6:
                robot.mouseMove(1125, 420);
                pressMouseLeft();
                break;
            case 7:
                robot.mouseMove(1200, 420);
                pressMouseLeft();
                break;
            case 8:
                robot.mouseMove(1330, 420);
                pressMouseLeft();
                break;
        }
    }

    public void heroPower () {
        robot.mouseMove(1140, 830);
        pressMouseLeft();
    }

    public void goFace() {
        robot.mouseMove(940, 210);
        pressMouseLeft();
    }

    public void endTurn() {
        robot.mouseMove(1540,490);
        pressMouseLeft();

    }

    public void selectCard() {
        pressMouseLeft();
    }

    public void releaseCard() {
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void moveMouseRigth() {
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(x + 10, y);
    }

    public void moveMouseLeft() {
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(x - 10, y);
    }

    public void moveMouseUp() {
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(x, y + 10);
    }

    public void moveMouseDown() {
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(x, y - 10);
    }

    private void pressMouseLeft() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
