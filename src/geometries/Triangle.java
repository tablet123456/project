package geometries;

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

public class Triangle extends Plane {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;

	/***************** Constructors **********************/
	public Triangle(Point3D point1, Point3D point2, Point3D point3, Color emission, Material material) {
		super(point1, point2, point3, emission, material);
		_p1 = new Point3D(point1);
		_p2 = new Point3D(point2);
		_p3 = new Point3D(point3);
	}

	/***************** Getters/Setters **********************/
	public Point3D get_p1() {
		return _p1;
	}

	public Point3D get_p2() {
		return _p2;
	}

	public Point3D get_p3() {
		return _p3;
	}

	/***************** Administration ********************/

	@Override
	public String toString() {
		return " " + _p1 + " " + _p2 + " " + _p3;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Triangle))
			return false;
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	}

	/***************** Operations ********************/
	@Override
	public Map<Geometry, List<Point3D>> findintersection(Ray ray) {
		Map<Geometry, List<Point3D>> findintersection = super.findintersection(ray);
		List<Point3D> intersection = findintersection.entrySet().iterator().next().getValue();
		Point3D p0 = ray.get_p0();
		if (findintersection.isEmpty() || intersection == null || intersection.isEmpty())
			return findintersection;
		Vector v1 = this._p1.subtract(p0);
		Vector v2 = this._p2.subtract(p0);
		Vector v3 = this._p3.subtract(p0);
		Vector N1 = v1.crossProduct(v2);
		Vector N2 = v2.crossProduct(v3);
		Vector N3 = v3.crossProduct(v1);
		Point3D p = intersection.get(0);
		Vector pp0 = new Vector(p.subtract(p0));
		double q1 = pp0._dotproduct(N1);
		double q2 = pp0._dotproduct(N2);
		double q3 = pp0._dotproduct(N3);
		if (!((q1 > 0 && q2 > 0 && q3 > 0) || (q1 < 0 && q2 < 0 && q3 < 0)))
			intersection.clear();
		return findintersection;
	}

}
