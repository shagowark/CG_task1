import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static  Color SKY_COLOR = new Color(134, 170, 234);
    private static final Color GROUND_COLOR = new Color(91, 241, 91);
    private static final Color CAT_COLOR = new Color(224, 130, 55);
    private static final Color GRASS_COLOR = new Color(35, 155, 35);
    private static final Color FLOWER_COLOR = new Color(197, 23, 54);
    private static final Color FLOWER_COLOR_2 = new Color(236, 252, 43);
    private static final Color SUN_COLOR = Color.ORANGE;
    private static final Color MOON_COLOR = Color.WHITE;

    private static final Random rnd = new Random();
    private Sun sun;
    private Timer timer;
    private boolean isDay = true;

    private Cat cat;
    private Cloud cloud1, cloud2, cloud3, cloud4;
    private Grass grass1, grass2, grass3, grass4, grass5, grass6;
    private Flower flower1, flower2;

    public DrawPanel() {
        sun = new Sun(90 + rnd.nextInt(50), 60, 30, 25, 20, 0, Color.ORANGE);
        cloud1 = new Cloud(300 + rnd.nextInt(100), 85, 80, Color.WHITE);
        cloud2 = new Cloud(450 + rnd.nextInt(300), 150, 60, Color.WHITE);
        cloud3 = new Cloud(90 + rnd.nextInt(50), 200, 60, Color.WHITE);
        cloud4 = new Cloud(550 + rnd.nextInt(200), 85, 40, Color.WHITE);
        flower2 = new Flower(100, 350, GRASS_COLOR, FLOWER_COLOR_2);
        grass2 = new Grass(150, 450, GRASS_COLOR);
        grass3 = new Grass(220, 370, GRASS_COLOR);
        grass4 = new Grass(700, 450, GRASS_COLOR);
        grass5 = new Grass(600, 525, GRASS_COLOR);
        flower1 = new Flower(400, 525, GRASS_COLOR, FLOWER_COLOR);


        timer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cloud1.setX(cloud1.getX()+2);
                cloud2.setX(cloud2.getX()+1);
                cloud3.setX(cloud3.getX()+1);
                cloud4.setX(cloud4.getX()+2);
                sun.setY(sun.getY()-1);
                if (isDay) {
                    sun.setN(10 + rnd.nextInt(10));
                    sun.setStartAngle(rnd.nextInt(20));
                }
                checkIfCloudIsOutOfBounds(cloud1);
                checkIfCloudIsOutOfBounds(cloud2);
                checkIfCloudIsOutOfBounds(cloud3);
                checkIfCloudIsOutOfBounds(cloud4);
                checkIfSunIsOutOfBounds(sun);
                repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(timer.isRunning()){
                    timer.stop();
                } else{
                    timer.start();
                }
            }
        });
    }

    private void checkIfCloudIsOutOfBounds(Cloud cloud){
        if (cloud.getX() - cloud.getR()*2> getWidth()){
            cloud.setX(-cloud.getR());
        }
    }
    private void checkIfSunIsOutOfBounds(Sun sun){
        if (sun.getY() + sun.getL() <= 0){
            sun.setY(getHeight()/2+sun.getL()+sun.getR());
            if (isDay){
                sun.setC(MOON_COLOR);
                sun.setN(0);
                SKY_COLOR = new Color(14, 8, 63);
                cloud1.setC(Color.GRAY);
                cloud2.setC(Color.GRAY);
                cloud3.setC(Color.GRAY);
                cloud4.setC(Color.GRAY);

            } else{
                sun.setC(SUN_COLOR);
                sun.setN(20);
                SKY_COLOR = new Color(134, 170, 234);
                cloud1.setC(Color.WHITE);
                cloud2.setC(Color.WHITE);
                cloud3.setC(Color.WHITE);
                cloud4.setC(Color.WHITE);
            }
            isDay = !isDay;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(SKY_COLOR);
        g2d.fillRect(0, 0, getWidth(), getHeight()/2);
        sun.drawSun(g2d);
        g2d.setColor(GROUND_COLOR);
        g2d.fillRect(0, getHeight()/2, getWidth(), getHeight()/2);
        cat = new Cat(getWidth()/2-100, getHeight()/2-50, 400, CAT_COLOR);



        cloud1.drawCloud(g2d);
        cloud2.drawCloud(g2d);
        cloud3.drawCloud(g2d);
        cloud4.drawCloud(g2d);
        flower2.drawFlower(g2d);
        grass2.drawGrass(g2d);
        grass3.drawGrass(g2d);
        grass4.drawGrass(g2d);
        grass5.drawGrass(g2d);
        flower1.drawFlower(g2d);
        cat.drawCat(g2d);
    }
}
