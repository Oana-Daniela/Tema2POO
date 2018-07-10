//Puisor Oana-Daniela
//Grupa 321 CD
public interface Visitor {

    void visitCanvas(Canvas canvas);

    void visitLine(Line line);

    void visitSquare(Square square);

    void visitRectangle(Rectangle rectangle);

    void visitCircle(Circle circle);

    void visitTriangle(Triangle triangle);

    void visitDiamond(Diamond diamond);

    void visitPolygon(Polygon polygon);
}
