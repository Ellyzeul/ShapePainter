package Model;

import java.awt.Graphics;
import java.awt.Point;


public class EllipsePainter implements ShapePainter {

    @Override
    public void draw(Graphics g, Point p0, Point p1) {
        Point center = new Point(
            (int) (p0.getX() + p1.getX()) / 2,
            (int) (p0.getY() + p1.getY()) / 2
        );
        int xR = (int) Point.distance(p0.getX(), center.getY(), center.getX(), center.getY());
        int yR = (int) Point.distance(center.getX(), p0.getY(), center.getX(), center.getY());
        int x = (int) center.getX() - xR;
        int y = (int) center.getY() - yR;
        
        g.drawOval(x, y, (xR * 2), (yR * 2));
    }
}
