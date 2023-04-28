public class Main extends GameArena {
    public Main(int width, int height, boolean createWindow) {
        super(width, height, createWindow);
    }

    public static void main(String[] args)
    {
        Main newObj = new Main(800, 800, true);
        newObj.addRectangle(new Rectangle(0, 0, 800, 800, "WHITE"));
    }
}
