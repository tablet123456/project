package primitives;

public class Color {
	float red;
	float green;
	float blue;
	/***************** Constructors **********************/
	public Color(float red ,float green ,float blue) {
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		
	}

	/***************** Getters/Setters **********************/
	
	public double getRed() {
		return red;
	}

	public double getGreen() {
		return green;
	}

	public double getBlue() {
		return blue;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}
	
	/***************** Administration  ********************/
	
	
	@Override
	public String toString() {
		return "Color [ red=" + red + ", green=" + green + ", blue=" + blue + "]";
	}

	/***************** Operations ********************/ 
	
	public Color add(Color _color) {
		return _color;
	}

	public Color scale(double color ) {
		return null;
	}
	
	public Color reduce(double color ) {
		return null;
	}


}









	

