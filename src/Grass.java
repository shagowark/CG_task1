import java.awt.*;
import java.awt.geom.GeneralPath;

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

    public void drawGrass(Graphics2D g) {
        Color oldColor = g.getColor();

        g.setColor(c);
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);
        path.curveTo(x - 10, y , x - 20, y - 15, x - 30, y - 30);
        path.moveTo(x, y);
        path.curveTo(x + 10, y , x + 20, y - 15, x + 30, y - 30);
        path.moveTo(x, y);
        path.lineTo(x, y - 40);
        g.draw(path);

        g.setColor(oldColor);
    }
}
