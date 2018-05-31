package elements;

import primitives.*;

/**
 * 
 * @author tzvibloom
 *
 */

public abstract class Light {
		
	protected Color _color;
	
	/****************** Constructors *************************/
	
	public Light(Color color) {
		_color=new Color(color);
	}
	
	/****************** Getters/Setters **********************/

	public Color get_color() {
		return _color;
	}

	/****************** Administration  **********************/
	/******************* Operations **************************/

	public Color getIntensity() {
		return new Color(_color);
	}
	/********************* Helpers ***************************/
	
}
	
	

