package unitTests;

/**
 * 
 * @author tzvibloom
 * 
 */

import org.junit.jupiter.api.Test;

import elements.AmbientLight;
import elements.Camera;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;
public class RenderTest {
	@Test
	public void basicRendering() throws Exception{
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(150);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0.3));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,0)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149),new Point3D(  0,  -100, 149),new Point3D(-100, -100, 149),new Color(255,255,0)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, -100, 149),new Point3D( 100,-100, 149),new Color(255,80,0)));
		
		geometries.addGeometry(new Triangle(new Point3D( -100, 0, 149),new Point3D(  0, 100, 149),new Point3D( -100, 100, 149),new Color(0,0,255)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, 100, 149),new Point3D( 100, 100, 149),new Color(255,0,0)));
		
		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToimage();
	}
}
