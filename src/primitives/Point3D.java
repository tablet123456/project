package primitives;

/**
 * Class for 3D points  in out 3D graphics model
 *
 */

	public class Point3D extends Point2D {
	private Coordinate _z;
	
	/**
	 * @param x - Coordinate value for x
	 * @param y
	 * @param z
	 */
	/***************** Constructors **********************/ 
	
	public Point3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}

	public Point3D(Point3D other) {
		super(other);
		_z = new Coordinate(other._z);
	}
	
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x,y);
		_z=new Coordinate(z);
	}
	/***************** Getters/Setters **********************/
	
	public Coordinate getZ() {
		return _z;
	}
	
	/***************** Administration  ********************/
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point3D))
			return false;
		Point3D other = (Point3D)obj;
		return super.equals(other) && _z.equals(other._z);
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + "," + _z + ")";
	}
	/***************** Operations ********************/ 
	public Vector vectorsubtract(Point3D point) {
		Coordinate x = new Coordinate(this.getX().subtract(point.getX()));
		Coordinate y = new Coordinate(this.getY().subtract(point.getY()));
		Coordinate z = new Coordinate(this.getZ().subtract(point.getZ()));
		return new Vector(x,y,z);
	}
	public Point3D add(Vector v) {
		Coordinate x = new Coordinate(this.getX().add(v.getHead().getX()));
		Coordinate y = new Coordinate(this.getY().add(v.getHead().getY()));
		Coordinate z = new Coordinate(this.getZ().add(v.getHead().getZ()));
		return new Point3D(x,y,z);
	}
	public Point3D subtract(Point3D point) {
		Coordinate x = new Coordinate(this.getX().subtract(point.getX()));
		Coordinate y = new Coordinate(this.getY().subtract(point.getY()));
		Coordinate z = new Coordinate(this.getZ().subtract(point.getZ()));
		return new Point3D(x,y,z);
	
	}
	public double distance(Point3D point) {
		double x = Math.pow(this.getX().subtract(point.getX()).get(),2);
		double y = Math.pow(this.getY().subtract(point.getY()).get(),2);
		double z = Math.pow(this.getZ().subtract(point.getZ()).get(),2);
		double w = Math.sqrt(x+y+z);
		return w;
			
	}
	

}
