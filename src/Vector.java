public class Vector
{
    private int x_vel; //x component of the vector
    private int y_vel; //y components of the vector
    private int speed; //speed

    public Vector(int x_vel, int y_vel)
    {
        this.x_vel = x_vel;
        this.y_vel = y_vel;
        this.speed = (int) Math.sqrt(x_vel * 2 + y_vel * 2);
    }

    public synchronized int getX_vel() //retuns x_vel
    {
        return x_vel;
    }

    public synchronized int getY_vel() //returns y_vel
    {
        return y_vel;
    }

    public synchronized int getSpeed()
    {
        return speed;
    } //returns speed

    public synchronized void setSpeed(int aSpeed)
    {
        speed = aSpeed;
    } //sets speed

    public synchronized void setX_vel(int aX_vel)
    {
        x_vel = aX_vel;
    } //x_vel

    public synchronized void setY_vel(int aY_vel)
    {
       y_vel = aY_vel;
    } //y_vel

    public void dampingFactor(int factor) //applys a constant to the componenets of the vector
    {
        this.x_vel = x_vel / factor;
        this.y_vel = y_vel / factor;
    }

}
