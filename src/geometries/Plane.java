package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.*;

/**
 * 
 * @author tzvibloom
 *
 */

public class Plane extends Geometry {
	private Point3D _p;
	private Vector _normal;

	/***************** Constructors **********************/
	public Plane(Point3D point, Vector normal, Color emission, Material material) {
		super(emission, material);
		_p = new Point3D(point);
		_normal = new Vector(normal).normalize();
	}

	public Plane(Point3D p1, Point3D p2, Point3D p3, Color emission, Material material) {
		super(emission, material);
		Vector v = p1.subtract(p2);
		Vector u = p1.subtract(p3);
		_normal = u.crossproduct(v).normalize();
		_p = new Point3D(p1);
	}

	/***************** Getters/Setters **********************/

	public Point3D get_p() {
		return _p;
	}

	/***************** Administration ********************/

	@Override
	public String toString() {
		return "Plane [_p=" + _p + ", _normal=" + _normal + "]";
	}

	/***************** Operations ********************/
	@SuppressWarnings("unlikely-arg-type")
	public Map<Geometry, List<Point3D>> findintersection(Ray ray) {
		Map<Geometry, List<Point3D>> findintersection = new HashMap<Geometry, List<Point3D>>();
		List<Point3D> intersection = new ArrayList<Point3D>();
		findintersection.put(this, intersection);
		double denominator = (_normal.dotProduct(ray.get_direction()));
		if (Coordinate.ZERO.equals(denominator))
			return findintersection;
		double t = (_normal.dotProduct(_p.subtract(ray.get_p0()))) / denominator;
		if (t > 0)
			intersection.add(new Point3D(ray.get_p0().add(ray.get_direction().scale(t))));
		return findintersection;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return _normal;
	}

}
