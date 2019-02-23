import java.awt.geom.Rectangle2D;

public class Homework13 {

	/* Write the class Triangle that implements the
	 * SmithShape interface. All SmithShape triangles have
	 * one edge that is on the horizontal and are defined by
	 * the angle (in degrees) of the lower left corner.
	 * Further instructions are located in the Triangle.java
	 * file
	 */

	 /* Create a Triangle with the indicated width, height,
	  * and angle. The x and y coordinates should both be 0.
	  * Return the Triangle.
	  */
	 public static Triangle problem1(int w, int h, double a) {
		 Triangle tri = new Triangle(0, 0, w, h, a);
		 return tri;
	 }

	 /* Return the area of parameter s
	  */
	 public static double problem2(SmithShape s) {
		 return s.getArea();
	 }

	 /* Return the value returned by the toString()
	  * method of parameter s
	  */
	 public static String problem3(SmithShape s) {
		 return s.toString();
	 }

	 /* Given SmithShape s, which is a Triangle,
	  * and a second angle given by a, calculate and
	  * return the third angle in s
	  * Remember that the angles in a triangle sum
	  * to 180
	  */
	 public static double problem4(SmithShape s, double a) {
		 Triangle t = (Triangle)s;
		 double num = 180 - (t.getAngle() + a);
		 return num;
	 }

	 /* Return the Rectangle2D that is created by the
	  * toSquare method of parameter s
	  */
	 public static Rectangle2D problem5(SmithShape s) {
		Triangle t = (Triangle) s;
		Rectangle2D result = t.toSquare();
		return result;
	 }

	 public static void main(String[] args) {
		 boolean passed = true;

		 SmithShape s = problem1(5, 10, 60);
		 if (s.getX() != 0) {
			 passed = false;
			 System.out.println("Fail 1.1");
		 } else if (s.getY() != 0) {
			 passed = false;
			 System.out.println("Fail 1.2");
		 } else if (s.getWidth() != 5) {
			 passed = false;
			 System.out.println("Fail 1.3");
		 } else if (s.getHeight() != 10) {
			 passed = false;
			 System.out.println("Fail 1.4");
		 } else {
			 System.out.println("Pass 1");
		 }

		 if (s.getArea() != 25.0) {
			 passed = false;
			 System.out.println("Fail 2");
		 } else {
			 System.out.println("Pass 2");
		 }

		 if (!problem3(s).equals("Width: 5\n" +
		 						 "Height: 10\n" +
								 "Angle: 60.0")) {
			 passed = false;
			 System.out.println("Fail 3");
		 } else {
			 System.out.println("Pass 3");
		 }

		 if (problem4(s, 90) != 30.0) {
			 passed = false;
			 System.out.println("Fail 4");
		 } else {
			 System.out.println("Pass 4");
		 }

		 Rectangle2D rect = problem5(s);
		 if (!rect.contains(3, 3)) {
			 passed = false;
			 System.out.println("Fail 5");
		 } else {
			 System.out.println("Pass 5");
		 }

		 if (passed) {
			 System.out.println("All Pass");
		 } else {
			 System.out.println("Fail");
		 }

	 }

}
