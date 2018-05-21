package elements;

import primitives.*;

public class DirectionalLight extends Light {

	public DirectionalLight() {
	
	}
	Vector _direction;

	@Override
	public Color getIntensity() {
		return null;
	}
	
	public Vector getL(Point3D point) {
		return getD(point);
	}

	public Vector getD(Point3D point) {	
		return _direction.normalize();
	}
}