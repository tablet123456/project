package scene;
import geometries.*;
import primitives.*;
import elements.*;
/**
 * present a scene by having name, camera, color for the background, an ambientLight,
 * our geometries and the distance between the camera and the view plane
 * @author Tzvi Bloom and Daniel schwalb
 * 
 */
public class Scene {
  String _sceneName;
  private Color _background;
  private AmbientLight _ambientLight;
  private Geometries _geometries;
  private LightSource _lights;
  private Camera _camera;
  private double _screenDistance;
  
  /***************** Constructors **********************/ 
 
  public Scene(String sceneName) {
			_sceneName = sceneName;
			_camera =  new Camera(new Point3D(0.0 ,0.0 ,0.0), new Vector (0.0, 1.0, 0.0), new Vector (0.0, 0.0, -1.0));
			_screenDistance = 1;
			_geometries = new Geometries();
			_lights= new LightSource();
		}
	
 
  /***************** Getters/Setters **********************/
  
  public String get_sceneName() {
		return _sceneName;
	}

	public Color get_background() {
		return _background;
	}
	public AmbientLight get_ambientLight() {
		return _ambientLight;
	}
	
	public Geometries get_geometries() {
		return _geometries;
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
	
	public void set_background(Color color) {
		this._background = color;
	}
	
	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}
	
	public void set_geometries(Geometries geometries) {
		this._geometries = geometries;
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
    
  public void addGeometry(Geometry geometry) {
	  _geometries.addGeometry(geometry);
  }
 
  

  
 
  
  
}
