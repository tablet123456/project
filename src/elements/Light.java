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
		_color= color;
	}
	
	/****************** Getters/Setters **********************/

	public Color get_color() {
		return _color;
	}
	public void set_color(Color color) {
		_color = color;
	}

	/****************** Administration  **********************/
	/******************* Operations **************************/

	public Color getIntensity() {
		return new Color(_color);
	}
	/********************* Helpers ***************************/
	
}
	
	

