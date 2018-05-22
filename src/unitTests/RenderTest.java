package unitTests;

/**
 * 
 * @author tzvibloom
 * 
 */

import org.junit.jupiter.api.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;
public class RenderTest {
	@Test
	public void basicRendering() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(150);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0.3));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,0),new Material(1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149),new Point3D(  0,  -100, 149),new Point3D(-100, -100, 149),new Color(255,255,0),new Material(1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, -100, 149),new Point3D( 100,-100, 149),new Color(255,80,0),new Material(1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( -100, 0, 149),new Point3D(  0, 100, 149),new Point3D( -100, 100, 149),new Color(0,0,255),new Material(1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, 100, 149),new Point3D( 100, 100, 149),new Color(255,0,0),new Material(1,1,1)));
		
		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToimage();
	}

	@Test
	public void DirectionalLighttest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(400);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0.3));
		scene.get_lights().add(new DirectionalLight(new Vector(10,1,1),new Color(0,0,255)));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,0),new Material (3,1,1)));
		
		ImageWriter imageWriter = new ImageWriter("direction", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToimage();
	}
	
	@Test
	public void Pointlighttest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(400);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0.3));
		scene.get_lights().add(new PointLight(new Point3D(0,0,50) ,1,0,0.1,new Color(0,255,0)));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,0),new Material(3,1,1)));
		
		ImageWriter imageWriter = new ImageWriter("point", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToimage();
	}
	
	@Test
	public void Spotlighttest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(400);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0.3));
		scene.get_lights().add(new SpotLight(new Point3D(0,0,0),1,0,1,new Color(255,0,0),new Vector(0,0,50)));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,0),new Material(1,1,1)));
	
		ImageWriter imageWriter = new ImageWriter("spot", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
	
		render.renderImage();
		render.printGrid(50);
		render.writeToimage();
	}

}	