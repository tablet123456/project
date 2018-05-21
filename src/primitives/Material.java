package primitives;

/**
 * 
 * @author tzvibloom
 *
 */

public class Material {
	
	double _Kd;
	double _Ks;
	int nShininess;
	
	public double get_Kd() {
		return _Kd;
	}
	
	public double get_Ks() {
		return _Ks;
	}
	
	public int getnShininess() {
		return nShininess;
	}
	
	public void set_Kd(double _Kd) {
		this._Kd = _Kd;
	}
	
	public void set_Ks(double _Ks) {
		this._Ks = _Ks;
	}
	
	public void setnShininess(int nShininess) {
		this.nShininess = nShininess;
	}
	
}
