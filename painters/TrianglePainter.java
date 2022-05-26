package painters;

import java.awt.Graphics;
import java.awt.Point;

public class TrianglePainter implements ShapePainter {

    @Override
    public void draw(Graphics g, Point p0, Point p1) {
        int topX = (int) (p0.getX() + p1.getX()) / 2;
        g.drawLine(
            topX, 
            (int) p0.getY(), 
            (int) p1.getX(),  
            (int) p1.getY()
        );
        g.drawLine(
            (int) p1.getX(), 
            (int) p1.getY(), 
            (int) p0.getX(), 
            (int) p1.getY()
        );
        g.drawLine(
            (int) p0.getX(), 
            (int) p1.getY(), 
            topX, 
            (int) p0.getY()
        );
    }
    
}
