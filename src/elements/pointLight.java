package elements;
import primitives.*;


public class pointLight extends Light {
	protected  Point3D _position;
	
	protected double _Kc=1;
	protected double _kl;
	protected double _Kq;
	
	
	public double get_kl() {
		return _kl;
	}

	public double get_Kq() {
			return _Kq;
	}

	public  Color getIntensity() {
		return null;
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

}
