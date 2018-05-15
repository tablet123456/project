package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {
	private Point3D _center;
	
	/********** Constructors ***********/

	public Sphere(double radius, Point3D center) {
		super(radius);
		this._center= new Point3D(center);
	}

	public Sphere(RadialGeometry radius, Sphere sphere) {
		super(radius);
		this._center = sphere.getmiddle();
	}
	
	/************** Getters/Setters *******/	
	
	public Point3D getmiddle() {
		return _center;
	}
	/***************** Administration  ********************/

	@Override
	public String toString() {
		return  ""+ _center ;
	}
	/***************** Operations ********************/
	
	public Map<Geometry, List<Point3D>> findintersection(Ray ray)  {
		findintersection =new HashMap<Geometry, List<Point3D>>();
		List<Point3D> intersection=new ArrayList<Point3D>();
		
		Vector u = getmiddle().vectorsubtract(ray.get_p0());
		Vector v = ray.get_direction();
		
		double tm =(u.dotProduct(v));
		double d=Math.sqrt(u.dotProduct(u)-tm*tm);
		
		if (d > get()) {
			intersection.clear();
			findintersection.put(this, intersection);
			return findintersection;
		}
		else {
			
		
		double th=Math.sqrt(get()*get()-d*d);
		double t1 =tm+th;
		
		if(t1>0)
			intersection.add(new Point3D(ray.get_p0().add(v.scale(t1))));

		double t2 =tm-th;
		if(t2>0)
			intersection.add(new Point3D(ray.get_p0().add(v.scale(t2))));
		
		findintersection.put(this, intersection);
		return findintersection;
		}	
	}

	@Override
	public Vector getNormal(Point3D point) {
		if(point.distance(this.getmiddle())== this.get())
			return (new Vector(point.vectorsubtract(this.getmiddle())).normalize());
		else
			return null;
	}
	
}
