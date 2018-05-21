package geometries;

/**
 * 
 * @author tzvibloom
 *
 */

public abstract class RadialGeometry extends Geometry {
	private double _radius;
	public RadialGeometry() {

	}
	/********** Constructors ***********/

	public RadialGeometry(double radius) {
		super();
		this._radius = radius;
	}
	
	// Copy constructor
	public RadialGeometry(RadialGeometry radial) {
		this._radius = radial._radius;
	}
	/************** Getters/Setters *******/
    public double get_radius() {
    	return _radius;
    }

}
 
// ***************** Administration  ******************** //

// ***************** Operations ******************** // 

