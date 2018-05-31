package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.Point3D;
import primitives.Ray;

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

public class Geometries implements Intersectable {

	private List<Intersectable> geometries = new ArrayList<Intersectable>();

	public void addGeometry(Intersectable geometry) {
		geometries.add(geometry);
	}

	public void removeGeometry(Intersectable geometry) {
		geometries.remove(geometry);
	}

	@Override
	public Map<Geometry, List<Point3D>> findintersection(Ray ray) {
		Map<Geometry, List<Point3D>> findintersection = new HashMap<Geometry, List<Point3D>>();
		for (Intersectable geometry : geometries) {
			Map<Geometry, List<Point3D>> map = geometry.findintersection(ray);
			List<Point3D> intersections = map.get(geometry);
			if (intersections != null) {
				if (!intersections.isEmpty()) {
					findintersection.putAll(map);
				}
			}
		}
		return findintersection;
	}

}
