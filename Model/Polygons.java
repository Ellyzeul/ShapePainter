package Model;


public enum Polygons {
    FREE("Mão livre"),
    LINE("Reta"),
    RECTANGLE("Retângulo"),
    TRIANGLE("Triângulo"),
    CIRCLE("Circulo"),
    ELLIPSE("Elipse");

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
        if(id == "Circulo") return new CirclePainter();
        if(id == "Elipse") return new EllipsePainter();

        return null;
    }
}
