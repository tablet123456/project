package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Geometries extends Geometry {
	
	private ArrayList<Geometry> geometries = new ArrayList<Geometry>();
	
	public void addGeometry(Geometry geometry) {
		geometries.add(geometry);
	}
	
	public void removeGeometry(Geometries geometry) {
		geometries.remove(geometry);
	}
	

	@Override
	public Vector getNormal(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Geometry, List<Point3D>> findintersection(Ray ray)  {
		Map<Geometry, List<Point3D>> findintersection = new HashMap<Geometry, List<Point3D>>();
			List<Point3D> intersection = new ArrayList<Point3D>();
			if (findintersection.isEmpty()) {
				findintersection.put(this, intersection);
				return findintersection;
			}
		else {
				findintersection.forEach((k,v)->{
				List<Point3D> l = new ArrayList<Point3D>();
				l = findintersection.get(k);
				intersection.addAll(l);
				findintersection.put(this, intersection);
			});
		}
			
			/**for(Geometry geometry: geometries){
				intersections = geometry.findintersection(ray);
				for(Point3D point: intersections)
					findintersection.add(point);
			}**/
			return findintersection;
		
	}

	
	
}
