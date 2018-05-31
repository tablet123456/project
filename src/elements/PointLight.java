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
		_position = new Point3D(position);
		_Kc = kc;
		_Kl = kl;
		_Kq = kq;
	}

	/****************** Getters/Setters **********************/
	
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
		Vector L = new Vector(point.subtract(_position)).normalize();
		return L;
	}

	@Override
	public Color getIntesity(Point3D point) {
		double distance = _position.distance(point);
		double denominator = (_Kc < 1 ? _Kc = 1 : _Kc) + _Kl * distance + _Kq * distance * distance;
		return new Color(getIntensity().reduce(denominator));
	}
	/********************* Helpers ***************************/

}
