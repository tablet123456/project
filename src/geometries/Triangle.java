package geometries;

import java.util.ArrayList;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
public class Triangle extends Plane {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	// ***************** Constructors ********************** 
	public Triangle(Point3D point1, Point3D point2, Point3D point3) {
		super(point1, point2, point3);
		this._p1 =new Point3D(point1);
		this._p2 =new Point3D(point2);
		this._p3 =new Point3D(point3);
	}

	public Triangle(Triangle triangle) {
		super(triangle.get_p1(),triangle.get_p2(),triangle.get_p3());
		this._p1 =triangle.get_p1();
		this._p2 =triangle.get_p2();
		this._p3 =triangle.get_p3();
	}

	public Point3D get_p1() {
		return _p1;
	}

	public Point3D get_p2() {
		return _p2;
	}

	public Point3D get_p3() {
		return _p3;
	}

	/***************** Administration  ********************/


	@Override
	public String toString() {
		return " " + _p1 + " "+_p2  + " " + _p3;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof Triangle))
			return false;
		if(this==obj)
			return true;
		Triangle other = new Triangle((Triangle)obj);
		return this._p1.equals(other._p1) && this._p2.equals(other._p2) && this._p3.equals(other._p3);
	}
	/***************** Operations ********************/ 
	public ArrayList<Point3D> findintersection(Ray ray) throws Exception {
		ArrayList<Point3D>intersection= new ArrayList<Point3D>();
		intersection=super.findintersection(ray);
		if(intersection==null) {
			throw new Exception("no intersections with plane");
		}
		Vector v1=(this._p1.vecsubtract(ray.get_p0()));
		Vector v2=(this._p2.vecsubtract(ray.get_p0()));
		Vector v3=(this._p3.vecsubtract(ray.get_p0()));
		Vector N1=((v1._crossproduct(v2)).normalize());
		Vector N2=((v2._crossproduct(v3)).normalize());
		Vector N3=((v3._crossproduct(v1)).normalize());
		Point3D p=new Point3D(intersection.get(0));
		double q1=((p.vecsubtract(ray.get_p0()))._dotproduct(N1));
		double q2=((p.vecsubtract(ray.get_p0()))._dotproduct(N2));
		double q3=((p.vecsubtract(ray.get_p0()))._dotproduct(N3));
		if((q1>0&&q2>0&&q3>0)||(q1<0&&q2<0&&q3<0))
			return intersection;
		else
			return intersection;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return super.get_normal();
	}

}
