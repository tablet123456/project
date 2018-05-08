package unitTests;
import primitives.*;
import geometries.*;
import elements.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class TriangleTests {

	@Test
	public void TriangleIntersectionPointsTest() throws Exception{
		
		final int width = 3;
		final int height = 3;
		
		Ray[][] rays = new Ray [width][height];
		
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),new Vector (0.0, 1.0, 0.0),new Vector (0.0, 0.0, -1.0));
		
		Triangle triangle = new Triangle(new Point3D( 0, 1, -2),new Point3D( 1, -1, -2),new Point3D(-1, -1, -2));
		
		Triangle triangle2 = new Triangle(new Point3D( 0, 20, -2),new Point3D( 1, -1, -2),new Point3D(-1, -1, -2));
		
		List<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
		List<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();
		System.out.println("Camera:\n" + camera);
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				rays[i][j] = camera.constructRayThroughPixel(width, height, i, j, 1, 3 * width, 3 * height);
				List<Point3D> rayIntersectionPoints = triangle.findintersection(rays[i][j]);
				List<Point3D> rayIntersectionPoints2= triangle2.findintersection(rays[i][j]);
				
				
				for (Point3D iPoint: rayIntersectionPoints)
					intersectionPointsTriangle.add(iPoint);
				
				for (Point3D iPoint: rayIntersectionPoints2)
					intersectionPointsTriangle2.add(iPoint);

			}
		}
		assertTrue(intersectionPointsTriangle.size() == 1);
		assertTrue(intersectionPointsTriangle2.size() == 2);
		
		System.out.println("Intersection Points:");
		
		for (Point3D iPoint: intersectionPointsTriangle)
			System.out.println(iPoint);
		System.out.println("--");
		
		for (Point3D iPoint: intersectionPointsTriangle2)
			System.out.println(iPoint);
	}
}