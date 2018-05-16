package unitTests;
import geometries.*;
import primitives.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import elements .*;
class SphereTests {

		@Test
		public void testIntersectionPoints() throws Exception{
			
			final int WIDTH = 3;
			final int HEIGHT = 3;
			Ray[][] rays = new Ray [HEIGHT][WIDTH];
			Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),new Vector (0.0, 1.0, 0.0),new Vector (0.0, 0.0, -1.0));
			
			Sphere sphere = new Sphere(1, new Point3D(0.0, 0.0, -3.0),new Color(255,128,0));
			Sphere sphere2 = new Sphere(10, new Point3D(0.0, 0.0, -3.0),new Color(255,128,0));
		
			//Only the center ray intersect the sphere in two locations
			List<Point3D> intersectionPointsSphere = new ArrayList<Point3D>();
			
			//The sphere encapsulates the view plane - all rays intersect with the sphere once
			List<Point3D> intersectionPointsSphere2 = new ArrayList<Point3D>();
			System.out.println("Camera:\n" + camera);
			for (int i = 0; i < HEIGHT; i++){
				for (int j = 0; j < WIDTH; j++)
				{
					
					rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
					
					Map<Geometry, List<Point3D>> rayIntersectionPoints = sphere.findintersection(rays[i][j]);
					Map<Geometry, List<Point3D>> rayIntersectionPoints2 = sphere2.findintersection(rays[i][j]);
					
					rayIntersectionPoints.forEach((k, v) -> {
						List<Point3D> l = new ArrayList<Point3D>();
						l = rayIntersectionPoints.get(k);
						intersectionPointsSphere.addAll(l);
					});

					rayIntersectionPoints2.forEach((k, v) -> {
						List<Point3D> l = new ArrayList<Point3D>();
						l = rayIntersectionPoints2.get(k);
						intersectionPointsSphere2.addAll(l);
					});
				}
			}
				assertTrue(intersectionPointsSphere.size() == 2);
				assertTrue(intersectionPointsSphere2.size() == 9);
				
				System.out.println("Intersection Points:");
				
				for (Point3D iPoint: intersectionPointsSphere)
				{
					assertTrue(iPoint.equals(new Point3D(0.0, 0.0, -2.0)) ||iPoint.equals(new Point3D(0.0, 0.0, -4.0)));
					System.out.println(iPoint);
				}
				System.out.println("Intersection Points Sphere 2:");
				for (Point3D iPoint: intersectionPointsSphere2) {
					System.out.println(iPoint);
				}
			
		}
	}

	