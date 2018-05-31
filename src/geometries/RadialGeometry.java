package geometries;

import primitives.Color;
import primitives.Material;

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

public abstract class RadialGeometry extends Geometry {
	protected double _radius;
	public RadialGeometry(Color em, Material mat) {
		super(em, mat);
	}
	/********** Constructors ***********/

	public RadialGeometry(double radius, Color em, Material mat) {
		super(em, mat);
		this._radius = radius;
	}
	
	/************** Getters/Setters *******/
    public double get_radius() {
    	return _radius;
    }

}
 


