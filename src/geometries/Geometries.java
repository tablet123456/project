package geometries;

import java.util.ArrayList;

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
	public ArrayList<Point3D> findintersection(Ray ray) throws Exception {
			findintersection = new ArrayList<Point3D>();
			ArrayList<Point3D> intersections = new ArrayList<Point3D>();
			for(Geometry geometry: geometries){
				intersections = geometry.findintersection(ray);
				for(Point3D point: intersections)
					findintersection.add(point);
			}
			return findintersection;
		
	}

	
}
