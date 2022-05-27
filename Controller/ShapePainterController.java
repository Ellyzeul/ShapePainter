package Controller;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Model.Polygons;
import Model.ShapePainter;


public class ShapePainterController {
    private ShapePainter painter;
    private Object[] selectOptions;
    private HashMap<String, Polygons> validPolygons = new HashMap<>();

    public ShapePainterController() {
        Polygons[] rawList = Polygons.values();
        selectOptions = new Object[rawList.length];
        int optionsCount = 0;
        List<Polygons> list = Arrays.asList(rawList);
        for (Polygons polygon : list) {
            validPolygons.put(polygon.getValue(), polygon);
            selectOptions[optionsCount++] = polygon.getValue();
        }
    }

    public Object[] getSelectOptions() {
        return selectOptions;
    }

    public void setPainter(String option) {
        painter = validPolygons.get(option).getPainter();
    }

    public void draw(Graphics g, Point p0, Point p1) {
        if(painter != null && p0 != null && p1 != null) {
            painter.draw(g, p0, p1);
        }
    }
}
