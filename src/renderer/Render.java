package renderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import geometries.Geometry;
import primitives.*;
import scene.Scene;

public class Render {
	Scene _scene;
	ImageWriter _imageWriter;
	
	public Render(ImageWriter image, Scene scene) {
		_imageWriter = image;
		_scene = scene;
	}
	
	public Scene get_scene() {
		return _scene;
	}
	
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}
	
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}

	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
	}
	public void printGrid(int grid){
		for(int i = 0; i < _imageWriter.getNx()-1;i++){
			for(int j = 0; j < _imageWriter.getNy()-1;j++){
				if (((i+1)%grid == 0) || (((j+1)%grid) == 0))
					_imageWriter.writePixel(i, j, 255,255,255);
			}
		}
		_imageWriter.writeToimage();
	}
	
	/**
	 * write to image
	 */
	public void printImage() {
		_imageWriter.writeToimage();
	}

	public void renderImage()   {
		for (int i = 0; i < _imageWriter.getNx(); i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				Ray ray = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j,_scene.get_screenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				
				Map<Geometry, List<Point3D>> intersectionsPoints = new HashMap<Geometry, List<Point3D>>(_scene.get_geometries().findintersection(ray));
				
				if (intersectionsPoints.size() == 0)
					_imageWriter.writePixel(i, j, _scene.get_background().getColor());
				else {
					//System.out.println(intersectionsPoints);
					Point3D closestPoint = getClosestPoint(intersectionsPoints);
					// System.out.println(closestPoint);
					// System.out.println("(" + i + "," + j + ")");
					// System.exit(0);
					_imageWriter.writePixel(i, j, calcColor(closestPoint).getColor());
					// _imageWriter.writePixel(i, j, 255,255,255);
				}
			}
			
		}
	}
	
	
	private Color calcColor(Geometry geometry ,Point3D point) {
		Color color =_scene.get_ambientLight().getIntensity();
		color = color.add(geometry.getEmission());
		return color;
	}
	private Point3D getClosestPoint(Map<Geometry, List<Point3D>> intersectionsPoints) {
		double distance =Double.MAX_VALUE;
		Point3D p0=_scene.get_camera().get_p0();
		Point3D minDistancePoint = null;
		
		for(Point3D ipoint: intersectionsPoints) {
			if(p0.distance(ipoint)<distance) {
				minDistancePoint = new Point3D(ipoint);
				distance=p0.distance(ipoint);
			}
		}
		return minDistancePoint;
	}
	
	
	
}
	

