package elements;
import primitives. *;
public class Camera {
	Point3D _p0;
	Vector _vUp;
	Vector _vTo;
	Vector _vRight;
	
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
	public Ray constructRayThroughPixel(int Nx, int Ny, int i, int j, double screenDistance,double screenwidth,double screenHeight) {
		
		Vector dvTo=new Vector(this._vTo.scale(screenDistance));
		
		Point3D Pc =new Point3D(_p0.add(dvTo));
		
		double Rx=screenwidth/Nx;
		double Ry=screenHeight/Ny;
		
		double Xi=(i-(Nx-1)/2.0)*Rx;
		double Yi=(j-(Ny-1)/2.0)*Ry;
		Point3D pij=new Point3D (Pc.add((_vRight.scale(Xi)).add(_vUp.scale(-Yi))));
		Vector vij=new Vector(pij.subtract(_p0)).normalize();
		return new Ray( pij,vij);
		}
		
	
	
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
	@Override
	public String toString() {
		return "Camera [_p0=" + _p0 + ", _vUp=" + _vUp + ", _vTo=" + _vTo + ", _vRight=" + _vRight + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
