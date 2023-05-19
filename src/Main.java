import org.w3c.dom.css.Rect;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        GameArena table = new GameArena(800, 800, true);
        Line topLine = new Line(400, 0, 400, 250, 5, "BLUE", 2);
        Line bottomLine = new  Line(400, 800, 400, 450, 5, "BLUE", 2);
        Ball outerPitchCircle = new Ball(400, 350, 0, 0, 100, "BLUE", 2);
        Ball innerPitchCircle = new Ball(400, 350, 0, 0, 90, "WHITE", 3);
        Rectangle background = new Rectangle(0, 0, 800, 800, "WHITE", 0);
        Puck myPuck = new Puck(5, 5, 5, 3, 20, "BLUE", 2);
        Mallet player1 = new Mallet(700, 400, 40, "BLACK", 2);
        Mallet player2 = new Mallet(200, 400, 40, "BLACK", 2);
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
        table.start(player1, player2, myPuck);
        table.addText(new Text("Player 1's score:", 15, 650, 200, "BLUE", 1));
        table.addText(new Text("    " + table.getPlayer1Score() + "      ", 15, 650, 250, "BLUE", 1));
        table.addText(new Text("Player 2's score:" + "      " + table.getPlayer2Score() + "      ", 15, 150, 200, "BLUE", 1));
        table.addText(new Text("    " + table.getPlayer2Score() + "      ", 15, 150, 250, "BLUE", 1));
        boolean running = true;
        while (running) {
            myPuck.updatePosition();
            if (myPuck.getXPosition() <= 0 || myPuck.getXPosition() >= 800) {
                myPuck.getVelocity().setX_vel(Math.negateExact(myPuck.getVelocity().getX_vel())); //invert velocities after collision with wall
            }
            if (myPuck.getYPosition() <= 0 || myPuck.getYPosition() >= 800) {
                myPuck.getVelocity().setY_vel(Math.negateExact(myPuck.getVelocity().getY_vel())); //invert velocities after collision with wall
            }
            if (table.getMousePositionX() > 400) {
                table.followMouse(player1);//if the mouse is in player 1's half make their mallet follow the mouse
            } else if (table.getMousePositionX() < 400 || table.getMousePositionY() <= 800) {
                table.followMouse(player2); //if the mouse is in player 2's half make their mallet follow the mouse
            }
            if (table.colliding(myPuck, player1)) { //are player 1 and the puck touching
                myPuck.setVelocity(myPuck.measureVelocity(table)); //updates the pucks velocity Vector after getting hit my a mallet
                myPuck.puckCollisionCorrection(player1, myPuck); //applies small continuity correction to pucks position relative to a colliding mallet to ensure collisions work correctly
            }
            if (table.colliding(myPuck, player2)) { //are player 3 and the puck touching
                myPuck.setVelocity(myPuck.measureVelocity(table)); //updates the pucks velocity Vector after getting hit my a mallet
                myPuck.puckCollisionCorrection(player2, myPuck); //applies small continuity correction to pucks position relative to a colliding mallet to ensure collisions work correctly
            }
            table.pause(); //pause
            myPuck.friction(); //apply friction to the puck
        }
    }
}