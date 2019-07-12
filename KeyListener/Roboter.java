package KeyListener;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public class Roboter {

    Robot robot;
    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void endTurn() {
        robot.mouseMove(1,1);
        robot.mousePress(InputEvent.BUTTON1_MASK);
    }

    public void selectCard() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
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
}
