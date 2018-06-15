package elements;

import primitives.*;

/**
 * 
 * @author tzvibloom
 *
 */


public class PointLight extends Light implements LightSource {
	protected Point3D _position;

	protected double _Kc;
	protected double _Kl;
	protected double _Kq;

	/****************** Constructors *************************/
	
	public PointLight(Point3D position, double kc, double kl, double kq, Color color) {
		super(color);
		_position = position;
		_Kc = kc;
		_Kl = kl;
		_Kq = kq;
		color=new Color(color);
	}

	/****************** Getters/Setters **********************/
	public double get_kc() {
		return _Kc;
	}
	
	public double get_kl() {
		return _Kl;
	}

	public double get_Kq() {
		return _Kq;
	}
	/****************** Administration  **********************/
	/******************* Operations **************************/
	
	public Point3D get_position() {
		return _position;
	}

	public Vector getD(Point3D point) {
		return getL(point);
	}

	public Vector getL(Point3D point) {
		Vector L = point.subtract(_position);
		return L;
	}

	@Override
	public Color getIntensity(Point3D point) {
		double distance = _position.distance(point);
		double denominator = (_Kc < 1 ? _Kc = 1 : _Kc) + _Kl * distance + _Kq * distance * distance;
		return new Color(getIntensity().reduce(denominator));
	}
	/********************* Helpers ***************************/

}
