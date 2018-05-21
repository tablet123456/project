package geometries;
import java.util.*;

import primitives.*;
import primitives.Vector;

	public abstract class Geometry {
		Map<Geometry, List<Point3D>> findintersection = new HashMap<Geometry, List<Point3D>>();
		
		protected Color  _emmission;
		
		public Material _material;
		/********** Constructors ***********/
		
		// Default constructor
		public Geometry() {	
		}
		// Copy constructor
		public Geometry(Geometry geometry) {
			
		}
		
		public abstract Vector getNormal(Point3D point); 
		
		public abstract Map<Geometry,List<Point3D>> findintersection(Ray ray)  ;
		
		public Color get_emmission() {
			return _emmission;
		}
		
	}

