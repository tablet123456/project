package primitives;

/**
 * 
 * @author tzvibloom
 *
 */

public class Vector {
	private Point3D _head;
	/***************** Constructors **********************/ 
	
	public Vector(Coordinate x, Coordinate y, Coordinate z) {
		_head=new Point3D(x,y,z);
	}
	public Vector(double x,double y,double z) {
		_head=new Point3D(x,y,z);
	}
	public Vector(Point3D other) {
		_head = new Point3D(other);
	}
	public Vector(Vector other) {
		_head = other._head;
	}
	
	/***************** Getters/Setters **********************/
	
	public Point3D getHead() {
		return _head;
	}

	/***************** Administration  ********************/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vector))
			return false;
		Vector other = new Vector((Vector)(obj));
		return (this.getHead()==other.getHead());
	}
	
	@Override
	public String toString() {
		return "Vector [_head=" + _head + "]";
	}
	/***************** Operations ********************/ 
	
	public Vector add(Vector vector) {
		return new Vector(_add(vector));
	}
	
	public Vector subtract(Vector vector) {
		return new Vector(_subtract(vector));
	}
	
	public Vector scale(double scale) {
		return new Vector(_scale(scale));
	}
	
	public double dotProduct(Vector v) {
		return _dotproduct(v);
	}
	
	public Vector crossProduct(Vector v) {
		 return new Vector(_crossproduct(v));
	}
	
	public double length() {
		return _length();
	}
	
	public Vector normalize() {
		return new Vector(_normalize());
	}
	
	public Vector _add(Vector v) {
		Coordinate x = new Coordinate(getHead().getX().add(v.getHead().getX()));
		Coordinate y = new Coordinate(getHead().getY().add(v.getHead().getY()));
		Coordinate z = new Coordinate(getHead().getZ().add(v.getHead().getZ()));
		return new Vector(x,y,z);
	}
	public Vector _subtract(Vector v) {
	   Coordinate x = new Coordinate(getHead().getX().subtract(v.getHead().getX()));
	   Coordinate y = new Coordinate(getHead().getY().subtract(v.getHead().getY()));
	   Coordinate z = new Coordinate(getHead().getZ().subtract(v.getHead().getZ()));
	   return new Vector(x,y,z);
	}

	public Vector _scale(double _scale) {
		Coordinate x = getHead().getX().scale(_scale);
		Coordinate y = getHead().getY().scale(_scale);
		Coordinate z = getHead().getZ().scale(_scale);
		return new Vector(x,y,z);
		
	}
	public double _dotproduct(Vector v) {
		 Coordinate x = new Coordinate(getHead().getX().multiply(v.getHead().getX()));
		 Coordinate y = new Coordinate(getHead().getY().multiply(v.getHead().getY()));
		 Coordinate z = new Coordinate(getHead().getZ().multiply(v.getHead().getZ()));
		 return x.get()+y.get()+z.get();
	}
	
	public Vector _crossproduct(Vector v) {
		Coordinate x = (getHead().getY().multiply(v.getHead().getZ())).subtract(getHead().getZ().multiply(v.getHead().getY()));
		Coordinate y = (getHead().getZ().multiply(v.getHead().getX())).subtract(getHead().getX().multiply(v.getHead().getZ()));
		Coordinate z = (getHead().getX().multiply(v.getHead().getY())).subtract(getHead().getY().multiply(v.getHead().getX()));
		return new Vector(x,y,z);
	}
	
	public double _length() {
		double x= Math.pow(getHead().getX().get(), 2);
		double y= Math.pow(getHead().getY().get(), 2);
		double z= Math.pow(getHead().getZ().get(), 2);
		double w=x+y+z;
		return (Math.sqrt(w));
	}
	
	public Vector _normalize() {
		double length = this.length();
		double x = (getHead().getX().get())/length;
		double y = (getHead().getY().get())/length;
		double z = (getHead().getZ().get())/length;
		return new Vector(x, y, z);		
	}

	
	  
		
	
	
	
	
	
}
