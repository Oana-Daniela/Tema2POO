//Puisor Oana-Daniela
//Grupa 321 CD
import java.awt.Color;
import java.awt.image.BufferedImage;

public final class BresenhamCircle {
    private int x;
    private int y;
    private int r;
    private int width, height;

    private static BresenhamCircle instance = new BresenhamCircle();

    private BresenhamCircle() { }

    protected static BresenhamCircle getInstance() {
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
     * @param raza
     */
    public void setR(final int raza) {
        this.r = raza;
    }

    /**
     *
     * @return
     */
    public int getR() {
        return r;
    }

    /**
     *
     * @param w
     */
    public void setWidth(final int w) {
        this.width = w;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param h
     */
    public void setHeight(final int h) {
        this.height = h;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param imagineaP
     * @param color
     * @return
     */
    public BufferedImage drawBres(BufferedImage imagineaP, final Color color) {
        final int cst2 = 2, cst3 = 3, cst4 = 4, cst10 = 10, cst6 = 6;
        int xc = 0;
        int yc = r;
        int d = cst3 - cst2 * r;

        while (yc >= xc) {
            imagineaP = drawCircle(xc, yc, imagineaP, color);
            xc++;

            if (d > 0) {
                yc--;
                d = d + cst4 * (xc - yc) + cst10;
            } else {
                d = d + cst4 * xc + cst6;
            }
            imagineaP = drawCircle(xc, yc, imagineaP, color);
        }

        return imagineaP;

    }

    /**
     *
     * @param xc
     * @param yc
     * @param imaginea
     * @param c
     * @return
     */
    public BufferedImage drawCircle(final int xc, final int yc,
            final BufferedImage imaginea, final Color c) {
        if (x + xc < width && y + yc < height) {
            imaginea.setRGB(x + xc, y + yc, c.getRGB());
        }
        if (x + yc < width && y + xc < height) {
            imaginea.setRGB(x + yc, y + xc, c.getRGB());
        }
        if (x - yc >= 0 && y + xc < height) {
            imaginea.setRGB(x - yc, y + xc, c.getRGB());
        }
        if (x - xc >= 0 && y + yc < height) {
            imaginea.setRGB(x - xc, y + yc, c.getRGB());
        }
        if (x - xc >= 0 && y - yc >= 0) {
            imaginea.setRGB(x - xc, y - yc, c.getRGB());
        }
        if (x - yc >= 0 && y - xc >= 0) {
            imaginea.setRGB(x - yc, y - xc, c.getRGB());
        }
        if (x + yc < width && y - xc >= 0) {
            imaginea.setRGB(x + yc, y - xc, c.getRGB());
        }
        if (x + xc < width && y - yc >= 0) {
            imaginea.setRGB(x + xc, y - yc, c.getRGB());
        }

        return imaginea;
    }

}
