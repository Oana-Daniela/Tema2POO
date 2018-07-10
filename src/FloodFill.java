//Puisor Oana-Daniela
//Grupa 321 CD
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public final class FloodFill {

    private int x;
    private int y;
    BufferedImage imagineaP;

    private static FloodFill instance = new FloodFill();

    private FloodFill() { }

    protected static FloodFill getInstance() {
        return instance;
    }

    /**
     *
     * @param abs
     */
    public void setX(final int abs) {
        this.x = abs;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param ord
     */
    public void setY(final int ord) {
        this.y = ord;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param imaginea
     */
    public void setImaginea(BufferedImage imaginea) {
        this.imagineaP = imaginea;
    }

    /**
     *
     * @return
     */
    public BufferedImage getImaginea() {
        return imagineaP;
    }

    /**
     * Setez culoarea pentru pixelii invecinati
     * @param c1
     * @param c2
     * @return
     */
    public BufferedImage floodFillAplica(final Color c1, final Color c2) {

        int culoareStop = c1.getRGB();
        boolean[][] pixeli = new boolean[imagineaP.getWidth()][imagineaP.getHeight()];

        Queue<Point> coada = new LinkedList<Point>();
        coada.add(new Point(x, y));

        while (!coada.isEmpty()) {
            Point punct = coada.remove();

            if (testAndPaint(pixeli, punct.x, punct.y, culoareStop, c2)) {
                coada.add(new Point(punct.x, punct.y - 1));
                coada.add(new Point(punct.x, punct.y + 1));
                coada.add(new Point(punct.x - 1, punct.y));
                coada.add(new Point(punct.x + 1, punct.y));
            }
        }

        return imagineaP;

    }

    /**
     * testam daca pixel-ul se afla in interiorul imaginii
     * testam daca am pictat deja pixelul
     * testam daca pixelul are culoarea conturului, caz in care nu vom returna
     * caz valid: umplem cu culoare pixelul si punem echivalentul din matrice in
     * @param pixeli
     * @param x
     * @param y
     * @param culoareStop
     * @param c2
     * @return
     */
    private boolean testAndPaint(final boolean[][] pixeli, final int xP, final int yP,

        final int culoareStop, final Color c2) {
        if (xP < 0 || xP > (imagineaP.getWidth() - 1)) {
            return false;
        }
        if (yP < 0 || yP > (imagineaP.getHeight() - 1)) {
            return false;
        }

        if (pixeli[xP][yP]) {
            return false;
        }

        if (imagineaP.getRGB(xP, yP) == culoareStop) {
            return false;
        }

        imagineaP.setRGB(xP, yP, c2.getRGB());
        pixeli[xP][yP] = true;
        return true;
    }

}
