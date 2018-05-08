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
	public void printGrid(int grid){
		for(int i = 0; i < _imageWriter.getWidth()-1;i++){
			for(int j = 0; j < _imageWriter.getHeight()-1;j++){
				if (((i+1)%grid == 0) || (((j+1)%grid) == 0))
					_imageWriter.writePixel(i, j, 255,255,255);
			}
		}
		
	}
	
	
	public void renderImage(){
		for(int j = 0; j < _imageWriter.getNy(); j++){
			for(int i = 0; i < _imageWriter.getNx(); i++){
				Ray ray = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy() , i, j,_scene.get_screenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				ArrayList<Point3D> intersectionsPoints = new ArrayList<Point3D>(_scene.get_geometries().findintersection(ray));
				if(intersectionsPoints.size() == 0)
					_imageWriter.writePixel(i, j, _scene.get_background().getColor());
				else{
					Point3D closestPoint = getClosestPoint(intersectionsPoints);
					//_imageWriter.writePixel(i, j, calcColor(closestPoint).getColor());
					_imageWriter.writePixel(i, j, 255,255,255);
				}
			}
		}
	}
	
	private Color calcColor(Point3D point) {
		return _scene.get_ambientLight().getIntensity();
		
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
	

