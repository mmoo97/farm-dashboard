package farm.dashboard;

/***
 * Convenience class for storing constants needed for piping, conversion, and flight
 * 09/30/2019 v1.0
 * @author MasterControlProgram: Seth Lewis
 *
 */

public class Constants {
		
	public static final String FILE_PATH_DEVELOPER = "Tello3ToJava.py";
	public static final String PYTHON_PATH = "/usr/bin/python"; // your path to python executable (please use the explicit path)
	
	public static final int FARMWIDTH = 800; // farm width on screen in pixels 4:3 ratio
	public static final int FARMHEIGHT = 600; // farm height on screen in pixels 4:3 ratio
	public static final int FARMDEPTH = 0;
	
	public static final int MODELWIDTH = 32; // farm width physical model in feet 4:3 ratio
	public static final int MODELHEIGHT = 24; // farm height physical model in feet 4:3 ratio
	
	public static final int PIXELS_TO_ONE_MODEL_FOOT = 50; // on screen pixels to one real world foot
	public static final int CENTIMETERS_PER_MODEL_FOOT = 30; // centimeters to feet conversion for flight commands
	
}
