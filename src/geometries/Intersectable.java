package geometries;

import java.util.List;
import java.util.Map;

import primitives.Point3D;
import primitives.Ray;

public interface Intersectable {
	Map<Geometry,List<Point3D>> findintersection(Ray ray);
}
