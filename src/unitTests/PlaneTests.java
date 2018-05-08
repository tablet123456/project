package unitTests;
import primitives.*;
import geometries.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import elements.*;
class PlaneTests {

	@Test
	public void testIntersectionPoints() throws Exception{ 
			final int width = 3;
			final int height = 3;
			Ray[][] rays = new Ray [width][height];
			Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
					
					new Vector (0.0, 1.0, 0.0),
					new Vector (0.0, 0.0, -1.0));
			
			 //plane orthogonal to the view plane
			
			Plane plane = new Plane(new Point3D(0.0, 0.0, -3.0), new Vector(0.0, 0.0, -1.0));
			
			//45 degrees to the view plane
			
			Plane plane2 = new Plane(new Point3D(0.0, 0.0, -3.0), new Vector(0.0, 0.25, -1.0));
			
			List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
			List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();
			
			System.out.println("Camera:\n" + camera);
			
			for (int i = 0; i < height; i++){
				for (int j = 0; j < width; j++){
					rays[i][j] = camera.constructRayThroughPixel(width, height, j, i, 1, 3 * width, 3 * height);
					
					List<Point3D> rayIntersectionPoints = plane.findintersection(rays[i][j]);
					List<Point3D> rayIntersectionPoints2 = plane2.findintersection(rays[i][j]);
					
					for (Point3D iPoint: rayIntersectionPoints)
						intersectionPointsPlane.add(iPoint);
					
					for (Point3D iPoint: rayIntersectionPoints2)
						intersectionPointsPlane2.add(iPoint);
					
				}
			}
			assertTrue(intersectionPointsPlane. size() == 9);
			assertTrue(intersectionPointsPlane2.size() == 9);
			
			for (Point3D iPoint: intersectionPointsPlane)
				System.out.println(iPoint);
			
			System.out.println("---");
			
			for (Point3D iPoint: intersectionPointsPlane2)
				System.out.println(iPoint);
			
		}
}
		
	