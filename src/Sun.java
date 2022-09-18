import java.awt.*;

public class Sun {
    private int x, y, r, l, n, startAngle;
    private Color c;

    public Sun(int x, int y, int r, int l, int n, int startAngle, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.l = l;
        this.n = n;
        this.startAngle = startAngle;
        this.c = c;
    }

    public void drawSun(Graphics2D g){
        Color oldColor = g.getColor();

        g.setColor(c);
        g.setStroke(new BasicStroke(3));
        g.fillOval(x - r, y - r, r*2, r*2);

        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++){
            double a = i * da + startAngle;
            double x1 = r * Math.cos(a) + x;
            double y1 = r * Math.sin(a) + y;
            double x2 = (r+l) * Math.cos(a) + x;
            double y2 = (r+l) * Math.sin(a) + y;

            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);

        }

        g.setColor(oldColor);
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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
    public int getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }


}
