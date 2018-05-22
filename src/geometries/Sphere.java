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
		super(radius);
		_center = new Point3D(center);
		_emission = new Color(emission);
		_material = new Material(material);
	}

	public Sphere(Sphere sphere) {
		super(sphere);
		_center = new Point3D(sphere._center);
		_emission = new Color(sphere._emission);
		_material = new Material(sphere._material);
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

	public Map<Geometry, List<Point3D>> findintersection(Ray ray) {
		findintersection = new HashMap<Geometry, List<Point3D>>();
		List<Point3D> intersection = new ArrayList<Point3D>();

		Vector u = get_center().vectorsubtract(ray.get_p0());
		Vector v = ray.get_direction();

		double tm = (u.dotProduct(v));
		double d = Math.sqrt(u.dotProduct(u) - tm * tm);

		if (!(d > get_radius())) {

			double th = Math.sqrt(get_radius() * get_radius() - d * d);
			double t1 = tm + th;

			if (t1 > 0)
				intersection.add(new Point3D(ray.get_p0().add(v.scale(t1))));

			double t2 = tm - th;
			if (t2 > 0)
				intersection.add(new Point3D(ray.get_p0().add(v.scale(t2))));
		}
		findintersection.put(this, intersection);
		return findintersection;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return (new Vector(point.vectorsubtract(this.get_center())).normalize());
	}

}
