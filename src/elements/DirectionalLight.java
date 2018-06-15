package elements;

import primitives.*;
/**
 * 
 * @author tzvibloom
 *
 */

public class DirectionalLight extends Light implements LightSource{
	
	private Vector _direction;
	/****************** Constructors *************************/
	
	public DirectionalLight(Vector direction, Color color) {
		super(color);
		_direction = direction;
		
	}
	/****************** Getters/Setters **********************/
	
	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}
	/****************** Administration  **********************/
	/******************* Operations **************************/
	
	public Vector getL(Point3D point) {
		return getD(point);
	}

	public Vector getD(Point3D point) {	
		return _direction;
	}
	
	@Override
	public Color getIntensity(Point3D point) {
		return getIntensity();
	}
}/********************* Helpers ***************************/