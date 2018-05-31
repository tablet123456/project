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
	/*@Test
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
*/
	@Test
	public void DirectionalLighttest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(150);
		scene.set_background(new Color(255, 255, 255));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0));
		scene.get_lights().add(new DirectionalLight(new Vector(2.5,-2.5,2.5),new Color(255,255,255)));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(255,0,0),new Material (1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(150,75,150),new Point3D(-150,75,150),new Point3D(0,-150,150),new Color(0,0,255),new Material(0.5,1.5,12)));
			
		geometries.addGeometry(new Triangle(new Point3D(150,-75,150),new Point3D(-150,-75,150),new Point3D(0,150,150),new Color(0,0,255),new Material(1,1,12)));
		
		//next//
		
        geometries.addGeometry(new Triangle(new Point3D(-100,-150,150),new Point3D(-150,-75,150),new Point3D(0,-150,150),new Color(255,0,0),new Material(0.5,1.5,12)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,-150,150),new Point3D(150,-75,150),new Point3D(0,-150,150),new Color(255,0,0),new Material(1,1,12)));
	
		geometries.addGeometry(new Triangle(new Point3D(-200,0,150),new Point3D(-150,-75,150),new Point3D(-150, 75, 150),new Color(255,0,0),new Material(0.5,1.5,12)));
			
		geometries.addGeometry(new Triangle(new Point3D(200,0,150),new Point3D(150,-75,150),new Point3D(150,75,150),new Color(255,0,0),new Material(1,1,12)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100,150,150),new Point3D(-150,75,150),new Point3D(0, 150, 150),new Color(255,0,0),new Material(0.5,1.5,12)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,150,150),new Point3D(150,75,150),new Point3D(0,150,150),new Color(255,0,0),new Material(1,1,12)));
		
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(-50,-75,150),new Point3D(-150,-75,150),new Point3D(0,-150,150),new Color(0,255,0),new Material(0.5,1.5,12)));
			
		geometries.addGeometry(new Triangle(new Point3D(50,-75,150),new Point3D(150 ,-75,150),new Point3D(0,-150,150),new Color(0,255,0),new Material(1,1,12)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100,0,150),new Point3D(-150,-75,150),new Point3D(-150,75,150),new Color(0,255,0),new Material(0.5,1.5,12)));
				
		geometries.addGeometry(new Triangle(new Point3D(100,0,150),new Point3D(150,-75,150),new Point3D(150,75,150),new Color(0,255,0),new Material(1,1,12)));
			
		geometries.addGeometry(new Triangle(new Point3D(-50,75,150),new Point3D(-150,75,150),new Point3D(0,150,150),new Color(0,255,0),new Material(0.5,1.5,12)));
			
		geometries.addGeometry(new Triangle(new Point3D(50,75,150),new Point3D(150,75,150),new Point3D(0,150,150),new Color(0,255,0),new Material(1,1,12)));
		
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(100,50,150),new Point3D(-100,50,150),new Point3D(0,-100,150),new Color(0,0,255),new Material(1,1,12)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,-50,150),new Point3D(-100,-50,150),new Point3D(0,100,150),new Color(0,0,255),new Material(0.5,1.5,12)));
		
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(-250,200,150),new Point3D(250,200,150),new Point3D(-250,125,150),new Color(0,0,255),new Material(0.5,1.5,12)));
			
		geometries.addGeometry(new Triangle(new Point3D(-250,125,150),new Point3D(250,200,150),new Point3D(250,125,150),new Color(0,0,255),new Material(1,1,12)));
		
		geometries.addGeometry(new Triangle(new Point3D(-250,-200,150),new Point3D(250,-125,150),new Point3D(-250,-125,150),new Color(0,0,255),new Material(0.5,1.5,12)));
		
		geometries.addGeometry(new Triangle(new Point3D(-250,-200,150),new Point3D(250,-200,150),new Point3D(250,-125,150),new Color(0,0,255),new Material(1,1,12)));
		
		ImageWriter imageWriter = new ImageWriter("direction", 500, 500, 500, 500);
     	Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.writeToimage();
	}

/*	
	@Test
	public void Pointlighttest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(350);
		scene.set_background(new Color(0, 0, 0));
		Geometries geometries = new Geometries();
		scene.set_geometries(geometries);
		scene.set_ambientLight(new AmbientLight(new Color (255,255,255),0.3));
		scene.get_lights().add(new PointLight(new Point3D(0,0,-5) ,1,0,0.3,new Color(255,255,255)));
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,255),new Material(0,4,12)));
		
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
		Vector Dir = new Point3D(0, 0, 150).subtract(new Point3D(0, 0, 61));
		scene.get_lights().add(new SpotLight(new Point3D(35, -15, 1), 1, 0.7, 0.4, new Color(100, 100, 100),
				Dir.subtract(new Vector(9, 0, 3))));

		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(255,0,0),new Material(2,24,1222)));
	
		ImageWriter imageWriter = new ImageWriter("spot", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
	
		render.renderImage();
		render.printGrid(50);
	    render.writeToimage();
	}
	@Test
	  public void shadowTest() {
	    Scene scene = new Scene("Test shadow");
	    scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, 0, 1), new Vector(0, -1, 0)));
	    scene.set_screenDistance(100);
	    scene.set_background(new Color(0,0,0));
	    Geometries geometries = new Geometries();
	    scene.get_lights().add(new SpotLight( new Point3D(15,0,0),0, 0,0, new Color(255,255,255),new Vector(-15,0,80)));;
	    geometries.addGeometry(new Sphere( 60,new Point3D(0, 0, 80), new Color(241, 6, 151),new Material(0.9,0.8,1000)));
	    geometries.addGeometry(new Triangle(new Point3D(-250,-250,120),new Point3D(-250,250,120),new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9, 0.8, 100)));
	    geometries.addGeometry(new Triangle(new Point3D(250,250,120),new Point3D(-250,250,120),new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9, 0.8, 100)));
	   
	  
	    ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
	    Render render = new Render(imageWriter, scene);
	    render.renderImage();
	    render.writeToimage();
	    render.printGrid(50);
	  }*/
}	