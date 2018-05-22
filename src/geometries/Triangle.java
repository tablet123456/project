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

public class Triangle extends Plane {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;

	/***************** Constructors **********************/
	public Triangle(Point3D point1, Point3D point2, Point3D point3,Color emission,Material material) {
		super(point1, point2, point3,emission,material);
		_p1 = new Point3D(point1);
		_p2 = new Point3D(point2);
		_p3 = new Point3D(point3);
		_emission = new Color(emission);
		_material = new Material(material);
	}

	public Triangle(Triangle triangle) {
		super(triangle);
		_p1 = new Point3D(triangle._p1);
		_p2 = new Point3D( triangle._p2);
		_p3 = new Point3D( triangle._p3);
		_emission = new Color (triangle._emission);
		_material = new Material(triangle._material);
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
		findintersection = new HashMap<Geometry, List<Point3D>>();
		List<Point3D> intersection = new ArrayList<Point3D>();
		Point3D p0=ray.get_p0();
		findintersection = super.findintersection(ray);
		if (findintersection.isEmpty()) {
			return findintersection;
		} 
		else {
			findintersection.forEach((k,v) ->
			{k=this;
				intersection.addAll(v);
			});
			Vector v1 = (this._p1.vectorsubtract(p0));
			Vector v2 = (this._p2.vectorsubtract(p0));
			Vector v3 = (this._p3.vectorsubtract(p0));
			Vector N1 = (v1.crossProduct(v2)).normalize();
			Vector N2 = (v2.crossProduct(v3)).normalize();
			Vector N3 = (v3.crossProduct(v1)).normalize();
			Point3D p = new Point3D(findintersection.get(this).get(0));
			Vector pp0 = new Vector(p.vectorsubtract(p0));
			double q1 = (pp0._dotproduct(N1));
			double q2 = (pp0._dotproduct(N2));
			double q3 = (pp0._dotproduct(N3));
			if (!((q1 > 0 && q2 > 0 && q3 > 0) || (q1 < 0 && q2 < 0 && q3 < 0))) {
				intersection.clear();
				findintersection.put(this, intersection);
				
			}
		}
		return findintersection;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return super.getNormal(point);
	}

}
