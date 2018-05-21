package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * 
 * @author tzvibloom
 *
 */
/****************** Constructors *************************/
/****************** Getters/Setters **********************/
/****************** Administration  **********************/
/******************* Operations **************************/
/********************* Helpers ***************************/

public class Geometries extends Geometry {
	
	private List<Geometry> geometries = new ArrayList<Geometry>();
	
	public void addGeometry(Geometry geometry) {
		geometries.add(geometry);
	}
	
	public void removeGeometry(Geometry geometry) {
		geometries.remove(geometry);
	}
	

	@Override
	public Vector getNormal(Point3D point) {
		return null;
	}

	@Override
	public Map<Geometry, List<Point3D>> findintersection(Ray ray)  {
		Map<Geometry, List<Point3D>> findintersection = new HashMap<Geometry, List<Point3D>>();
			List<Point3D> intersection = new ArrayList<Point3D>();
			List<Point3D> intersections = new ArrayList<Point3D>();
			Map<Geometry, List<Point3D>> map = new HashMap<Geometry, List<Point3D>>();
			for (Geometry geometry : geometries) {
				map = geometry.findintersection(ray);
				intersections = map.get(geometry);
				if (intersections != null) {
					if (!intersections.isEmpty()){
						intersection.addAll(intersections);
						findintersection.put(geometry, intersections);
						}
					}
				}
			return findintersection;
			}	
	
	}
