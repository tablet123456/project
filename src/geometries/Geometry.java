package geometries;
import java.util.ArrayList;
import primitives.*;

	public abstract class Geometry {
		
		ArrayList<Point3D> findintersection;
		
		/********** Constructors ***********/
		
		// Default constructor
		public Geometry() {	
		}
		// Copy constructor
		public Geometry(Geometry geometry) {
			
		}
		public abstract Vector getNormal(Point3D point); 
		public abstract ArrayList<Point3D> findintersection(Ray ray) throws Exception ;
		
	}

