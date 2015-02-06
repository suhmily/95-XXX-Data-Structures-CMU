
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * ************************************************************
 *
 * 95-772 Data Structures for Application Programmers
 *
 * Lab 4 Drawing a simple fractal of N squares with recursion
 *
 * Andrew ID: Name:sjaiswal
 *
 *************************************************************
 */
public class SimpleFractal {

    public static void main(String[] args) {
        /*
         * canvas width and height are both 1.0 
         * initial call to create 10 squares
         * please use the following initial call for consistency
         */
        fractal(10, 0, 0, 0.5);
    }

    /**
     * recursive method to draw a fractal of n number of squares
     *
     * @param n
     * @param x
     * @param y
     * @param length
     */
    public static void fractal(int n, double x, double y, double length) {
		// TODO implement this method
		/*
         * use filledSquare method in StdDraw class 
         * which draws a filled square of side length 2r, centered on (x, y).
         */
        if (n >= 1) {
            StdDraw.filledSquare(x+length/2, y+length/2, length / 2);
            fractal(--n, x + 2*length/2, y + 2*length/2, length / 2);
        } else {
            return;
        }
    }

}
