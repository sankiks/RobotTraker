package RobotAssignment.copy;

import javax.swing.JOptionPane;

/**
 * Class MrRobot is a class to define a robot object with a name position and orientation.
 * @author johan
 *
 */
public class MrRobot{
	private String mrRobotName;
	private Posision posisionStr;
	Orientation orientationStr;
	/**
	 *  MrRobot constructor sets MrRobot properties. Like name, position and orientation. 
	 * @param name sets the name of the Robot
	 * @param position sets the position of the robot
	 * @param orientation the orientation of the robot
	 */
	public MrRobot(String name, Posision position, Orientation orientation) {
		setMrRobotName(name);
		setPosision(position);
		setOrientation(orientation);
	}

	/**MrRobot constructor which take over a string parameter. The string 'default' sets the robot object name to
	 * MrRobot and sets the position and orientation to 0 0 North.
	 * 
	 * @param defaultStr string.equals("default") sets MrRobot object to default values. Anything else runs the setMrRobotName method and 
	 * initialise MrRobot object which will ask for user input instead.
	 */
	public MrRobot(String defaultStr) {

		if (defaultStr.matches("default")) {

			setMrRobotName("MrRobot");
			setPosision(new Posision(0, 0));
			setOrientation(Orientation.North);

		} else {
			setMrRobotName();
			initialiseRobot(3);

		}

	}
	
