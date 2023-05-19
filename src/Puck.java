import java.util.Random;

public class Puck extends Ball{
    private Random randomInt = new Random();

    Vector[] vectorArray;
    public Puck(int aX_position, int aY_position, int aX_vel, int aY_vel, int aDiameter, String colour, int aLayer)
    {
        super(aX_position, aY_position, aX_vel, aY_vel, aDiameter, colour, aLayer);
    }

    public void updatePosition()
    {
        super.xPosition = super.xPosition + super.velocity.getX_vel();
        super.yPosition = super.yPosition + super.velocity.getY_vel();
    }

    public void setVectorArray(Vector[] vectorArray) {
        this.vectorArray = vectorArray;
    }

    public void setVectorArray(Vector vector1, Vector vector2)
    {
        vectorArray[0] = vector1;
        vectorArray[1] = vector2;
    }

    public Vector[] getVectorArray()
    {
        return vectorArray;
    }

    public static void main(String[] args)
    {
        Puck puck = new Puck(0, 0, 0, 0, 10, "BLUE", 5);
        GameArena table = new GameArena(0, 0, false);
        puck.measureVelocity(table);
    }


    public Vector measureVelocity(GameArena table)
    {
        vectorArray = new Vector[2];
        vectorArray[0] = new Vector(table.getMousePositionX(), table.getMousePositionY());
        table.pause();
        vectorArray[1] = new Vector(table.getMousePositionX(), table.getMousePositionY());
        Vector displacment = table.getDisplacment(vectorArray);
        Vector velocityVector = new Vector((int) (displacment.getX_vel()), (int) (displacment.getY_vel()));
        System.out.println(velocityVector.getX_vel() + velocityVector.getY_vel());
        System.out.println(velocityVector);
        return velocityVector;
    }

    public void friction()
    {
        velocity.setX_vel((int) (velocity.getX_vel() * 0.7));
        velocity.setY_vel((int) (velocity.getY_vel() * 0.7));
    }

    public void puckCollisionCorrection(Mallet mallet, Puck puck)
    {
        if (puck.getXPosition() > mallet.getXPosition()) { //puck is to the right of mallet

            if (puck.getYPosition() > mallet.getYPosition()) { //puck is below mallet and to the right
                puck.setXPosition(puck.getXPosition() + 5);
                puck.setYPosition(puck.getYPosition() + 5);
            } else if (puck.getYPosition() == mallet.getYPosition()) { //puck is directly to the right of the mallet
                puck.setXPosition(puck.getXPosition() + 5); //move to the right
            } else { //puck is above mallet to the right
                puck.setXPosition(puck.getXPosition() + 5); //move to right
                puck.setYPosition(puck.getYPosition() - 5); //move higher
            }

        } else if (puck.getXPosition() == mallet.getXPosition()) { //puck is directly above or below mallet

            if (puck.getYPosition() > mallet.getYPosition()) { //puck is below mallet
                puck.setYPosition(puck.getYPosition() + 5); //move puck down
            } else { //puck is above mallet
                puck.setYPosition(puck.getYPosition() - 5); //move puck up
            }

        } else { //puck is to the left of the mallet

            if (puck.getYPosition() > mallet.getYPosition()) { //puck is below mallet
                puck.setXPosition(puck.getXPosition() - 5); // move puck to the left
                puck.setYPosition(puck.getYPosition() + 5);
            } else if (puck.getYPosition() == mallet.getYPosition()) { //puck is directly to the left of the mallet
                puck.setXPosition(puck.getXPosition() - 5); //move puck to the left
            } else { //puck is above mallet
                puck.setXPosition(puck.getXPosition() - 5); //move to the left
                puck.setYPosition(puck.getYPosition() - 5); //move up
            }

        }
    }
}
