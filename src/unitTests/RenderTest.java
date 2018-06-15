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
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0.15));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,0),new Material(1,1,0,0,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149),new Point3D(  0,  -100, 149),new Point3D(-100, -100, 149),new Color(255,255,0),new Material(1,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, -100, 149),new Point3D( 100,-100, 149),new Color(255,80,0),new Material(1,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( -100, 0, 149),new Point3D(  0, 100, 149),new Point3D( -100, 100, 149),new Color(0,0,255),new Material(1,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, 100, 149),new Point3D( 100, 100, 149),new Color(255,0,0),new Material(1,1,1,1,1,1)));
		
		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.writeToimage();
	}

	@Test
	public void DirectionalLighttest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(100);
		scene.set_background(new Color(255, 255, 255));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0));
		scene.get_lights().add(new DirectionalLight(new Vector(2.5, 2.5, 2.5),new Color(55,55,55)));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 225),new Color(255,0,0),new Material (0.8,1, 1, 0, 0 ,13)));
		
     	//geometries.addGeometry(new Triangle(new Point3D(150,75,150),new Point3D(-150,75,150),new Point3D(0,-150,150),new Color(0,0,255),new Material(0.5,1,1,1,1,1)));
			
		//geometries.addGeometry(new Triangle(new Point3D(150,-75,150),new Point3D(-150,-75,150),new Point3D(0,150,150),new Color(0,0,255),new Material(1,1,1,1,1,1)));
		
		//next//
		
       /* geometries.addGeometry(new Triangle(new Point3D(-100,-150,150),new Point3D(-150,-75,150),new Point3D(0,-150,150),new Color(255,0,0),new Material(0.5,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,-150,150),new Point3D(150,-75,150),new Point3D(0,-150,150),new Color(255,0,0),new Material(1,1,1,1,1,1)));
	
		geometries.addGeometry(new Triangle(new Point3D(-200,0,150),new Point3D(-150,-75,150),new Point3D(-150, 75, 150),new Color(255,0,0),new Material(0.5,1,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(200,0,150),new Point3D(150,-75,150),new Point3D(150,75,150),new Color(255,0,0),new Material(1,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100,150,150),new Point3D(-150,75,150),new Point3D(0, 150, 150),new Color(255,0,0),new Material(0.5,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,150,150),new Point3D(150,75,150),new Point3D(0,150,150),new Color(255,0,0),new Material(1,1,1,1,1,1)));
		
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(-50,-75,150),new Point3D(-150,-75,150),new Point3D(0,-150,150),new Color(0,255,0),new Material(0.5,1,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(50,-75,150),new Point3D(150 ,-75,150),new Point3D(0,-150,150),new Color(0,255,0),new Material(1,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100,0,150),new Point3D(-150,-75,150),new Point3D(-150,75,150),new Color(0,255,0),new Material(0.5,1,1,1,1,1)));
				
		geometries.addGeometry(new Triangle(new Point3D(100,0,150),new Point3D(150,-75,150),new Point3D(150,75,150),new Color(0,255,0),new Material(1,1,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(-50,75,150),new Point3D(-150,75,150),new Point3D(0,150,150),new Color(0,255,0),new Material(0.5,1,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(50,75,150),new Point3D(150,75,150),new Point3D(0,150,150),new Color(0,255,0),new Material(1,1,1,1,1,1)));
		*/
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(100,50,150),new Point3D(-100,50,150),new Point3D(0,-100,150),new Color(0,0,125),new Material(1,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,-50,150),new Point3D(-100,-50,150),new Point3D(0,100,150),new Color(0,0,255),new Material(0.5,1,1,1,1,1)));
		
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(-250,200,150),new Point3D(250,200,150),new Point3D(-250,125,150),new Color(0,0,255),new Material(0.5,1,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(-250,125,150),new Point3D(250,200,150),new Point3D(250,125,150),new Color(0,0,255),new Material(1,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-250,-200,150),new Point3D(250,-125,150),new Point3D(-250,-125,150),new Color(0,0,255),new Material(0.5,1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-250,-200,150),new Point3D(250,-200,150),new Point3D(250,-125,150),new Color(0,0,255),new Material(1,1,1,1,1,1)));
		
		ImageWriter imageWriter = new ImageWriter("direction", 500, 500, 500, 500);
     	Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.writeToimage();
	}

	
	@Test
	public void Pointlighttest() {
		Scene scene = new Scene(" point");
		scene.set_camera(new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));
		scene.set_screenDistance(120);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color(255, 255, 255), 0));
		scene.get_lights().add(new PointLight(new Point3D(0, 0, 0), 1, 0, 0.1, new Color(255, 255, 255)));
		geometries.addGeometry(new Sphere(8, new Point3D(0, 0, -10), new Color(255, 90, 0), new Material(0.9, 1,0,0,0,20)));
		ImageWriter imageWriter = new ImageWriter("point", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		//render.printGrid(50);
		render.writeToimage();
	}
	
	@Test
	public void Spotlighttest() {
		Scene scene = new Scene("spot");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(350);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0));
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150), new Color(0, 0, 0), new Material(0.8, 0.7,0,0,0,12)));
		Vector Dir = new Point3D(0, 0, 150).subtract(new Point3D(60, 60, 60));
		scene.get_lights().add(new SpotLight(new Point3D(35, -15, 1), 1, 0.7, 0.4, new Color(150, 0, 0),
				Dir.subtract(new Vector(10, 0, 0))));

		ImageWriter imageWriter = new ImageWriter("spot", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
	
		render.renderImage();
		//render.printGrid(50);
	    render.writeToimage();
	}
	
}