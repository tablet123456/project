package elements;
import primitives. *;
public class Camera {
	private Point3D _p0;
	Vector _vUp;
	Vector _vTo;
	Vector _vRight;
	/***************** Constructors **********************/ 
	
	public Camera(Point3D p0,Vector vUp,Vector vTo) {
		this._p0=new Point3D (p0);
		this._vUp=(new Vector(vUp)._normalize());
		this._vTo=(new Vector(vTo)._normalize());
		double x=vTo.dotProduct(vUp);
		if(x!=0) {
			_vRight=null;
		} 
		else
		_vRight=(_vTo._crossproduct(_vUp)).normalize();
		
		
		}
	
	
	/***************** Getters/Setters **********************/
	
	public Point3D get_p0() {
		return _p0;
	}
	public Vector get_vUp() {
		return _vUp;
	}
	public Vector get_vTo() {
		return _vTo;
	}
	public Vector get_vRight() {
		return _vRight;
	}
	
	/***************** Administration  ********************/
	
	@Override
	public String toString() {
		return "Camera [_p0=" + _p0 + ", _vUp=" + _vUp + ", _vTo=" + _vTo + ", _vRight=" + _vRight + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Camera))
			return false;
		Camera other = (Camera) obj;
		if (_p0 == null) {
			if (other._p0 != null)
				return false;
		} else if (!_p0.equals(other._p0))
			return false;
		if (_vRight == null) {
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vTo == null) {
			if (other._vTo != null)
				return false;
		} else if (!_vTo.equals(other._vTo))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}


	/***************** Operations ********************/ 
	
	public Ray constructRayThroughPixel(int Nx, int Ny, int i, int j, double screenDistance,double screenwidth,double screenHeight) {
		
		Vector dvTo=new Vector(this._vTo.scale(screenDistance));
		
		Point3D Pc =new Point3D(_p0.add(dvTo));
		
		double Rx=screenwidth/Nx;
		double Ry=screenHeight/Ny;
		
		double Xi=(i-(Nx-1)/2.0)*Rx;
		double Yi=(j-(Ny-1)/2.0)*Ry;
		Point3D pij=new Point3D (Pc.add((_vRight.scale(Xi)).subtract(_vUp.scale(Yi))));
		Vector vij=new Vector(pij.vectorsubtract(_p0).normalize());
		return new Ray( _p0,vij);
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
