public class Puck{
    private int x;
    private int y;
    private int x_vel;
    private int y_vel;
    private int speed;

    public Puck(int x, int y, int x_vel, int y_vel)
    {
        this.x = x;
        this.y = y;
        this.x_vel = x_vel;
        this.y_vel = y_vel;
        this.speed = (int) Math.sqrt(x_vel * x_vel + y_vel * y_vel);
    }
}
