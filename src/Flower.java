import java.awt.*;
import java.awt.geom.GeneralPath;

public class Flower {
    private int x, y;
    private Color grassColor, flowerColor;

    public Color getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(Color flowerColor) {
        this.flowerColor = flowerColor;
    }

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

    public Color getGrassColor() {
        return grassColor;
    }

    public void setGrassColor(Color grassColor) {
        this.grassColor = grassColor;
    }

    public Flower(int x, int y, Color grassColor, Color flowerColor) {
        this.x = x;
        this.y = y;
        this.grassColor = grassColor;
        this.flowerColor = flowerColor;
    }

    public void drawFlower(Graphics2D g) {
        Color oldColor = g.getColor();

        g.setColor(grassColor);
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);
        path.curveTo(x - 10, y , x - 20, y - 15, x - 30, y - 30);
        path.moveTo(x, y);
        path.curveTo(x + 10, y , x + 20, y - 15, x + 30, y - 30);
        path.moveTo(x, y);
        path.lineTo(x, y - 40);
        g.draw(path);
        g.setColor(flowerColor);
        int[] xPoints = {x, x - 20, x - 25, x + 25, x + 20};
        int[] yPoints = {y - 30, y - 45, y - 60, y - 60, y - 45};
        g.fillPolygon(xPoints, yPoints, 5);

        g.setColor(oldColor);
    }
}
