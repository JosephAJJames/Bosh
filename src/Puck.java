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
        vectorArray[0] = new Vector(5, 5);
        table.pause();
        vectorArray[1] = new Vector(10, 10);
        Vector displacment = table.getDisplacment(vectorArray);
        Vector velocityVector = new Vector((int) (displacment.getX_vel()/0.02), (int) (displacment.getY_vel()/0.02));
        System.out.println(velocityVector.getX_vel() + velocityVector.getY_vel());
        return velocityVector;
    }
}
