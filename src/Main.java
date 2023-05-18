import org.w3c.dom.css.Rect;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GameArena table = new GameArena(800, 800, true);
        Line topLine = new Line(400, 0, 400, 250, 5, "BLUE", 2);
        Line bottomLine = new  Line(400, 800, 400, 450, 5, "BLUE", 2);
        Ball outerPitchCircle = new Ball(400, 350, 0, 0, 100, "BLUE", 2);
        Ball innerPitchCircle = new Ball(400, 350, 0, 0, 90, "WHITE", 3);
        Rectangle background = new Rectangle(0, 0, 800, 800, "WHITE", 1);
        Puck myPuck = new Puck(5, 5, 10, 10, 20, "BLUE", 2);
        Mallet player1 = new Mallet(700, 400, 20, "BLACK", 2);
        Mallet player2 = new Mallet(200, 400, 20, "BLACK", 2);
        Goal leftGoal = new Goal(1, 0, 0, 200, 10, "GREY", 5);
        Goal rightGoal = new Goal(2, 790, 200, 10, 200, "GREY", 5);
        table.addRectangle(background);
        table.addBall(myPuck);
        table.addBall(player1);
        table.addBall(player2);
        table.addLine(topLine);
        table.addLine(bottomLine);
        table.addBall(outerPitchCircle);
        table.addBall(innerPitchCircle);
        table.addRectangle(leftGoal);
        table.addRectangle(rightGoal);
        boolean running = true;
        while (running) {
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
                player1.setVelocity(myPuck.measureVelocity(table));
            }
            if (table.colliding(myPuck, player2)) {
                player2.setVelocity(myPuck.measureVelocity(table));
            }
            //System.out.print(table.getMousePositionX() + ", ");
            //System.out.println(table.getMousePositionY());
            table.pause();
        }
    }
}