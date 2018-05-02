package geometries;

import java.util.ArrayList;

import primitives.*;


public class Plane extends Geometry {
	private Point3D _p;
	private Vector _normal;
	/***************** Constructors **********************/ 
	public Plane(Point3D p, Vector v) {
		_p = new Point3D(p);
		_normal= new Vector(v);
	}
	public Plane(Plane p) {
		_p = new Point3D(p.get_p());
		_normal = new Vector(p.getNormal(_p));
	}
	public Plane(Point3D p1, Point3D p2, Point3D p3) {
		Vector u = new Vector(p2.vectorsubtract(p1));
		Vector v = new Vector(p3.vectorsubtract(p1));
		Vector w = u._crossproduct(v);
		_p = new Point3D(w.getHead());
		_normal = w.normalize();
	}
	/***************** Getters/Setters **********************/
	
	public Point3D get_p() {
		return _p;
	}

	
	/***************** Administration  ********************/

	@Override
	public String toString() {
		return "Plane [_p=" + _p + ", _normal=" + _normal + "]";
	}
	/***************** Operations ********************/
	public ArrayList<Point3D> findintersection(Ray ray) throws Exception{
		ArrayList<Point3D> intersection=new ArrayList<Point3D>();
		ray=new Ray(ray.get_p0(),ray.get_direction()._normalize());
		double t=(this._normal.dotProduct(this._p.vectorsubtract(ray.get_p0())))/(this._normal.dotProduct(ray.get_direction()));
		if(t>=0) {
			intersection.add(new Point3D(ray.get_p0().add(ray.get_direction().scale(t))));
		    return intersection;
		}
		else
			throw new Exception("no intersections with the plane");
	}
	@Override
	public Vector getNormal(Point3D point) {
		return _normal;
	}
	
}
	  
	
	   
	

	

