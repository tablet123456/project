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

		// ***************** Operations ******************** // 
    
  
  
 
  
  
}
