import java.util.Random;

public class Puck extends Ball{
    private Random randomInt = new Random();
    public Puck(int aX_position, int aY_position, int aX_vel, int aY_vel, int aDiameter, String colour, int aLayer)
    {
        super(aX_position, aY_position, aX_vel, aY_vel, aDiameter, colour, aLayer);
    }

    public void updatePosition()
    {
        super.xPosition = super.xPosition + super.velocity.getX_vel();
        super.yPosition = super.yPosition + super.velocity.getY_vel();
    }

    public void setVelocity(int vel, char xOrY) {
        if (xOrY == 'x') {
            super.velocity.setX_vel(vel);
        } else if (xOrY == 'y') {
            super.velocity.setY_vel(vel);
        }
    }
}
