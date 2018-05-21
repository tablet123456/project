package elements;

import primitives.*;
/**
 * 
 * @author tzvibloom
 *
 */

public class DirectionalLight extends Light {

	public DirectionalLight() {
	
	}
	Vector _direction;

	public Vector getL(Point3D point) {
		return getD(point);
	}

	public Vector getD(Point3D point) {	
		return _direction.normalize();
	}
	
	public Color getIntensity() {
		return null;
	}
}