import painters.FreePainter;
import painters.LinePainter;
import painters.RectanglePainter;
import painters.ShapePainter;
import painters.TrianglePainter;

public enum Polygons {
    FREE("Mão livre"),
    LINE("Reta"),
    RECTANGLE("Retângulo"),
    TRIANGLE("Triângulo");

    private String id;

    Polygons(String id) {
        this.id = id;
    }

    public String getValue() {
        return id;
    }

    public ShapePainter getPainter() {
        if(id == "Mão livre") return new FreePainter();
        if(id == "Reta") return new LinePainter();
        if(id == "Retângulo") return new RectanglePainter();
        if(id == "Triângulo") return new TrianglePainter();

        return null;
    }
}
