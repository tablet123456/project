package geometries;

import java.util.ArrayList;
import primitives.*;

public class Cylinder extends RadialGeometry {
	private Ray _axisRay;
	/***************** Constructors **********************/ 
	
	public Cylinder(double _radius, Ray axis) {
		super(_radius);
		this._axisRay = new Ray(axis);
	}
	
	/***************** Getters/Setters **********************/
	
	public Ray getaxisRay() {
		return _axisRay;
	}
	/***************** Administration  ********************/

	
	@Override
	public String toString() {
		return "Cylinder [_axisRay=" + _axisRay + "]";
	}


	
	/***************** Operations ********************/ 
	
	
	public ArrayList<Point3D> findintersection(Ray ray) throws Exception{
		return null;
	}
	@Override
	public Vector getNormal(Point3D point) {
		Vector v =new Vector(point.subtract(_axisRay.get_p0()));
		double t=_axisRay.get_direction()._dotproduct(v);
		Point3D q= _axisRay.get_p0().add(_axisRay.get_direction().scale(t));
		Vector normal= new Vector(point.subtract(q));
		return normal.normalize();
	}

}
