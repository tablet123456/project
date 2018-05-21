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

public class PointLight extends Light {
	protected  Point3D _position;
	
	protected double _Kc=1;
	protected double _Kl;
	protected double _Kq;
	
	
	public PointLight(Point3D position, double kc, double kl, double kq, Color color) {
		super(color);
		_position=new Point3D(position);
		_Kc=kc;
		_Kl=kl;
		_Kq=kq;
	}

	public double get_kl() {
		return _Kl;
	}

	public double get_Kq() {
			return _Kq;
	}
	
	public Point3D get_position() {
		return _position;
	}

	public Vector getD(Point3D point) {
		return getL(point);
	}
	
	public Vector getL(Point3D point) {
		Vector L = new Vector (point.vectorsubtract(_position)).normalize();
		return L;
	}
	
	public  Color getIntensity(Point3D point) {
		double distance =_position.distance(point);
		double denominator =(_Kc < 1 ? _Kc = 1 : _Kc) + _Kl * distance + _Kq * distance * distance;
		return new Color(getIntensity().reduce(denominator));
	}	
	
}
