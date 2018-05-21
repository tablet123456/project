package elements;

import java.util.ArrayList;
import java.util.List;

import geometries.*;
import primitives.*;


public  class LightSource  {
	
	private List<LightSource> lights = new ArrayList<LightSource>();
	
	public Color getIntesity(Point3D point) {
		return null;
	}
	
	public Vector getD(Point3D point) {
		return null;
	}
	public Vector getL(Point3D point) {
			Vector L = new Vector (point.vectorsubtract(_position));
			return L.normalize();
	}
	
	
	
	
	
	
	
}


