package elements;
import primitives.Color;

public class AmbientLight {
	private Color _color;
	private double _Ka;
	private Color _intensity;
	
	/********** Constructors ***********/	
	
	
	public AmbientLight(Color color, double ka) {
		_color = new Color (color);
		_Ka =  ka;
		_intensity = new Color(_color).scale(_Ka);
	}

	/************** Getters/Setters *******/
	public Color get_color() {
		return _color;
	}

	public void set_color(Color _color) {
		this._color = _color;
	}

	public double getKa() {
		return _Ka;
	}

	public void setKa(double ka) {
		_Ka = ka;
	}
	// return final Ambient light after multiply by Ka 
	public Color getIntensity()
	{
		return _intensity;
	}
}
