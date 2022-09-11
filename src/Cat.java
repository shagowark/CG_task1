import java.awt.*;

public class Cat {
    private int x, y, xLength;
    private Color c;

    public Cat(int x, int y, int xLength, Color c) {
        this.x = x;
        this.y = y;
        this.xLength = xLength;
        this.c = c;
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

    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void drawCat(Graphics2D g){
        DrawUtils.drawCat(g, x, y, xLength, c);
    }
}
