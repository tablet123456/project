package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elements.Camera;

import org.junit.Test;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
public class RenderTest {
	@Test
	public void basicRendering(){
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(100);
		scene.set_background(new Color(0, 0, 0));
		Geometry geometries = new Geometry();
		scene.set_geometries(geometries);
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),
				 							new Point3D(  0, 100, 149),
				 							new Point3D( 100, 100, 149));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),
				 			 				new Point3D(  0, -100, 149),
				 			 				new Point3D( 100,-100, 149));
		
		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149),
				 							new Point3D(  0, 100, 149),
				 							new Point3D(-100, 100, 149));
		
		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149),
				 			 				new Point3D(  0,  -100, 149),
				 			 				new Point3D(-100, -100, 149));
		
		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToImage();
	}
