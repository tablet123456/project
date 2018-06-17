package unitTests;



import java.util.ArrayList;
import java.util.List;

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
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150),new Color(0,0,0),new Material(1,1,1,0,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149),new Point3D(  0,  -100, 149),new Point3D(-100, -100, 149),new Color(255,255,0),new Material(1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, -100, 149),new Point3D( 100,-100, 149),new Color(255,80,0),new Material(1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( -100, 0, 149),new Point3D(  0, 100, 149),new Point3D( -100, 100, 149),new Color(0,0,255),new Material(1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D( 100, 0, 149),new Point3D(  0, 100, 149),new Point3D( 100, 100, 149),new Color(255,0,0),new Material(1,1,1,1,1)));
		
		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.writeToImage();
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
		
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 225),new Color(255,0,0),new Material (0.8,1,13, 1, 0)));
		
     	//geometries.addGeometry(new Triangle(new Point3D(150,75,150),new Point3D(-150,75,150),new Point3D(0,-150,150),new Color(0,0,255),new Material(0.5,1,1,1,1)));
			
		//geometries.addGeometry(new Triangle(new Point3D(150,-75,150),new Point3D(-150,-75,150),new Point3D(0,150,150),new Color(0,0,255),new Material(1,1,1,1,1)));
		
		//next//
		
       /* geometries.addGeometry(new Triangle(new Point3D(-100,-150,150),new Point3D(-150,-75,150),new Point3D(0,-150,150),new Color(255,0,0),new Material(0.5,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,-150,150),new Point3D(150,-75,150),new Point3D(0,-150,150),new Color(255,0,0),new Material(1,1,1,1,1)));
	
		geometries.addGeometry(new Triangle(new Point3D(-200,0,150),new Point3D(-150,-75,150),new Point3D(-150, 75, 150),new Color(255,0,0),new Material(0.5,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(200,0,150),new Point3D(150,-75,150),new Point3D(150,75,150),new Color(255,0,0),new Material(1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100,150,150),new Point3D(-150,75,150),new Point3D(0, 150, 150),new Color(255,0,0),new Material(0.5,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,150,150),new Point3D(150,75,150),new Point3D(0,150,150),new Color(255,0,0),new Material(1,1,1,1,1)));
		
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(-50,-75,150),new Point3D(-150,-75,150),new Point3D(0,-150,150),new Color(0,255,0),new Material(0.5,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(50,-75,150),new Point3D(150 ,-75,150),new Point3D(0,-150,150),new Color(0,255,0),new Material(1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-100,0,150),new Point3D(-150,-75,150),new Point3D(-150,75,150),new Color(0,255,0),new Material(0.5,1,1,1,1)));
				
		geometries.addGeometry(new Triangle(new Point3D(100,0,150),new Point3D(150,-75,150),new Point3D(150,75,150),new Color(0,255,0),new Material(1,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(-50,75,150),new Point3D(-150,75,150),new Point3D(0,150,150),new Color(0,255,0),new Material(0.5,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(50,75,150),new Point3D(150,75,150),new Point3D(0,150,150),new Color(0,255,0),new Material(1,1,1,1,1)));
		*/
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(100,50,150),new Point3D(-100,50,150),new Point3D(0,-100,150),new Color(0,0,125),new Material(1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(100,-50,150),new Point3D(-100,-50,150),new Point3D(0,100,150),new Color(0,0,255),new Material(0.5,1,1,1,1)));
		
		//next//
		
		geometries.addGeometry(new Triangle(new Point3D(-250,200,150),new Point3D(250,200,150),new Point3D(-250,125,150),new Color(0,0,255),new Material(0.5,1,1,1,1)));
			
		geometries.addGeometry(new Triangle(new Point3D(-250,125,150),new Point3D(250,200,150),new Point3D(250,125,150),new Color(0,0,255),new Material(1,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-250,-200,150),new Point3D(250,-125,150),new Point3D(-250,-125,150),new Color(0,0,255),new Material(0.5,1,1,1,1)));
		
		geometries.addGeometry(new Triangle(new Point3D(-250,-200,150),new Point3D(250,-200,150),new Point3D(250,-125,150),new Color(0,0,255),new Material(1,1,1,1,1)));
		
		ImageWriter imageWriter = new ImageWriter("direction", 500, 500, 500, 500);
     	Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.writeToImage();
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
		geometries.addGeometry(new Sphere(8, new Point3D(0, 0, -10), new Color(255, 90, 0), new Material(0.9, 1,20,0,0)));
		ImageWriter imageWriter = new ImageWriter("point", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		//render.printGrid(50);
		render.writeToImage();
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
		geometries.addGeometry(new Sphere(50, new Point3D(0, 0, 150), new Color(0, 0, 0), new Material(0.8, 0.7,12,0,0)));
		Vector Dir = new Point3D(0, 0, 150).subtract(new Point3D(60, 60, 60));
		scene.get_lights().add(new SpotLight(new Point3D(35, -15, 1), 1, 0.7, 0.4, new Color(150, 0, 0),
				Dir.subtract(new Vector(10, 0, 0))));

		ImageWriter imageWriter = new ImageWriter("spot", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
	
		render.renderImage();
		//render.printGrid(50);
	    render.writeToImage();
	}
	@Test
	public void recursiveTest() {

		Scene scene = new Scene("recursive1");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, -1)));
		scene.set_screenDistance(300);
		scene.set_background(new Color(0, 0, 0));
		scene.set_ambientLight(new AmbientLight(new Color(0,0,0),0));

		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100),
				new Material(0.5, 0.3, 10, 0, 0.5));

		scene.addGeometry(sphere);
		Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000), new Color(100, 20, 20),
				new Material(0.4, 0.4, 10, 0.5, 0));
		scene.addGeometry(sphere2);
		
		List<LightSource> lights = new ArrayList<LightSource>();
		lights.add(new SpotLight(new Point3D(-200, -200, -150), 0.1, 0.01, 0.0025, new Color(255, 100, 100),
				new Vector(2, 2, -3)));
		scene.set_lights(lights);
		
		ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();
		;

	}

	@Test
	public void recursiveTest2() {

		Scene scene = new Scene("recursive2");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, -1)));
		scene.set_screenDistance(300);
		scene.set_background(new Color(0, 0, 0));
		scene.set_ambientLight(new AmbientLight(new Color(0,0,0),1));

		Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000), new Color(0, 0, 100),
				new Material(0.4, 0.6, 10, 0, 0.5));
		scene.addGeometry(sphere);

		Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000), new Color(100, 20, 20),
				new Material(0.3, 0.4, 10, 0.5, 0));
		scene.addGeometry(sphere2);

		Triangle triangle = new Triangle(new Point3D(1500, -1500, -1500), new Point3D(-1500, 1500, -1500),
				new Point3D(200, 200, -375), new Color(20, 20, 20), new Material(0.4, 0.6, 10, 1, 0));

		Triangle triangle2 = new Triangle(new Point3D(1500, -1500, -1500), new Point3D(-1500, 1500, -1500),
				new Point3D(-1500, -1500, -1500), new Color(20, 20, 20), new Material(0.4, 0.6, 10, 0.5, 0));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		List<LightSource> lights = new ArrayList<LightSource>();
		lights.add(new SpotLight(new Point3D(200, 200, -150), 0, 0.0001, 0.005, new Color(255, 100, 100),
				new Vector(-2, -2, -3)));
		scene.set_lights(lights);

		ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}

	@Test
	public void recursiveTest3() {

		Scene scene = new Scene("recursive3");
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.set_screenDistance(300);
		scene.set_background(new Color(0, 0, 0));
		scene.set_ambientLight(new AmbientLight(new Color(0,0,0),0));
		
		Sphere sphere = new Sphere(300, new Point3D(0, 0, 1500), new Color(0, 0, 100), new Material(0.5, 0.3, 10, 0, 0.5));
		scene.addGeometry(sphere);

		Sphere sphere2 = new Sphere(150, new Point3D(0, 0, 1500), new Color(100, 20, 20), new Material(0.4, 0.6, 10, 0.5, 0));
		scene.addGeometry(sphere2);

		Triangle triangle = new Triangle(new Point3D(2000, -1000, 2000), new Point3D(-1000, 2000, 2000),
				new Point3D(700, 700, 875), new Color(20, 20, 20), new Material(0.5, 0.3, 10, 1, 0));

		Triangle triangle2 = new Triangle(new Point3D(2000, -1000, 2000), new Point3D(-1000, 2000, 2000),
				new Point3D(-1000, -1000, 2000), new Color(20, 20, 20), new Material(0.55, 0.25, 10, 0.5, 0));

		scene.addGeometry(triangle);
		
		scene.addGeometry(triangle2);

		List<LightSource> lights = new ArrayList<LightSource>();
		lights.add(new SpotLight(new Point3D(200, 200, -650), 0, 0.0001, 0.005, new Color(255, 100, 100),
				new Vector(-2, -2, 3)));
		scene.set_lights(lights);

		ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}
	@Test
	  public void shadowTest() {
	    Scene scene = new Scene("Test shadow");
	    scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
	    scene.set_screenDistance(100);
	    scene.set_background(new Color(0,0,0));
	    Geometries geometries = new Geometries();
	    Sphere sphere = new Sphere( 60,new Point3D(0, 0, 80), new Color(241, 6, 151),new Material(0.2,0.8,200,0,0));
	    Triangle triangle1 = new Triangle(new Point3D(-250,-250,120),new Point3D(-250,250,120),new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9, 0.8, 100,0,0));
	    Triangle triangle2 = new Triangle(new Point3D(250,250,120),new Point3D(-250,250,120),new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9, 0.8, 100,0,0));
	    geometries.addGeometry(sphere);
	    geometries.addGeometry(triangle1);
	    geometries.addGeometry(triangle2);
	    scene.set_geometries(geometries);
	    List<LightSource> lights = new ArrayList<LightSource>();
	    lights.add(new SpotLight( new Point3D(25,0,0),1, 12,0, new Color(100,100,100),new Vector(-25,0,80)));
	    scene.set_lights(lights);
	    ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
	    Render testRender = new Render(imageWriter, scene);
	    
	    testRender.renderImage();
	    testRender.writeToImage();
	    
	  }

}