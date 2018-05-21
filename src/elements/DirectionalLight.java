package elements;

import primitives.*;
/**
 * 
 * @author tzvibloom
 *
 */
/****************** Constructors *************************/
/****************** Getters/Setters **********************/
/****************** Administration  **********************/
/******************* Operations **************************/
/********************* Helpers ***************************/
public class DirectionalLight extends Light {
	
	Vector _direction;
	
	public DirectionalLight(Vector direction, Color color) {
		super(color);
		_direction =new Vector (direction);
		
	}
	
	public Vector getL(Point3D point) {
		return getD(point);
	}

	public Vector getD(Point3D point) {	
		return _direction.normalize();
	}
	
	public Color getIntensity() {
		return getIntensity();
	}
}