import org.w3c.dom.css.Rect;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GameArena table = new GameArena(800, 800, true);
        Rectangle background = new Rectangle(0, 0, 800, 800, "WHITE", 1);
        Puck myPuck = new Puck(5, 5, 0, 0, 20, "BLUE", 2);
        Mallet player1 = new Mallet(700, 400, 20, "BLACK", 2);
        Mallet player2 = new Mallet(200, 400, 20, "BLACK", 2);
        table.addRectangle(background);
        table.addBall(myPuck);
        table.addBall(player1);
        table.addBall(player2);
        boolean running = true;
        while (true) {
            myPuck.updatePosition();
            if (myPuck.getXPosition() <= 0 || myPuck.getXPosition() >= 800) {
                myPuck.getVelocity().setX_vel(Math.negateExact(myPuck.getVelocity().getX_vel()));
            }
            if (myPuck.getYPosition() <= 0 || myPuck.getYPosition() >= 800) {
                myPuck.getVelocity().setY_vel(Math.negateExact(myPuck.getVelocity().getY_vel()));
            }
            if (table.getMousePositionX() > 400) {
                table.followMouse(player1);
            } else if (table.getMousePositionX() < 400 || table.getMousePositionY() <= 800) {
                table.followMouse(player2);
            }
            if (table.colliding(myPuck, player1)) {
                System.out.println("touching...");
            }
            if (table.colliding(myPuck, player2)) {
                System.out.println("touching ...");
            }
            table.pause();
        }
    }
}