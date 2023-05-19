public class Vector
{
    private int x_vel;
    private int y_vel;
    private int speed;

    public Vector(int x_vel, int y_vel)
    {
        this.x_vel = x_vel;
        this.y_vel = y_vel;
        this.speed = (int) Math.sqrt(x_vel * 2 + y_vel * 2);
    }

    public synchronized int getX_vel()
    {
        return x_vel;
    }

    public synchronized int getY_vel()
    {
        return y_vel;
    }

    public synchronized int getSpeed()
    {
        return speed;
    }

    public synchronized void setSpeed(int aSpeed)
    {
        speed = aSpeed;
    }

    public synchronized void setX_vel(int aX_vel)
    {
        x_vel = aX_vel;
    }

    public synchronized void setY_vel(int aY_vel)
    {
       y_vel = aY_vel;
    }

    public void dampingFactor(int factor)
    {
        this.x_vel = x_vel / factor;
        this.y_vel = y_vel / factor;
    }

}
