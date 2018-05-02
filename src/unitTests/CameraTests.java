package unitTests;
import primitives.*;
import elements.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class CameraTests {

	Camera testCamera;

	@Test
	public void testConstructRayThroughPixel() {
		
		final int width = 3;
		final int height = 3;
		
		Point3D[][] screen = new Point3D [width][height];
		
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0), new Vector (0.0, 1.0, 0.0),new Vector (0.0, 0.0, -1.0));
		
		System.out.println("Camera:\n" + camera);
		
		for (int j = 0; j < height; j++){
			for (int i = 0; i < width; i++){
				
				Ray ray = camera.constructRayThroughPixel(width, height, i, j, 1, 3 * width, 3 * height);
				
				screen[i][j] = ray.get_p0();
				
				System.out.print(screen[i][j]);
				System.out.println(ray.get_direction());
				
				// checking z-coordinate
				assertTrue(Double.compare(screen[i][j].getZ().get(), -1.0) == 0);
				
				// Checking all options
				double x = screen[i][j].getX().get();
				double y = screen[i][j].getY().get();
				
				if (Double.compare(x, 3) == 0 ||
						Double.compare(x, 0) == 0 ||
						Double.compare(x, -3) == 0){
					
					if (Double.compare(y, 3) == 0 ||
							Double.compare(y, 0) == 0 ||
							Double.compare(y, -3) == 0){
						
						assertTrue(true);
					}
					else
						fail("Wrong y coordinate");
				} else
					fail("Wrong x coordinate");
			}
			System.out.println("---");
		}
	}

}