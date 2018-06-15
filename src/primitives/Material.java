package primitives;

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

public class Material {
	
	double _Kd;
	double _Ks;
	int nShininess;
	double _Kr;
	double _Kt;
	double _Kg;
	
	
	public Material(double kd,double ks,double kr,double kt,double kg ,int nshininess) {
		_Kd = kd;
		_Ks = ks;
		_Kr = kr;
		_Kt = kt;
		_Kg = kg;
		nShininess =nshininess;
	}
	
	public Material(Material material) {
		_Kd = material._Kd;
		_Ks = material._Ks;
		_Kr = material._Kr;
		_Kt = material._Kt; 
		_Kg = material._Kg;
		nShininess = material.nShininess;
	}
	
	public double get_Kd() {
		return _Kd;
	}
	
	public double get_Ks() {
		return _Ks;
	}
	
	public double get_Kr() {
		return _Kr;
	}
	
	public double get_Kt() {
		return _Kt;
	}
	public double get_Kg() {
		return _Kg;
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
	public void set_Kt(double _Kt) {
		this._Kt = _Kt;
	}
	
	public void set_Kr(double _Kr) {
		this._Kr = _Kr;
	}
	
	public void set_Kg(double _Kg) {
		this._Kg = _Kg;
	}
	
	public void setnShininess(int nShininess) {
		this.nShininess = nShininess;
	}
	
}