	/**
	 * SetOrientation method sets the orientation of the robot if valid. Otherwise throws an exception and program terminates.
	 * @param string contains the orientation. (only one char containing n, e, s or west)
	 * @throws Exception throws and exception if invalid orientation
	 */
	private void setOrientation(String string) throws Exception {
		if (!validateOrientation(string)) {
			throw new Exception(" Invalid direction");
		}

	}
	/**
	 * Validate if the received input is a string containing the orientation of the robot.
	 * it runs a switch case with the cases representing the 4 directions. N E S W.
	 * Method only checks the first char of the string and is not case sensitive. 
	 * Example validateOrientation("North") is the same as validateOrientation("n"). 
	 * @param string is the robot orientation.
	 * @return boolean value indicate if orientation is valid or not
	 */
	private boolean validateOrientation(String string) {
		boolean valid = false;
		string = string.toLowerCase();

		System.out.print("\nOrientation: " + string.charAt(0));

		switch (string.charAt(0)) {

		case 'n':
			setOrientation(Orientation.North);
			valid = true;
			break;
		case 'e':
			setOrientation(Orientation.East);
			valid = true;
			break;
		case 's':
			setOrientation(Orientation.South);
			valid = true;
			break;
		case 'w':
			setOrientation(Orientation.West);
			valid = true;
			break;
		}

		return valid;
	}

	
	/**
	 * The Method initialiseRobot(int retryAttempt); asks the user input to set the robot position and orientation on the map. 
	 * In case of invalid input method will run again until the retry attempts are 0 and program terminates after throwing exception.
	 * @param retryAttempt number of retry attempts to ask for user input before program terminates.
	 */
	private void initialiseRobot(int retryAttempt) {
		int yCord, xCord;
		if (retryAttempt <= 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Retry Error: \nSetting robot corrdinates wrong" + " "
						+ retryAttempt + " times.\nProgram terminates!");
			} finally {
				System.exit(0);
			}
		}
		String string = JOptionPane.showInputDialog("Please enter the robot posision and direction."
				+ "\nacceptable vales should be in the form '<xCord> <yCord> <direction>' where width and deepth are Integer values\nEntering 10 15 N give Robot posision in 10,15 facing north.\nValid direction values are 'N, E, S, W'");

		try {
			xCord = Integer.parseInt(string.split(" ")[0]);
			yCord = Integer.parseInt(string.split(" ")[1]);
			setOrientation(string.split(" ")[2]);
			setPosision(new Posision(xCord, yCord));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "unexpected char instead of integer value" + e.getMessage());
			retryAttempt--;
			initialiseRobot(retryAttempt);

		} // end of initialising map

	}

	/**
	 *  Sets the name of the robot. If null the default name MrRobot will be set.
	 */
	private void setMrRobotName() {
		String strName = JOptionPane.showInputDialog("Please type in Robot name");
		if (strName.equals(null) || strName.isBlank()) {
			setMrRobotName("MrRobot");
		} else {

			setMrRobotName(strName);
		}
	}
	
	/**
	 * act method order the robot to act (walk or rotate) depending on the input parameters.
	 * @param character contains the information the robot will act upon. 
	 * @return
	 */
	public String act(Character character) {

		switch (character) {

		case 'l':

			rotateleft();
			break;
		case 'r':

			rotateRight();
			break;
		case 'f':
			walkForward();
			break;
		}

		return posisionStr.toString()+" "+getOrientation().toString();
	}

	/**
	 * sets the name of MrRobot
	 * @param name of the robot
	 */
	private void setMrRobotName(String name) {
		mrRobotName = name;

	}
	/**
	 * sets the orientation of the robot
	 * @param Orientation pbject contains the direction the robot object will now be facing.
	 */
	public void setOrientation(Orientation Orientation) {

		orientationStr = Orientation;

	}

	/**
	 * sets the new posision of the robot
	 * @param posision object containing the new coordinates of the robot
	 */
	public void setPosision(Posision posision) {
		posisionStr = posision;

	}
	

	/**
	 * change the rotation of the robot to the right in respect to its  direction. 
	 */
	public void rotateRight() {
		switch (orientationStr) {
		case North:

			orientationStr = Orientation.East;
			break;
		case East:

			orientationStr = Orientation.South;
			break;
		case South:

			orientationStr = Orientation.West;
			break;
		case West:

			orientationStr = Orientation.North;
			break;
		}

	}

	/**
	 * change the rotation of the robot to the left in respect to its  direction. 
	 */
	public void rotateleft() {
		switch (orientationStr) {
		case North:

			orientationStr = Orientation.West;
			break;
		case East:

			orientationStr = Orientation.North;
			break;
		case South:

			orientationStr = Orientation.East;
			break;
		case West:

			orientationStr = Orientation.South;
			break;
		}
	}
 /**
  * WalkForward contains a switch case containing the orientation the robot faces and order walk in that direction.
  */
	public void walkForward() {
		switch (orientationStr) {
		case North:
			walkNorth();
			break;
		case East:

			walkEast();
			break;
		case South:

			walkSouth();
			break;
		case West:

			walkWest();
			break;
		}

	}

	/**
	 * tell the robot to walk in direction north
	 */
	private void walkNorth() {
		posisionStr.setYCord(posisionStr.getYCord() + 1);
	}

	/**
	 * tell the robot to walk in direction west
	 */
	private void walkWest() {
		posisionStr.setXCord(posisionStr.getXCord() - 1);
	}

	/**
	 * tell the robot to walk in direction east
	 */
	private void walkEast() {
		posisionStr.setXCord(posisionStr.getXCord() + 1);

	}

	
	/**
	 * Tells the robot to walk in direction south
	 */
	private void walkSouth() {
		posisionStr.setYCord(posisionStr.getYCord() - 1);

	}

	/**
	 * 
	 * @return string object containing the name of the robot.
	 */
	public String getName() {
		String str = mrRobotName;
		return str;
	}
	
	/**
	 * GetPosition returns a Position object 
	 * @return position object containing this robot position.
	 */

	public Posision getPosision() {
		Posision str = posisionStr;
		return str;
	}

	
	/**
	 * 
	 * @return Orientation object containing this robot current orientation
	 */
	public Orientation getOrientation() {
		Orientation orientation = orientationStr;

		return orientation;
	}

	/**
	 * toString method overrides the trostring method from the parent class object and returns a string containing robot name, position and orientation.
	 *@return a string objct containing robot information 
	 */
	@Override
	public String toString() {
		String name = "Robot info: \nName: " + getName() + "\n";
		String posString = "PosisionStr: " + getPosision().toString() + "\n";
		String orientation = "Orientation: " + getOrientation().toString() + ".";
		return name + posString + orientation;
	}

	/**
	 * 
	 * @return a string containing the robot position in x, y coordinates and the orientation.
	 * String returned will have the format "<xCord> <yCord> <orientation>"
	 */
	public String getReport() {
		String str = getPosision().toString() + " " + getOrientation().toString();
		return str;
	}

}