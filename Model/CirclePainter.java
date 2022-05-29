package Model;

import java.awt.Graphics;
import java.awt.Point;


public class CirclePainter implements ShapePainter {

    @Override
    public void draw(Graphics g, Point p0, Point p1) {
        Point center = new Point(
            (int) (p0.getX() + p1.getX()) / 2,
            (int) (p0.getY() + p1.getY()) / 2
        );
        int radius = (int) Point.distance(center.getX(), p0.getY(), center.getX(), center.getY());
        int x = (int) center.getX() - radius;
        int y = (int) center.getY() - radius;
        
        g.drawOval(x, y, (radius * 2), (radius * 2));
    }
}
