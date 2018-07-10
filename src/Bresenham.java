//Puisor Oana-Daniela
//Grupa 321 CD
import java.awt.Color;
import java.awt.image.BufferedImage;

public final class Bresenham {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private static Bresenham instance = new Bresenham();

    private Bresenham() { }

    protected static Bresenham getInstance() {
        return instance;
    }

    /**
     *
     * @param abs1
     */
    public void setX1(final int abs1) {
        this.x1 = abs1;
    }

    /**
     *
     * @return
     */
    public int getX1() {
        return x1;
    }

    /**
     *
     * @param abs2
     */
    public void setX2(final int abs2) {
        this.x2 = abs2;
    }

    /**
     *
     * @return
     */
    public int getX2() {
        return x2;
    }

    /**
     *
     * @param ord1
     */
    public void setY1(final int ord1) {
        this.y1 = ord1;
    }

    /**
     *
     * @return
     */
    public int getY1() {
        return y1;
    }

    /**
     *
     * @param ord2
     */
    public void setY2(final int ord2) {
        this.y2 = ord2;
    }

    /**
     *
     * @return
     */
    public int getY2() {
        return y2;
    }

    /**
     *
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param imagineaP
     * @param color
     */
    public void bresenhamAlg(int x1P, final int x2P, int y1P,
            final int y2P, final BufferedImage imagineaP, final Color color) {

        int cstNegativ = -1, cst1 = 1, cst2 = 2;
        int deltax = Math.abs(x2P - x1P);
        int deltay = Math.abs(y2P - y1P);

        int signx;
        if (x1P < x2P) {
            signx = cst1;
        } else {
            signx = cstNegativ;
        }

        int signy;
        if (y1P < y2P) {
            signy = cst1;
        } else {
            signy = cstNegativ;
        }

        int err = deltax - deltay;

        while (true) {
            if (x1P >= 0 && x1P < imagineaP.getWidth()
                    && y1P >= 0 && y1P < imagineaP.getHeight()) {
                imagineaP.setRGB(x1P, y1P, color.getRGB());
            }

            if (x1P == x2P && y1P == y2P) {
                break;
            }

            int err2 = cst2 * err;

            if (err2 > -deltay) {
                err = err - deltay;
                x1P = x1P + signx;
            }

            if (err2 < deltax) {
                err = err + deltax;
                y1P = y1P + signy;
            }
        }
    }
}
