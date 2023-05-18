public class Goal  extends Rectangle{
    private int team;

    public Goal(int team, double x, double y, double w, double h, String col, int layer)
    {
        super(x, y, w, h, col, layer);
        this.team = team;
    }

    public void setTeam(int team)
    {
        this.team = team;
    }

    public int getTeam()
    {
        return team;
    }
}
