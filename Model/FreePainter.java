package Model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class FreePainter implements ShapePainter {
    private ArrayList<Point> points = new ArrayList<>();

    @Override
    public void draw(Graphics g, Point p0, Point p1) {
        points.add(p1);
        for (Point point : points) {
            g.fillOval(
                (int) point.getX(), 
                (int) point.getY(), 
                4, 
                4
            );
        }
    }
    
}
