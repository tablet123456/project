package renderer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import elements.LightSource;
import geometries.Geometry;
import primitives.*;
import scene.Scene;

/**
 * the render checks if there is an intersection with each pixel. if there is no
 * intersection the pixel is coloured black. the render also builds a grid
 * 
 * @author tzvi bloom & daniel schwalb
 *
 */

public class Render {

	private static class GeoPoint {
		public Geometry geometry;
		public Point3D point;
	}

	Scene _scene;
	ImageWriter _imageWriter;

	/****************** Constructors *************************/

	public Render(ImageWriter image, Scene scene) {
		_imageWriter = image;
		_scene = scene;
	}

	/****************** Getters/Setters **********************/

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

	/****************** Administration **********************/
	/******************* Operations **************************/

	public void printGrid(int grid) {
		for (int i = 0; i < _imageWriter.getNx() - 1; i++) {
			for (int j = 0; j < _imageWriter.getNy() - 1; j++) {
				if (((i + 1) % grid == 0) || (((j + 1) % grid) == 0))
					_imageWriter.writePixel(i, j, 255, 255, 255);
			}
		}
		_imageWriter.writeToimage();
	}

	/**
	 * write to image
	 */
	public void writeToImage() {
		_imageWriter.writeToimage();
	}

	public void renderImage() {
		for (int i = 0; i < _imageWriter.getNx(); i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				Ray ray = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j,
						_scene.get_screenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				Map<Geometry, List<Point3D>> intersectionsPoints = new HashMap<Geometry, List<Point3D>>(
						_scene.get_geometries().findintersection(ray));
				GeoPoint closestPoint = getClosestPoint(intersectionsPoints);
				if (intersectionsPoints.values().isEmpty() || intersectionsPoints == null || closestPoint == null)
					_imageWriter.writePixel(i, j, _scene.get_background().getColor());
				else 
					_imageWriter.writePixel(i, j, calcColor(closestPoint, ray).getColor()); // calcColor(closestPpoint)	
			}
		}

	}
	
	private Color calcColor(GeoPoint geopoint, Ray inRay) {
		return calcColor(geopoint, inRay, 3, 1.0);
	}

	private Color calcColor(GeoPoint geopoint, Ray inRay, int level, double k) {
		// isZero
		if (level == 0 || Coordinate.isZero(k))
			return new Color(0, 0, 0);
		Color color = new Color(_scene.get_ambientLight().getIntensity());
		color = new Color(color.add(geopoint.geometry.get_emission()));
		Vector v = inRay.get_direction();

		Vector n = geopoint.geometry.getNormal(geopoint.point);
		int nShininess = geopoint.geometry._material.getnShininess();
		double kd = geopoint.geometry._material.get_Kd();
		double ks = geopoint.geometry._material.get_Ks();
		//double kg = geopoint.geometry._material.get_Kg();

		for (LightSource lightSource : _scene.get_lights()) {
			Vector l = lightSource.getL(geopoint.point).normalize();
			if (n.dotProduct(l) * n.dotProduct(v) > 0) {
				double o = occluded(l, geopoint);
				if (!Coordinate.isZero(o * k)) {
					Color lightIntensity = new Color(lightSource.getIntensity(geopoint.point)).scale(o);
					color.add(calcDiffusive(kd, l, n, lightIntensity),
							calcSpecular(ks, l, n, v, nShininess, lightIntensity));
							
				}
			}
		}

		// Recursive call for a reflected ray
		Color reflectedLight = null;
		Ray reflectedRay = constructReflectedRay(n, geopoint, inRay);
		GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
		if (reflectedPoint.geometry == null) 
			 reflectedLight = new Color(0,0,0);		
		else {
			double kr = geopoint.geometry._material.get_Kr();
			reflectedLight = calcColor(reflectedPoint, reflectedRay, level - 1, k * kr).scale(kr);
		}
		// Recursive call for a refracted ray
		Color refractedLight =null ;
		Ray refractedRay = constructRefractedRay(geopoint, inRay);
		GeoPoint refractedPoint = findClosestIntersection(refractedRay);
		if (refractedPoint.geometry == null) 
			refractedLight =new Color(0,0,0);
		else {
			double kt = geopoint.geometry._material.get_Kt();
			refractedLight = calcColor(refractedPoint, refractedRay, level - 1, k * kt).scale(kt);	
		}	
		
		return new Color(color.add(reflectedLight, refractedLight));
	}

	private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		Vector r = l.add(n.scale(-2 * (l.dotProduct(n)))).normalize();

		if (v.dotProduct(r) > 0)
			return new Color(0, 0, 0);
		return new Color(lightIntensity).scale(ks * Math.pow(Math.abs(r.dotProduct(v)), nShininess));

	}
	/*private Color calcGlossy(double kg, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		Vector r = (l.add(n.scale(-2 * (l.dotProduct(n)))).normalize()).scale(-1);

		if (v.dotProduct(r) > 0)
			return new Color(0, 0, 0);
		return new Color(lightIntensity).scale(kg * Math.pow(Math.abs(r.dotProduct(v)), nShininess));

	}*/
	
	private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
		return new Color(lightIntensity).scale(kd * Math.abs(l.dotProduct(n)));
	}

	
	private GeoPoint findClosestIntersection(Ray refractedRay) {
		Map<Geometry, List<Point3D>> intersections = new HashMap<Geometry, List<Point3D>>(
				_scene.get_geometries().findintersection(refractedRay));
		GeoPoint closestIntersection = getClosestPoint(intersections);
		return closestIntersection;
	}

	private Ray constructRefractedRay(GeoPoint geoPoint, Ray inRay) {
		Vector normal = geoPoint.geometry.getNormal(geoPoint.point);
		Vector epsVector = normal.scale(normal.dotProduct(inRay.get_direction()) > 0 ? 2 : -2);
		Point3D point = geoPoint.point.add(epsVector);
		return new Ray(point, inRay.get_direction());
	}

	private Ray constructReflectedRay(Vector n, GeoPoint geoPoint, Ray inRay) {
		Vector normal = geoPoint.geometry.getNormal(geoPoint.point);
		Vector v = inRay.get_direction();
		Vector reflected = v.subtract(n.scale(2 * (v.dotProduct(n))));
		Vector epsVector = normal.scale(normal.dotProduct(inRay.get_direction()) > 0 ? 2 : -2);
		//Point3D point = geoPoint.point.add(epsVector);
		return new Ray(geoPoint.point, reflected);
	}

	private double occluded(Vector l, GeoPoint geopoint) {
		Vector lightDirection = l.scale(-1); // from point to light source
		Vector normal = geopoint.geometry.getNormal(geopoint.point);
		Vector epsVector = normal.scale((normal.dotProduct(lightDirection) > 0) ? 2 : -2);
		Point3D geometryPoint = geopoint.point.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, List<Point3D>> intersectionPoints = _scene.get_geometries().findintersection(lightRay);
		double shadowK = 1;
		/*if(intersectionPoints.entrySet()==null)
			shadowK = 0;*/
		for (Map.Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
			shadowK *= entry.getKey()._material.get_Kt();
		return shadowK;
	}
	

	private GeoPoint getClosestPoint(Map<Geometry, List<Point3D>> points) {
		double Distance = Double.MAX_VALUE;
		GeoPoint closestPoint = new GeoPoint();
		Point3D p0 = _scene.get_camera().get_p0();
		for (Map.Entry<Geometry, List<Point3D>> entry : points.entrySet()) {
			for (Point3D p : entry.getValue()) {
				if (p0.distanceSqrt(p)< Distance) {
					Distance = p0.distanceSqrt(p);
					closestPoint.point = p;
					closestPoint.geometry = entry.getKey();
				}
			}
		}

		return closestPoint;
	}


}

/********************* Helpers ***************************/
