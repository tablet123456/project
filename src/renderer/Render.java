package renderer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import geometries.Geometry;
import primitives.*;
import scene.Scene;
/**the render checks if there is an intersection with each pixel.
 * if there is no intersection the pixel is coloured black.
 * the render also builds a grid 
 * 
 * @author tzvibloom
 *
 */

/****************** Constructors *************************/
/****************** Getters/Setters **********************/
/****************** Administration  **********************/
/******************* Operations **************************/
/********************* Helpers ***************************/

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

	public void printGrid(int grid) {
		for (int i = 0; i < _imageWriter.getNx() - 1; i++) {
			for (int j = 0; j < _imageWriter.getNy() - 1; j++) {
				if (((i + 1) % grid == 0) || (((j + 1) % grid) == 0))
					_imageWriter.writePixel(i, j, 128, 128, 128);
			}
		}
		_imageWriter.writeToimage();
	}

	/**
	 * write to image
	 */
	public void writeToimage() {
		_imageWriter.writeToimage();
	}

	public void renderImage() {
		for (int i = 0; i < _imageWriter.getNx(); i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				Ray ray = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j,_scene.get_screenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());

				Map<Geometry, List<Point3D>> intersectionPoints; 
				intersectionPoints=new HashMap<Geometry, List<Point3D>>(_scene.get_geometries().findintersection(ray));
				Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);

				if (intersectionPoints.values().isEmpty() || intersectionPoints == null || closestPoint == null) 
					_imageWriter.writePixel(i, j, _scene.get_background().getColor());
				else {
					Geometry g = (Geometry) closestPoint.keySet().toArray()[0];
					Point3D p = (Point3D) closestPoint.values().toArray()[0];
					_imageWriter.writePixel(i, j, calcColor(g, p).getColor());

				}
				
			}
			
		}
	}

	private Color calcColor(Geometry geometry, Point3D point) {
		Color color = new Color(_scene.get_ambientLight().getIntensity());
		color = color.add(geometry.get_emmission());
		
		/**Vector n =geometry.getNormal(point);
		int nShininess=geometry._material.getnShininess();
		 double kd = geometry._material.get_Kd();
		 double ks = geometry._material.get_Ks();
		 
		
		for (LightSource lightSource : _scene.get_lights()) {
		 Color lightIntensity = lightSource.getIntesity(point);
		 Vector l = lightSource.getL(point);
		 Vector v = point.vectorsubtract(_scene.get_camera().get_p0());
		 color.add(calcDiffusive(kd, l, n, lightIntensity),
		 calcSpecular(ks, l, n, v, nShininess, lightIntensity));**/
	//	}
		 
		 
		 
		return color;
	}

	private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		// TODO Auto-generated method stub
		return null;
	}

	private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionsPoints) {
		double distance = Double.MAX_VALUE;
		Map<Geometry, Point3D> closestPoint = new HashMap<Geometry, Point3D>();
		Point3D p0 = _scene.get_camera().get_p0();
		Point3D minDistancePoint = null;
		if (closestPoint != null) {
			for (Entry<Geometry, List<Point3D>> intersect : intersectionsPoints.entrySet()) {
				Geometry geo = intersect.getKey();
				List<Point3D> points = intersect.getValue();
				for (Point3D iPoint : points) {
					if (p0.distance(iPoint) < distance) {
						minDistancePoint = new Point3D(iPoint);
						distance = p0.distance(iPoint);
						closestPoint.clear();
						closestPoint.put(geo, minDistancePoint);
					}
				}
			}
		}

		return closestPoint;
	}

}
