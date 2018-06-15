package geometries;

import primitives.*;
import primitives.Vector;

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

public abstract class Geometry implements Intersectable {
			
	protected Color  _emission;
		
	public Material _material;
	/******************* Constructors ************************/
		
	// Default constructor
	public Geometry(Color emission, Material material) {	
		_material = new Material(material);
		_emission = new Color(emission);
	}

	/***************** Getters/Setters **********************/
	public Color get_emission() {
		return _emission;
	}
	
	public Material get_material() {
		return _material;
	}
		
	public abstract Vector getNormal(Point3D point); 

}

