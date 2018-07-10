//Puisor Oana-Daniela
//Grupa 321 CD

public class Main {

    public static void main(final String[] args) throws Exception {

        ReadInput input = new ReadInput();
        final String str = args[0];
        input.setInput(str);

        ReadInput file = input.readTheFile(input.numberShapes, input.shapeStrings);

        Desenator desenator = new Desenator();
        final int cst0 = 0, cst1 = 1, cst2 = 2;
        final int cst4 = 4, cst6 = 6, cst7 = 7, cst8 = 8, cst9 = 9;
        int i;
        for (i = cst1; i <= file.numberShapes; i++) {
            ShapeFactory shapeF = ShapeFactory.getInstance();
            switch (file.shapeStrings[i].substring(cst0, cst2)) {
            case "CA":
                Canvas canvas = (Canvas) shapeF.getShape("canvas");
                canvas.setVariables(file.shapeStrings[i].substring(cst6));
                desenator.visitCanvas(canvas);
                break;
            case "LI":
                Line line = (Line) shapeF.getShape("line");
                line.setVariables(file.shapeStrings[i].substring(cst4));
                desenator.visitLine(line);
                break;
            case "SQ":
                Square square = (Square) shapeF.getShape("square");
                square.setVariables(file.shapeStrings[i].substring(cst6));
                desenator.visitSquare(square);
                break;
            case "RE":
                Rectangle rectangle = (Rectangle) shapeF.getShape("rectangle");
                rectangle.setVariables(file.shapeStrings[i].substring(cst9));
                desenator.visitRectangle(rectangle);
                break;
            case "CI":
                Circle circle = (Circle) shapeF.getShape("circle");
                circle.setVariables(file.shapeStrings[i].substring(cst6));
                desenator.visitCircle(circle);
                break;
            case "TR":
                Triangle triangle = (Triangle) shapeF.getShape("triangle");
                triangle.setVariables(file.shapeStrings[i].substring(cst8));
                System.out.println(triangle.getVariables());
                desenator.visitTriangle(triangle);
                break;
            case "DI":
                Diamond diamond = (Diamond) shapeF.getShape("diamond");
                diamond.setVariables(file.shapeStrings[i].substring(cst7));
                desenator.visitDiamond(diamond);
                break;
            case "PO":
                Polygon polygon = (Polygon) shapeF.getShape("polygon");
                polygon.setVariables(file.shapeStrings[i].substring(cst7));
                desenator.visitPolygon(polygon);
                break;
            default:
                break;

            }
        }

        desenator.exportaImagine("drawing.png");
    }

}
