package elements;

import primitives.Color;

/**
 * 
 * @author tzvibloom
 *
 */

public abstract class Light {
	Color _color;
	
	
	
	public Color get_color() {
		return _color;
	}

	public abstract Color getIntensity();

	
}
	
	

