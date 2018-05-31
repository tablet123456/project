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

/****************** Constructors *************************/
/****************** Getters/Setters **********************/
/****************** Administration  **********************/
/******************* Operations **************************/
/********************* Helpers ***************************/

public class Sphere extends RadialGeometry {
	private Point3D _center;

	/********** Constructors ***********/

	public Sphere(double radius, Point3D center, Color emission, Material material) {
		super(radius, emission, material);
		_center = new Point3D(center);
		_emission = new Color(emission);
		_material = new Material(material);
	}

	/************** Getters/Setters *******/

	public Point3D get_center() {
		return _center;
	}

	/***************** Administration ********************/

	@Override
	public String toString() {
		return "" + _center;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Sphere))
			return false;
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}

	/***************** Operations ********************/

	@SuppressWarnings("unlikely-arg-type")
	public Map<Geometry, List<Point3D>> findintersection(Ray ray) {
		Map<Geometry, List<Point3D>> findintersection = new HashMap<Geometry, List<Point3D>>();
		List<Point3D> intersection = new ArrayList<Point3D>();
		findintersection.put(this, intersection);
		Point3D p0 = ray.get_p0();
		
		Vector v = ray.get_direction();
		Vector u = null;
		try {
			u = _center.subtract(p0);
		} catch (Exception e) {
			intersection.add(p0.add(v.scale(_radius)));
			return findintersection;
		}

		double tm = u.dotProduct(v);
		double d = Math.sqrt(u.dotProduct(u) - tm * tm);

		if (d > _radius)
			return findintersection;

		double th = Math.sqrt(_radius * _radius - d * d);
		if (Coordinate.ZERO.equals(th)) {
			intersection.add(p0.add(v.scale(tm)));
			return findintersection;
		}

		double t1 = tm + th;
		if (t1 > 0)
			intersection.add(p0.add(v.scale(t1)));

		double t2 = tm - th;
		if (t2 > 0)
			intersection.add(p0.add(v.scale(t2)));
		
		return findintersection;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return point.subtract(_center).normalize();
	}

}
