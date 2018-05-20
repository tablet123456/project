package elements;

import primitives.Color;

public class pointLight extends Light {
	
	protected double _Kc;
	protected double _kl;
	protected double _Kq;
	
	public double get_Kc() {
		return _Kc;
	}

	public double get_kl() {
		return _kl;
	}

	public double get_Kq() {
			return _Kq;
	}


	public  Color getIntensity() {
		return null;
	}	

}
