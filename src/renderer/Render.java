package renderer;
import java.util.List;
import elements.*;
import geometries.*;
import primitives.*;
import scene.Scene;


public class Render {
	Scene _scene;
	ImageWriter _imageWriter;
	
	
	public Scene get_scene() {
		return _scene;
	}
	
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}
	
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}

	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
	}
	
	private Color calcColor(Point3D point) {
		_color.setColor(_scene.get_ambientLight().getIntensity());
		return _color;
	}

	private Point3D getClosestPoint(List<Point3D> intersectionPoints) {
		double distance =Double.MAX_VALUE;
		Point3D p0=_scene.get_camera().get_p0();
		Point3D minDistancePoint = null;
		for(Point3D ipoint: intersectionPoints) {
			if(p0.distance(ipoint)<distance) {
				minDistancePoint = new Point3D(ipoint);
				distance=p0.distance(ipoint);
			}
		}
		return minDistancePoint;
	}
	
	
	
}
	

