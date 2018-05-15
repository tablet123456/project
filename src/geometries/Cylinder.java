package geometries;


import java.util.List;
import java.util.Map;

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
	
	
	public Map<Geometry, List<Point3D>> findintersection(Ray ray) {
		return null;
	}
	@Override
	public Vector getNormal(Point3D point) {
		Vector v =new Vector(point.vectorsubtract(_axisRay.get_p0()));
		double t=_axisRay.get_direction()._dotproduct(v);
		Point3D q= _axisRay.get_p0().add(_axisRay.get_direction().scale(t));
		Vector normal= new Vector(point.vectorsubtract(q));
		return normal.normalize();
	}

}
