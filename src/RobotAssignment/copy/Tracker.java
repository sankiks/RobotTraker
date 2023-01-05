package RobotAssignment.copy;

import javax.swing.JOptionPane;

/**
 * Tracker class is the controller of the program. Start instances of classes MrRobot and Map
 * and controls the sequence of the program
 * @author johan
 *
 */
public class Tracker {

	private Map map;
	private MrRobot robot;

	/**
	 * Tracker constructor that starts the program based on the map and MrRobot inputed.
	 * 
	 * @param map Object setting the map to monitor.
	 * @param robot Object setting the robot from MrRobot class.
	 */
	public Tracker(Map map, MrRobot robot) {
		setMap(map);
		setRobot(robot);
		tracker();
	}

	/**
	 * Tacker constructor that takes only map as input.
	 * The robot properities are set to default then start the program.
	 * 
	 * @param map object representing the area to monitor.
	 */
	public Tracker(Map map) {
		setMap(map);
		setRobot(new MrRobot("default"));
		tracker();
	}
	
	/**
	 * Tracker construtor that starts the program based on the robot object properties but default map
	 * @param robot Object represent the robot to control and track
	 */

	public Tracker(MrRobot robot) {
		setMap(new Map());
		setRobot(robot);
		tracker();
	}

	
	/**
	 *  Tracker constructor. Start the whole program. initialises Map and MrRobot Objects based on user input and starts tracking the robot.
	 *  
	 */
	public Tracker() {
		TrackerInIt();

		tracker();
	}

	// maybe leave the initialisation of the MrRobot and Map be separate in own
	// classes?
	/**
	 * TrackerInit sets the map and robot based on user input.
	 *  
	 */
	private void TrackerInIt() {

		setMap(new Map());
		setRobot(new MrRobot(""));
		withinBond(robot);

	}

	/**
	 * After setting the Map and MrRobot parameters the program starts asking for user input for new movements or
	 * directions.
	 * programs runs until Robot is out of bound and can not be tracked anymore or invalidUserInput  exception 
	 * 	 
	 */
	private void tracker() {

		while (true) {

			String input = GetUserInput(3);

			String newPos = updateNewPos(input);
			JOptionPane.showMessageDialog(null, "New Posision: " + newPos);

		}
	}

	/**
	 * GetUserInput gets the user input through JoptionPane and throws exeption when invalid input is made 3 times.
	 * 
	 * @param index number of tries
	 * @return a string object reporting the new position.
	 */
	private String GetUserInput(int index) {
		if (index <= 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Retry error: \nTotal 3 times.");
				System.exit(0);
			}

		}
		String input = JOptionPane.showInputDialog(
				"valid input movement \n 1: Input 'f' for walking forward \n 2: Input r to rotate right \n 3: Input l to rotate left");
		// den ska ta emot user input
		input = input.toLowerCase();
		if (checkMovmentInput(input)) {
			return input;
		}
		index--;
		return GetUserInput(index);
	}

	/**
	 * Checks if the string input is a valid input and do not contain wrong input.
	 * @param the string input to be checked
	 * @return true if input is valid, false otherwise
	 */
	private boolean checkMovmentInput(String input) {
		// TODO Auto-generated method stub
		boolean validate = true;
		int index = 0;
		while (validate && input.length() > index) {
			if (input.charAt(index) == 'l') {
				index++;
			} else if (input.charAt(index) == 'r') {
				index++;
			} else if (input.charAt(index) == 'f') {
				index++;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid command" + input.charAt(index) + "at index: " + index);
				validate = false;
			}
		}
		return validate;
	}
	
	/**
	 * Update the new position and orientation of the robot.
	 * @param input contains the commands for the new position the robot shall move to
	 * @return the new position of the robot
	 * 
	 */

	private String updateNewPos(String input) {
		MrRobot tmpRobot = robot;
		String poString = "";
		int index = 0;

		while (input.length() > index) {
			poString = tmpRobot.act(input.charAt(index));
			index++;

			withinBond(tmpRobot);

		}
		
		setRobot(tmpRobot);
		return poString;
	}
	
	/**
	 * Checks if Robot is still within bonds of the map
	 * @param robot the robot object to be checked
	 */

	private void withinBond(MrRobot robot) {
		try {
			if (robot.getPosision().getXCord() >= map.getWidth() || robot.getPosision().getXCord() < 0
					|| robot.getPosision().getYCord() >= map.getDepth() || robot.getPosision().getYCord() < 0) {
				throw new Exception("Robot walked out of bounds. \nGood Luck next time");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Robot walked out of bounds. \nGood Luck next time");
			System.exit(0);
		}

	}

	
	/**
	 * Sets the Robot object
	 * @param robot MrRobot object.
	 */
	private void setRobot(MrRobot robot) {

		this.robot = robot;

	}

	/**
	 * Sets the map to be used be the tracker
	 * @param map Map Object to be used
	 */
	private void setMap(Map map) {

		this.map = map;
	}

}
