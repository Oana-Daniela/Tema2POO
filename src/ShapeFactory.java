//Puisor Oana-Daniela
//Grupa 321 CD
public class ShapeFactory {

   private static ShapeFactory instance = new ShapeFactory();

    private ShapeFactory() { }

    protected static ShapeFactory getInstance() {
        return instance;
	}


    /**
    *
    * @param shapeType
    * @return
    */
     public Shape getShape(final String shapeType) {
       switch (shapeType.toLowerCase()) {
         case "canvas":
           Canvas canvas = new Canvas();
           return canvas;
         case "line":
           Line line = new Line();
           return line;
         case "square":
           Square square = new Square();
           return square;
         case "rectangle":
           Rectangle rectangle = new Rectangle();
           return rectangle;
         case "circle":
           Circle circle = new Circle();
           return circle;
         case "triangle":
           Triangle triangle = new Triangle();
           return triangle;
         case "diamond":
           Diamond diamond = new Diamond();
           return diamond;
         case "polygon":
           Polygon polygon = new Polygon();
           return polygon;
         default:
           return null;

       }
     }
}
