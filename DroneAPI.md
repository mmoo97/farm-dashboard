##Drone API Overview##

*This is a summary of the drone API that we will be implementing and how it works.*
  


**Step 1:** Before doing anything else, please clone this repo: <https://gitlab.cis.uab.edu/jesusaur/CS420_Drone_Files>

We will only need to change the `Constants Class` to operate the drone.

**Step 2:** Connect to drone's SSID via WiFi and run the  `Tello3ToJava.py` from the cloned repo.  Try the command sequence `command` and `end`, and if successful try `command`, `takeoff`, `land`, and `end`.  Please review Tello drone instructions as needed:
 
<https://dl-cdn.ryzerobotics.com/downloads/Tello/Tello%20SDK%202.0%20User%20Guide.pdf>

<https://dl-cdn.ryzerobotics.com/downloads/tello/20180910/Tello%20SDK%20Documentation%20EN_1.3.pdf>

**Step 3:** Retreive path from `Tello3ToJava.py` and enter as string variable `FILE_PATH_DEVELOPER` in `TelloJavaToPython.java`.  Repeat this process for your Python installation location and enter this for the variable `PYTHON_PATH`.

*Example:* 

String FILE_PATH_DEVELOPER =“/Users/username/desktop/Tello3ToJava.py” 

String PYTHON_PATH = "/usr/local/bin/python3"


**Step 4:** Open `TelloJavaToPython.java` and run.  


