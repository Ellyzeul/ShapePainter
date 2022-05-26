package painters;

import java.awt.Graphics;
import java.awt.Point;

public class CirclePainter implements ShapePainter {

    @Override
    public void draw(Graphics g, Point p0, Point p1) {
        Point center = new Point(
            (int) (p0.getX() + p1.getX()) / 2,
            (int) (p0.getY() + p1.getY()) / 2
        );
        Point meanPoint = new Point(
            (int) (p0.getX() + p1.getX()) / 2,
            (int) p0.getY()
        );
        double radiusSquared = Point.distanceSq(
            center.getX(), 
            center.getY(), 
            meanPoint.getX(), 
            meanPoint.getY()
        );
        int y0 = (int) p0.getY();
        int y1 = (int) p1.getY();
        int x0;
        int x1;

        Boolean p0IsLower = Integer.compare(y0, y1) == -1 ? true : false;
        for(int i = y0; p0IsLower ? i < y1 : i > y1; i += p0IsLower ? 1 : -1) {
            x0 = (int) (radiusSquared - ((i - center.getY()) * (i - center.getY())));
            // g.drawOval(x, y, width, height);
        }
    }
    
}
