package geometries;
import java.util.List;

import primitives.*;

	public abstract class Geometry {
		

		
		/********** Constructors ***********/
		
		// Default constructor
		public Geometry() {	
		}
		// Copy constructor
		public Geometry(Geometry geometry) {
			
		}
		public abstract Vector getNormal(Point3D point); 
		public abstract List<Point3D> findintersection(Ray ray) throws Exception ;
		
	}

