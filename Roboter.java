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
}