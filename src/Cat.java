import java.awt.*;
import java.awt.geom.GeneralPath;

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
        Color oldColor = g.getColor();
        Stroke oldStroke = g.getStroke();

        int yLength = xLength/2;
        //задние ноги
        g.setColor(Color.BLACK);
        g.drawLine(x+xLength/8, y+yLength/4*3, x, y+yLength/4*5);
        g.drawLine(x+xLength/4*3, y+yLength/4*3, x+xLength/8*5, y+yLength/4*5);
        //туловище
        g.setColor(c);
        g.setStroke(new BasicStroke(3));
        g.fillOval(x, y, xLength, yLength);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, xLength, yLength);
        //татуировка
        g.setFont(new Font("Old London", Font.PLAIN, 35));
        g.drawString("THE CAT", x+xLength/3, y+yLength/2);
        //уши
        int[] ear1XPoints = {x+xLength/32*28, x+xLength/32*30, x+xLength/32*31};
        int[] ear1YPoints = {y+yLength/8, y-yLength/32*6, y+yLength/8};
        g.setColor(c);
        g.fillPolygon(ear1XPoints, ear1YPoints, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(ear1XPoints, ear1YPoints, 3);

        int[] ear2XPoints = {x+xLength/32*32, x+xLength/32*33, x+xLength/32*34};
        int[] ear2YPoints = {y+yLength/8, y-yLength/32*6, y+yLength/8};
        g.setColor(c);
        g.fillPolygon(ear2XPoints, ear2YPoints, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(ear2XPoints, ear2YPoints, 3);
//        g.drawLine(x+xLength/32*28, y+yLength/8, x+xLength/32*30, y-yLength/32*5);
//        g.drawLine(x+xLength/32*31, y+yLength/8, x+xLength/32*30, y-yLength/32*5);
//        g.drawLine(x+xLength/32*32, y+yLength/8, x+xLength/32*33, y-yLength/32*5);
//        g.drawLine(x+xLength/32*34, y+yLength/8, x+xLength/32*33, y-yLength/32*5);
        //голова
        g.setColor(c);
        g.fillOval(x+xLength/4*3, y, yLength/3*2, yLength/3*2);
        g.setColor(Color.BLACK);
        g.drawOval(x+xLength/4*3, y, yLength/3*2, yLength/3*2);
        //глаза
        g.setColor(Color.WHITE);
        g.fillOval(x+xLength/32*29, y+yLength/4, yLength/8, yLength/8);
        g.fillOval(x+xLength/32*33, y+yLength/4, yLength/8, yLength/8);
        g.setColor(Color.BLACK);
        g.drawOval(x+xLength/32*29, y+yLength/4, yLength/8, yLength/8);
        g.drawOval(x+xLength/32*33, y+yLength/4, yLength/8, yLength/8);
        //зрачки
        g.fillOval(x+xLength/64*59, y+yLength/4, yLength/16, yLength/16);
        g.fillOval(x+xLength/64*67, y+yLength/4, yLength/16, yLength/16);
        //рот
        g.setColor(Color.RED);
        g.fillOval(x+xLength/64*59, y+yLength/16*7, yLength/16*5, yLength/8);
        g.setColor(Color.BLACK);
        g.drawOval(x+xLength/64*59, y+yLength/16*7, yLength/16*5, yLength/8);
        //передние ноги
        g.setColor(Color.BLACK);
        g.drawLine(x+xLength/4, y+yLength/4*3, x+xLength/8*3, y+yLength/4*5);
        g.drawLine(x+xLength/4*3, y+yLength/4*3, x+xLength/8*7, y+yLength/4*5);
        //хвост
        g.setStroke(new BasicStroke(5));
        g.setColor(c);
        GeneralPath path = new GeneralPath();
        path.moveTo(x+xLength/6, y+yLength/6);
        path.curveTo(x+xLength/6, y+yLength/6, x-xLength/3, y, x+xLength/4, y-yLength/4);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(8));
        g.draw(path);
        g.setColor(c);
        g.setStroke(new BasicStroke(3));
        g.draw(path);
        //g.drawLine(x+xLength/6, y+yLength/6, x-xLength/4, y-yLength/4);

        //сапоги
        //g.drawLine(x+xLength/8, y+yLength/4*3, x, y+yLength/4*5);
        double xCathet1 = Math.abs(x+xLength/8 - x);
        double yCathet1 = Math.abs(y+yLength/4*3 - yLength/4*5);
        double tgA1 = yCathet1 / xCathet1;
        double theta1 = Math.atan(-tgA1);
        g.setColor(Color.BLACK);
        g.rotate(theta1, x,  y+yLength/4*5);
        g.fillRect(x-1,  y+yLength/4*5, xLength/15, xLength/12);
        g.rotate(-theta1, x,  y+yLength/4*5);
        //g.drawLine(x+xLength/4, y+yLength/4*3, x+xLength/8*3, y+yLength/4*5);
        double xCathet2 = Math.abs(x+xLength/4 - x+xLength/8*3);
        double yCathet2 = Math.abs(y+yLength/4*3 - y+yLength/4*5);
        double tgA2 = xCathet2 / yCathet2;
        double theta2 = Math.atan(-tgA2) - 1.55;
        g.setColor(Color.BLACK);
        g.rotate(theta2, x+xLength/8*3,  y+yLength/4*5);
        g.fillRect(x+xLength/8*3-1,  y+yLength/4*5, xLength/15, xLength/12);
        g.rotate(-theta2, x+xLength/8*3,  y+yLength/4*5);

        g.setColor(oldColor);
        g.setStroke(oldStroke);
    }
}
