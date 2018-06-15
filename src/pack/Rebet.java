package pack;

import java.awt.*;
import java.awt.event.InputEvent;


public class Rebet {



    public static void main(String[] args) throws AWTException {

        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(123,3445);
        robot.delay(1000);
        robot.mouseMove(300,356);
        robot.delay(1000);
        robot.mouseMove(1,2356);
        robot.delay(1000);
        robot.mouseMove(123,3445);
        robot.delay(1000);
        robot.mouseMove(78,100);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

    }


}
