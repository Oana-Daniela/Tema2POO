//Puisor Oana-Daniela
//Grupa 321 CD

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Desenator implements Visitor {

  private BufferedImage imaginea = null;
  private Graphics graphics = null;

  /**
   *  Salvez ca png
   * @param str
   */
  public void exportaImagine(final String str) {

    File outputfile = new File(str);
    try {
      ImageIO.write(imaginea, "png", outputfile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    /**
     *
     */
    @Override
    public void visitCanvas(final Canvas canvas) {
        int h, w, a = 0;
        String r, g, b;
        final int cst0 = 0, cst1 = 1, cst2 = 2, cst3 = 3, cst4 = 4, cst5 = 5, cst7 = 7;

        String[] parts = canvas.getVariables().split(" ");
        h = Integer.parseInt(parts[cst1]);
        w = Integer.parseInt(parts[cst2]);
        r = parts[cst3].substring(cst0, cst3);
        g = "#" + parts[cst3].substring(cst3, cst5);
        b = "#" + parts[cst3].substring(cst5, cst7);
        a = Integer.parseInt(parts[cst4]);

        imaginea = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        graphics = imaginea.getGraphics();
        graphics.setPaintMode();

        Color c = new Color(Integer.decode(r), Integer.decode(g), Integer.decode(b), a);
        graphics.setColor(c);

        for (int i = 0; i < imaginea.getWidth(); i++) {
            for (int j = 0; j < imaginea.getHeight(); j++) {
                imaginea.setRGB(i, j, c.getRGB());
            }
        }
    }

    /**
     *
     */
    @Override
    public void visitLine(final Line line) {
        Bresenham alg = Bresenham.getInstance();

        int xStart, yStart, xEnd, yEnd, a;
        String r, g, b;
        final int cst0 = 0, cst1 = 1, cst2 = 2, cst3 = 3, cst4 = 4;
        final int cst5 = 5, cst6 = 6, cst7 = 7;

        String[] parts = line.getVariables().split(" ");
        xStart = Integer.parseInt(parts[cst1]);
        yStart = Integer.parseInt(parts[cst2]);
        xEnd = Integer.parseInt(parts[cst3]);
        yEnd = Integer.parseInt(parts[cst4]);

        r = parts[cst5].substring(cst0, cst3);
        g = "#" + parts[cst5].substring(cst3, cst5);
        b = "#" + parts[cst5].substring(cst5, cst7);
        a = Integer.parseInt(parts[cst6]);

        Color c = new Color(Integer.decode(r), Integer.decode(g), Integer.decode(b), a);

        alg.setX1(xStart);
        alg.setX2(xEnd);
        alg.setY1(yStart);
        alg.setY2(yEnd);
        alg.bresenhamAlg(xStart, xEnd, yStart, yEnd, imaginea, c);
    }

    /**
     *
     */
    @Override
    public void visitSquare(final Square square) {
        int x, y, l, a1, a2, xTemp, yTemp;
        String r1, g1, b1, r2, g2, b2;
        final int cst0 = 0, cst1 = 1, cst2 = 2, cst3 = 3, cst4 = 4;
        final int cst5 = 5, cst6 = 6, cst7 = 7;

        String[] parts = square.getVariables().split(" ");
        x = Integer.parseInt(parts[cst1]);
        y = Integer.parseInt(parts[cst2]);
        l = Integer.parseInt(parts[cst3]);

        r1 = parts[cst4].substring(cst0, cst3);
        g1 = "#" + parts[cst4].substring(cst3, cst5);
        b1 = "#" + parts[cst4].substring(cst5, cst7);
        a1 = Integer.parseInt(parts[cst5]);
        Integer.decode(b1);

        r2 = parts[cst6].substring(cst0, cst3);
        g2 = "#" + parts[cst6].substring(cst3, cst5);
        b2 = "#" + parts[cst6].substring(cst5, cst7);
        a2 = Integer.parseInt(parts[cst7]);

        Color c1 = new Color(Integer.decode(r1), Integer.decode(g1), Integer.decode(b1), a1);
        Color c2 = new Color(Integer.decode(r2), Integer.decode(g2), Integer.decode(b2), a2);

        if (x + l > imaginea.getWidth()) {
            xTemp = imaginea.getWidth();
        } else {
            xTemp = x + l;
        }

        if (y + l > imaginea.getHeight()) {
            yTemp = imaginea.getHeight();
        } else {
            yTemp = y + l;
        }
        int i, j;
        for (i = x; i < xTemp; i++) {
            for (j = y; j < yTemp; j++) {
                if (i == x || i == x + l - 1 || j == y || j == y + l - 1) {
                    imaginea.setRGB(i, j, c1.getRGB());
                } else {
                    imaginea.setRGB(i, j, c2.getRGB());
                }
            }
        }
    }

    /**
     *
     */
    @Override
    public void visitRectangle(final Rectangle rectangle) {
        int x, y, h, l, a1, a2, xTemp, yTemp;
        String r1, g1, b1, r2, g2, b2;
        final int cst0 = 0, cst1 = 1, cst2 = 2, cst3 = 3, cst4 = 4;
        final int cst5 = 5, cst6 = 6, cst7 = 7, cst8 = 8;

        String[] parts = rectangle.getVariables().split(" ");
        x = Integer.parseInt(parts[cst1]);
        y = Integer.parseInt(parts[cst2]);
        h = Integer.parseInt(parts[cst3]);
        l = Integer.parseInt(parts[cst4]);

        r1 = parts[cst5].substring(cst0, cst3);
        g1 = "#" + parts[cst5].substring(cst3, cst5);
        b1 = "#" + parts[cst5].substring(cst5, cst7);
        a1 = Integer.parseInt(parts[cst6]);

        r2 = parts[cst7].substring(cst0, cst3);
        g2 = "#" + parts[cst7].substring(cst3, cst5);
        b2 = "#" + parts[cst7].substring(cst5, cst7);
        a2 = Integer.parseInt(parts[cst8]);

        Color c1 = new Color(Integer.decode(r1), Integer.decode(g1),
                Integer.decode(b1), Integer.hashCode(a1));
        Color c2 = new Color(Integer.decode(r2), Integer.decode(g2),
                Integer.decode(b2), Integer.hashCode(a2));

        if (x + l > imaginea.getWidth()) {
            xTemp = imaginea.getWidth();
        } else {
            xTemp = x + l;
        }

        if (y + h > imaginea.getHeight()) {
            yTemp = imaginea.getHeight();
        } else {
            yTemp = y + h;
        }
        int i, j;
        for (i = x; i < xTemp; i++) {
            for (j = y; j < yTemp; j++) {
                if (i == x || i == x + l - 1 || j == y || j == y + h - 1) {
                    imaginea.setRGB(i, j, c1.getRGB());
                } else {
                    imaginea.setRGB(i, j, c2.getRGB());
                }
            }
        }
    }

    /**
     *
     */
    @Override
    public void visitCircle(final Circle circle) {
        int x, y, r, a1, a2;
        String r1, g1, b1, r2, g2, b2;
        final int cst0 = 0, cst1 = 1, cst2 = 2, cst3 = 3, cst4 = 4;
        final int cst5 = 5, cst6 = 6, cst7 = 7;

        String[] parts = circle.getVariables().split(" ");
        x = Integer.parseInt(parts[cst1]);
        y = Integer.parseInt(parts[cst2]);
        r = Integer.parseInt(parts[cst3]);

        r1 = parts[cst4].substring(cst0, cst3);
        g1 = "#" + parts[cst4].substring(cst3, cst5);
        b1 = "#" + parts[cst4].substring(cst5, cst7);
        a1 = Integer.parseInt(parts[cst5]);

        r2 = parts[cst6].substring(cst0, cst3);
        g2 = "#" + parts[cst6].substring(cst3, cst5);
        b2 = "#" + parts[cst6].substring(cst5, cst7);
        a2 = Integer.parseInt(parts[cst7]);

        Color c1 = new Color(Integer.decode(r1), Integer.decode(g1), Integer.decode(b1), a1);
        Color c2 = new Color(Integer.decode(r2), Integer.decode(g2), Integer.decode(b2), a2);

        BresenhamCircle alg = BresenhamCircle.getInstance();
        alg.setX(x);
        alg.setY(y);
        alg.setR(r);
        alg.setWidth(imaginea.getWidth());
        alg.setHeight(imaginea.getHeight());
        imaginea = alg.drawBres(imaginea, c1);

        FloodFill umplere = FloodFill.getInstance();
        umplere.setX(x);
        umplere.setY(y);
        umplere.setImaginea(imaginea);
        imaginea = umplere.floodFillAplica(c1, c2);
    }

    /**
     *
     */
    @Override
    public void visitTriangle(final Triangle triangle) {
        Bresenham alg = Bresenham.getInstance();
        int x1, y1, x2, y2, x3, y3, a1, a2, xGreutate, yGreutate;
        String r1, g1, b1, r2, g2, b2;
        final int cst0 = 0, cst1 = 1, cst2 = 2, cst3 = 3, cst4 = 4;
        final int cst5 = 5, cst6 = 6, cst7 = 7;
        final int cst8 = 8, cst9 = 9, cst10 = 10;

        String[] parts = triangle.getVariables().split(" ");
        x1 = Integer.parseInt(parts[cst1]);
        y1 = Integer.parseInt(parts[cst2]);

        x2 = Integer.parseInt(parts[cst3]);
        y2 = Integer.parseInt(parts[cst4]);

        x3 = Integer.parseInt(parts[cst5]);
        y3 = Integer.parseInt(parts[cst6]);

        r1 = parts[cst7].substring(cst0, cst3);
        g1 = "#" + parts[cst7].substring(cst3, cst5);
        b1 = "#" + parts[cst7].substring(cst5, cst7);
        a1 = Integer.parseInt(parts[cst8]);

        r2 = parts[cst9].substring(cst0, cst3);
        g2 = "#" + parts[cst9].substring(cst3, cst5);
        b2 = "#" + parts[cst9].substring(cst5, cst7);
        a2 = Integer.parseInt(parts[cst10]);

        Color c1 = new Color(Integer.decode(r1), Integer.decode(g1), Integer.decode(b1), a1);
        Color c2 = new Color(Integer.decode(r2), Integer.decode(g2), Integer.decode(b2), a2);

        alg.setX1(x1);
        alg.setX2(x2);
        alg.setY1(y1);
        alg.setY2(y2);
        alg.bresenhamAlg(x1, x2, y1, y2, imaginea, c1);
        alg.setX1(x2);
        alg.setX2(x3);
        alg.setY1(y2);
        alg.setY2(y3);
        alg.bresenhamAlg(x2, x3, y2, y3, imaginea, c1);
        alg.setX1(x3);
        alg.setX2(x1);
        alg.setY1(y3);
        alg.setY2(y1);
        alg.bresenhamAlg(x3, x1, y3, y1, imaginea, c1);

        FloodFill umplere = FloodFill.getInstance();
        xGreutate = (x1 + x2 + x3) / cst3;
        yGreutate = (y1 + y2 + y3) / cst3;
        umplere.setX(xGreutate);
        umplere.setY(yGreutate);
        umplere.setImaginea(imaginea);
        imaginea = umplere.floodFillAplica(c1, c2);
    }

    /**
     * Calculez colturile rombului si realizez linia dintre ele
     */
    @Override
    public void visitDiamond(final Diamond diamond) {
    	Bresenham alg = Bresenham.getInstance();
        int x, y, dOrizontal, dVertical, a1, a2;
        String r1, g1, b1, r2, g2, b2;
        final int cst0 = 0, cst1 = 1, cst2 = 2, cst3 = 3, cst4 = 4;
        final int cst5 = 5, cst6 = 6, cst7 = 7;
        final int cst8 = 8;

        String[] parts = diamond.getVariables().split(" ");
        x = Integer.parseInt(parts[cst1]);
        y = Integer.parseInt(parts[cst2]);
        dOrizontal = Integer.parseInt(parts[cst3]);
        dVertical = Integer.parseInt(parts[cst4]);

        r1 = parts[cst5].substring(cst0, cst3);
        g1 = "#" + parts[cst5].substring(cst3, cst5);
        b1 = "#" + parts[cst5].substring(cst5, cst7);
        a1 = Integer.parseInt(parts[cst6]);

        r2 = parts[cst7].substring(cst0, cst3);
        g2 = "#" + parts[cst7].substring(cst3, cst5);
        b2 = "#" + parts[cst7].substring(cst5, cst7);
        a2 = Integer.parseInt(parts[cst8]);

        Color c1 = new Color(Integer.decode(r1), Integer.decode(g1), Integer.decode(b1), a1);
        Color c2 = new Color(Integer.decode(r2), Integer.decode(g2), Integer.decode(b2), a2);

        int xSouth = x;
        int ySouth = y - dVertical / cst2;

        int xNorth = x;
        int yNorth = y + dVertical / cst2;

        int xWest = x - dOrizontal / cst2;
        int yWest = y;

        int xEast = x + dOrizontal / cst2;
        int yEast = y;

        alg.setX1(xSouth);
        alg.setX2(xEast);
        alg.setY1(ySouth);
        alg.setY2(yEast);
        alg.bresenhamAlg(xSouth, xEast, ySouth, yEast, imaginea, c1);
        alg.setX1(xSouth);
        alg.setX2(xWest);
        alg.setY1(ySouth);
        alg.setY2(yWest);
        alg.bresenhamAlg(xSouth, xWest, ySouth, yWest, imaginea, c1);
        alg.setX1(xNorth);
        alg.setX2(xEast);
        alg.setY1(yNorth);
        alg.setY2(yEast);
        alg.bresenhamAlg(xNorth, xEast, yNorth, yEast, imaginea, c1);
        alg.setX1(xNorth);
        alg.setX2(xWest);
        alg.setY1(yNorth);
        alg.setY2(yWest);
        alg.bresenhamAlg(xNorth, xWest, yNorth, yWest, imaginea, c1);

        FloodFill umplere = FloodFill.getInstance();
        umplere.setX(x);
        umplere.setY(y);
        umplere.setImaginea(imaginea);
        imaginea = umplere.floodFillAplica(c1, c2);
    }

    /**
     * Realizez liniile dintre puncte
     * Calculez centrul de greutate al poligonului
     */
    @Override
    public void visitPolygon(final Polygon polygon) {
    	Bresenham alg = Bresenham.getInstance();
        int nrCoords, i, k = 2, p = 0, a1, a2, xGreutate = 0, yGreutate = 0;
        String r1, g1, b1;
        String r2, g2, b2;
        final int cst0 = 0, cst1 = 1, cst3 = 3;
        final int cst5 = 5, cst7 = 7;

        String[] parts = polygon.getVariables().split(" ");
        nrCoords = Integer.parseInt(parts[cst1]);
        int[] coordsX = new int[nrCoords];
        int[] coordsY = new int[nrCoords];

        for (i = 0; i < nrCoords; i++) {
            coordsX[i] = Integer.parseInt(parts[k]);
            k++;
            coordsY[i] = Integer.parseInt(parts[k]);
            k++;
        }

        r1 = parts[k].substring(cst0, cst3);
        g1 = "#" + parts[k].substring(cst3, cst5);
        b1 = "#" + parts[k].substring(cst5, cst7);
        a1 = Integer.parseInt(parts[k + 1]);

        r2 = parts[k + 2].substring(cst0, cst3);
        g2 = "#" + parts[k + 2].substring(cst3, cst5);
        b2 = "#" + parts[k + 2].substring(cst5, cst7);
        a2 = Integer.parseInt(parts[k + cst3]);

        Color c1 = new Color(Integer.decode(r1), Integer.decode(g1), Integer.decode(b1), a1);
        Color c2 = new Color(Integer.decode(r2), Integer.decode(g2), Integer.decode(b2), a2);

        while (p < nrCoords - 1) {
            alg.setX1(coordsX[p]);
            alg.setY1(coordsY[p]);
            p++;
            alg.setX2(coordsX[p]);
            alg.setY2(coordsY[p]);
            alg.bresenhamAlg(alg.getX1(), alg.getX2(), alg.getY1(), alg.getY2(), imaginea, c1);
        }
        alg.setX1(coordsX[p]);
        alg.setX2(coordsX[0]);
        alg.setY1(coordsY[p]);
        alg.setY2(coordsY[0]);
        alg.bresenhamAlg(alg.getX1(), alg.getX2(), alg.getY1(), alg.getY2(), imaginea, c1);

        int suma = cst0;

        for (int j = 0; j < nrCoords; j++) {
            int intersectie = coordsX[j] * coordsY[(j + 1) % nrCoords]
                    - coordsY[j] * coordsX[(j + cst1) % nrCoords];
            suma += intersectie;
            xGreutate += (coordsX[j] + coordsX[(j + cst1) % nrCoords]) * intersectie;
            yGreutate += (coordsY[j] + coordsY[(j + cst1) % nrCoords]) * intersectie;

        }
        xGreutate = xGreutate / (cst3 * suma);
        yGreutate = yGreutate / (cst3 * suma);

        FloodFill umplere = FloodFill.getInstance();
        umplere.setX(xGreutate);
        umplere.setY(yGreutate);
        umplere.setImaginea(imaginea);
        imaginea = umplere.floodFillAplica(c1, c2);
    }
}
