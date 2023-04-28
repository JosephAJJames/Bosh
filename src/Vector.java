public class Vector
{
    private int x_vel;
    private int y_vel;
    private int speed;
    private int bearing;

    public Vector(int x_vel, int y_vel)
    {
        this.x_vel = x_vel;
        this.y_vel = y_vel;
        this.speed = (int) Math.sqrt(x_vel * 2 + y_vel * 2);
        this.bearing = (int) Math.sin(speed/y_vel);
    }

    public int getX_vel()
    {
        return x_vel;
    }

    public int getY_vel()
    {
        return y_vel;
    }

    public int getSpeed()
    {
        return speed;
    }

    public int getBearing()
    {
        return bearing;
    }

    public void setSpeed(int aSpeed)
    {
        speed = aSpeed;
    }

    public void setX_vel(int aX_vel)
    {
        x_vel = aX_vel;
    }

    public void setY_vel(int aY_vel)
    {
        y_vel = aY_vel;
    }

    public void setBearing(int aBeating)
    {
        bearing = aBeating;
    }
}
