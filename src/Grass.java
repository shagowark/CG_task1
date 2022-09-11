import java.awt.*;

public class Grass {
    private int x, y;
    private Color c;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Grass(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public void drawGrass(Graphics2D g){
        DrawUtils.drawGrass(g, x, y, c);
    }
}
