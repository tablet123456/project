package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class spotLight extends pointLight {
	
	Vector _direction;
	
	public  Color getIntensity() {
		return null;
	}
	

	public Vector get_direction() {
		return _direction;
	}
	
	public Vector getL(Point3D point) {
		Vector L = new Vector (point.vectorsubtract(_position)).normalize();
		return L;
	}
	public Vector getD(Point3D point) {
		Vector dir = new Vector(_direction).normalize();
		return dir;
	}
}


