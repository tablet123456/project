package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * 
 * @author tzvibloom
 *
 */

public class SpotLight extends PointLight {
	
	Vector _direction;
	
	/******************* Constructors ************************/
	
	public SpotLight(Point3D position, double Kc, double Kl, double Kq, Color color, Vector direction) {
		super(position, Kc, Kl, Kq, color);
		_direction  = direction;
	}
	
	/***************** Getters/Setters **********************/
	
	public Vector get_direction() {
		return _direction;
	}
	
	/***************** Administration  ********************/
	
	
	
	/******************* Operations **********************/
	
	public Vector getD(Point3D point) {
		return _direction;
	}
	@Override
	public Color getIntensity(Point3D point) {
		double numerator = _direction.dotProduct(getL(point));
		double distance = _position.distance(point);
		double denominator = (_Kc < 1 ? _Kc = 1 : _Kc) + _Kl * distance + _Kq * distance * distance;
		return new Color(getIntensity().scale(numerator).reduce(denominator));
	}
	/************** Helpers ***************/
}
