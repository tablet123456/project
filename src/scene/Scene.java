package scene;
import geometries.*;
import primitives.*;
import java.awt.Color;
import java.util.ArrayList;
import elements.*;

public class Scene {
  String _sceneName;
  private Color _background;
  private ArrayList<Geometry> _geometries;
  private Camera _camera;
  private double _screenDistance;
  
  /***************** Constructors **********************/ 
 
  public Scene() {
	  set_sceneName("painting");
	  set_background(Color.MAGENTA);
	  _geometries=new ArrayList<Geometry>();
	  set_camera(new Camera(new Point3D(0.0,0.0,0.0),new Vector(0.0,0.0,1.0),new Vector(0.0,1.0,0.0))); 
	  set_screenDistance(1.0);
  }
  
  public Scene(String sceneName, Color background,ArrayList<Geometry> objects, Camera camera, double screenDistance) {
		
		this.set_sceneName(sceneName);
		this.set_background(background);
		this._geometries = new ArrayList<>();
		for(Geometry geo:objects) {
			this._geometries.add(geo);
		}
		this.set_camera(camera);
		this.set_screenDistance(screenDistance);
	}
 
  /***************** Getters/Setters **********************/
  
  public String get_sceneName() {
		return _sceneName;
	}
  
	public Color get_background() {
		return _background;
	}
	
	public Camera get_camera() {
		return _camera;
	}
	
	public double get_screenDistance() {
		return _screenDistance;
	}
	
	public void set_sceneName(String _sceneName) {
		this._sceneName = _sceneName;
	}
	
	public void set_background(Color _background) {
		this._background = _background;
	}

	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}
	
	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}   
		// ***************** Administration  ******************** //

	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _background=" + _background + ", _geometries=" + _geometries
				+ ", _camera=" + _camera + ", _screenDistance=" + _screenDistance + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Scene))
			return false;
		Scene other = (Scene) obj;
		if (_background == null) {
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null) {
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}
	
		// ***************** Operations ******************** // 
    
  public void addGeometry() {
	  
  }


  
 
  
  
}
