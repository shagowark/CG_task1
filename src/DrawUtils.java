import java.awt.*;
import java.awt.geom.GeneralPath;

public class DrawUtils {
    public static void drawSun(Graphics2D g, int x, int y, int r, int l, int n, Color c){
        g.setColor(c);
        g.setStroke(new BasicStroke(3));
        g.fillOval(x - r, y - r, r*2, r*2);

        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++){
            double a = i * da;
            double x1 = r * Math.cos(a) + x;
            double y1 = r * Math.sin(a) + y;
            double x2 = (r+l) * Math.cos(a) + x;
            double y2 = (r+l) * Math.sin(a) + y;

            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }

    public static void drawCat(Graphics2D g, int x, int y, int xLength, Color c){
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
        path.curveTo(x+xLength/6, y+yLength/6, x, y, x+xLength/3, y-yLength/4);
        g.draw(path);
        //g.drawLine(x+xLength/6, y+yLength/6, x-xLength/4, y-yLength/4);
    }

    public static void drawCloud(Graphics2D g, int x, int y, int r, Color c){
        g.setColor(c);
        g.fillOval(x-r, y-r, r*2, r);
    }

    public static void drawGrass(Graphics2D g, int x, int y, Color c){
        g.setColor(c);
        g.drawLine(x, y, x-20, y-18);
        g.drawLine(x, y, x, y-30);
        g.drawLine(x, y, x+20, y-18);
    }

}
