public class Mallet extends Ball {
    Vector[] displacmentVectorQueue = new Vector[3];
    public Mallet(int aX_position, int aY_position, int aDiameter, String colour, int aLayer)
    {
        super(aX_position, aY_position, 0, 0, aDiameter, colour, aLayer);
    }

    public void updatePosition()
    {
        super.xPosition = super.xPosition + super.velocity.getX_vel();
        super.yPosition = super.yPosition + super.velocity.getY_vel();
    }


}
