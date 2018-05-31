package primitives;

/**
 * 
 * @author tzvibloom
 *
 */

public class Ray {
	private Point3D _p0;
	private Vector _direction;

	/***************** Constructors **********************/
	public Ray(Point3D point, Vector vector) {
		_p0 = new Point3D(point);
		_direction = vector.normalize();
	}

	public Ray(Ray ray) {
		_p0 = new Point3D(ray._p0);
		_direction = new Vector(ray._direction);
	}

	/***************** Getters/Setters **********************/

	public Point3D get_p0() {
		return _p0;
	}

	public Vector get_direction() {
		return _direction;
	}

	/***************** Administration ********************/

	@Override
	public String toString() {
		return "" + _p0 + "," + _direction;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		if (_p0 == null) {
			if (other._p0 != null)
				return false;
		} else if (!_p0.equals(other._p0))
			return false;
		return true;
	}
	/***************** Operations ********************/

}
