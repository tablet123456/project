package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class spotLight extends pointLight {
	
	public  Color getIntensity() {
		return null;
	}
	
	public Vector getL(Point3D point) {
		Vector L = new Vector (point.vectorsubtract(_position));
		return L.normalize();
	}
	public Vector getD(Point3D point) {
		
		return null;
		
	}
	
	}


