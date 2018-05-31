package elements;
import primitives.Color;

public class AmbientLight extends Light {
	
	private double _Ka;
	private Color _intensity;
	
	/********** Constructors ***********/	
	
	
	public AmbientLight(Color color, double ka) {
		super(color);
		_Ka =  ka;
		_intensity = new Color(_color).scale(_Ka);
	}

	/************** Getters/Setters *******/
	

	public double getKa() {
		return _Ka;
	}

	public void setKa(double ka) {
		_Ka = ka;
	}
	// return final Ambient light after multiply by Ka
	public Color getIntensity()
	{
		return new Color (_intensity);
	}
}
