package geometries;

import java.util.ArrayList;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {
	private Point3D _center;
	
	/********** Constructors ***********/

	public Sphere(double radius, Point3D middle) {
		super(radius);
		this._center= new Point3D(middle);
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
	
	public ArrayList<Point3D> findintersection(Ray ray) {
		ArrayList<Point3D> intersection=new ArrayList<Point3D>();
		
		Vector u=new Vector(this.getmiddle().subtract(ray.get_p0()));
		
		ray=new Ray(ray.get_p0(),(ray.get_direction()._normalize()));
		
		double tm =(u.dotProduct(ray.get_direction()));
		double d=Math.sqrt(Math.pow(u._length(), 2)-(Math.pow(tm, 2)));
		
		if (d>=this.get()) 
			return intersection;
			
		double th=Math.sqrt(Math.pow(this.get(), 2)-(Math.pow(d, 2)));
		double t1 =tm+th;
		
		if(t1>=0)
			intersection.add(new Point3D(ray.get_p0().add(ray.get_direction().scale(t1))));

		double t2 =tm-th;
		if(t2>=0)
			intersection.add(new Point3D(ray.get_p0().add(ray.get_direction().scale(t2))));
		
		return intersection;
			
	}

	@Override
	public Vector getNormal(Point3D point) {
		if(point.distance(this.getmiddle())== this.get())
			return (new Vector(point.subtract(this.getmiddle())).normalize());
		else
			return null;
	}
	
}
