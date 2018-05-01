/**tzvi bloom 332272582 tzvi78@gmail.com 
 daniel schwelb  326873833 ddschwalb@gmail.com
 */
import geometries.*;
import primitives.*;

// Main that tests the classes.
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Coordinate coord = new Coordinate(1);
		Coordinate coord1 = new Coordinate(3);
		Coordinate coord2 =new Coordinate(2);
		
		Point3D point3 = new Point3D(5, 4, 3);
		Point3D point4 = new Point3D(point3);
		point4 = new Point3D(1 , 2, 3);
		Point3D point5 = new Point3D(9, 6, 8);
		Point3D point6 = new Point3D(1,2,3);
	
		Vector vector = new Vector(3.0, 5, 6);
		Vector vector1 = new Vector(point4);
		Vector vector2 = new Vector (coord,coord1,coord2);
		
		Ray ray = new Ray(1,2,3,2,3,1);
		Ray ray1 = new Ray(2, 4, 1, vector1);
		Ray ray2 = new Ray(point4, 2, 5, 6);
		
		Cylinder cylinder = new Cylinder(3, ray);
		
		Plane plane = new Plane(point3, vector);
		
		Sphere sphere = new Sphere(7, point4);
		
		Triangle triangle = new Triangle(point4, point3, point5);
		
		        // Checking Coordinates class
				
		System.out.println(coord.add(coord1));
				System.out.println(coord.multiply(coord1));
				System.out.println(coord.scale(5.0));
				System.out.println(coord.subtract(coord1));
				
				// Checking Point3Ds class
				
				System.out.println(point3.vecsubtract(point5));
				System.out.println(point4.add(vector));
				System.out.println(point5.subtract(point3));
				System.out.println(point3.distance(point5));
				
				// Checking Vectors class
				
				System.out.println((vector.add(vector1)).toString());
				System.out.println((vector1.subtract(vector2)).toString());
				System.out.println((vector.scale(1.5)).toString());
				System.out.println((vector2.dotProduct(vector1)));
				System.out.println((vector.crossProduct(vector2)).toString());
				System.out.println(vector.length());
				System.out.println(vector.normalize().toString());
				
				// Checking Triangles class
				
				System.out.println(triangle.getNormal(point6));
				
				// Checking Planes class
				System.out.println(plane.getNormal(point4));
				
				// Checking Spheres class
				
				System.out.println(sphere.getNormal(point4));
				
				// Checking Cylinders class
				
				System.out.println(cylinder.getNormal(point3));
			}
	}


