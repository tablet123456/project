package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.*;


public class Plane extends Geometry {
	private Point3D _p;
	private Vector _normal;
	/***************** Constructors **********************/ 
	public Plane(Point3D p, Vector v,Color emmission) {
		_p = new Point3D(p);
		_normal= new Vector(v);
		_emmission= new Color(emmission);
	}
	public Plane(Plane plane ) {
		super(plane);
		_p = new Point3D(plane._p);
		_normal = new Vector(plane.getNormal(_p));
		_emmission= new Color (plane._emmission);
	}
	public Plane(Point3D p1, Point3D p2, Point3D p3 , Color emmission) {
		Vector u = new Vector(p2.vectorsubtract(p1));
		Vector v = new Vector(p3.vectorsubtract(p1));
		Vector w =new Vector( u._crossproduct(v).normalize());
		_p = new Point3D(w.getHead());
		_normal = new Vector(w.normalize());
		_emmission= new Color (emmission);
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
	public Map<Geometry, List<Point3D>> findintersection(Ray ray) {
		findintersection = new HashMap<Geometry, List<Point3D>>();
		List<Point3D> intersection=new ArrayList<Point3D>();
		double t=(_normal.dotProduct(_p.vectorsubtract(ray.get_p0())))/Math.abs(_normal.dotProduct(ray.get_direction()));
		if(!(t>=0)) {
			intersection.clear();
			findintersection.put(this, intersection);
			return findintersection;
			
		}
		else {
			
			intersection.add(new Point3D(ray.get_p0().add(ray.get_direction().scale(t))));
			findintersection.put(this, intersection);
			return findintersection;
		}
			
	}
	
	@Override
	public Vector getNormal(Point3D point) {
		return _normal;
	}
	
	
}
	  
	
	   
	

	

