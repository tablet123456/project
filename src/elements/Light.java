package elements;

import primitives.*;

/**
 * 
 * @author tzvibloom
 *
 */

public abstract class Light {
		
	protected Color _color;
	
	public Light(Color color) {
		_color=new Color(color);
	}
	
	
	public Color get_color() {
		return _color;
	}

	public void set_color(Color _color) {
		this._color = _color;
	}


	public Color getIntensity() {
		return new Color(_color);
	}

	
}
	
	

