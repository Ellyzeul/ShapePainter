package painters;

import java.awt.Graphics;
import java.awt.Point;

public class RectanglePainter implements ShapePainter {

    @Override
    public void draw(Graphics g, Point p0, Point p1) {
        g.drawLine(
            (int) p0.getX(), 
            (int) p0.getY(), 
            (int) p1.getX(), 
            (int) p0.getY()
        );
        g.drawLine(
            (int) p1.getX(), 
            (int) p0.getY(), 
            (int) p1.getX(), 
            (int) p1.getY()
        );
        g.drawLine(
            (int) p0.getX(), 
            (int) p1.getY(), 
            (int) p1.getX(), 
            (int) p1.getY()
        );
        g.drawLine(
            (int) p0.getX(), 
            (int) p1.getY(), 
            (int) p0.getX(), 
            (int) p0.getY()
        );
    }
    
}
