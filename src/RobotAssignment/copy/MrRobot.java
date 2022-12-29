package RobotAssignment.copy;

import javax.swing.JOptionPane;

public class MrRobot {

	private String mrRobotName;
	private Posision posisionStr;
	Orientation orientationStr;

	public MrRobot(String name, Posision posision, Orientation orientation) {
		setMrRobotName(name);
		setPosision(posision);
		setOrientation(orientation);
	}

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

	private void setOrientation(String string) throws Exception {
		if (!validateOrientation(string)) {
			throw new Exception(" Invalid direction");
		}
		
	}

	private boolean validateOrientation(String string) {
		boolean valid= false;
		string=string.toLowerCase();
		switch (string.charAt(0)) {
		case 'n':
			setOrientation(Orientation.North);
			valid=true;
		case 'e':
			setOrientation(Orientation.East);
			valid=true;
		case 's':
			setOrientation(Orientation.South);
			valid=true;
		case 'w':
			setOrientation(Orientation.West);
			valid=true;
		}
		
		return valid;
	}
	
	
	
	private void initialiseRobot(int retryAttempt) {
		int yCord, xCord;
		if (retryAttempt <= 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Retry Error: setting robot corrdinates wrong 3 times.\nProgram terminates!");

			} finally {
				System.exit(0);
			}
		}
		String string = JOptionPane.showInputDialog(
				"Please enter the robot posision and direction"
				+ ". \nacceptable vales should be in the form '<xCord> <yCord> <direction>' where width and deepth are Integer values\nEntering 10 15 N give Robot posision in 10,15 facing north.\nValid direction values are 'N, E, S, W'");
		
		
	
		try {
			xCord = Integer.parseInt(string.split(" ")[0]);
			yCord = Integer.parseInt(string.split(" ")[1]);
			setOrientation(string.split("")[2]);
			setPosision(new Posision(xCord, yCord));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "unexpected char instead of integer value" + e.getMessage());
			retryAttempt--;
			initialiseRobot(retryAttempt);

		} // end of initialising map
		
	}

	private void setMrRobotName() {
		String strName = JOptionPane.showInputDialog("Please type in Robot name");
		if (strName.equals(null)||strName.isBlank()) {
			setMrRobotName("MrRobot");
		} else {

			setMrRobotName(strName);
		}
	}

	public String act(Character character) {

		switch (character) {

		case 'l':

			rotateleft();

		case 'r':

			rotateRight();
		case 'f':
			walkForward();

		}

		return posisionStr.toString();
	}

	private void setMrRobotName(String name) {
		mrRobotName = name;

	}

	public void setOrientation(Orientation Orientation) {

		orientationStr = Orientation;

	}

	public void setPosision(Posision posision) {
		posisionStr = posision;

	}

	public void rotateRight() {
		switch (orientationStr) {
		case North:

			orientationStr = Orientation.East;

		case East:

			orientationStr = Orientation.South;

		case South:

			orientationStr = Orientation.West;

		case West:

			orientationStr = Orientation.North;
		}

	}

	public void rotateleft() {
		switch (orientationStr) {
		case North:

			orientationStr = Orientation.West;

		case East:

			orientationStr = Orientation.North;

		case South:

			orientationStr = Orientation.East;

		case West:

			orientationStr = Orientation.South;
		}
	}

	public void walkForward() {
		switch (orientationStr) {
		case North:

			walkNorth();

		case East:

			walkEast();

		case South:

			walkSouth();

		case West:

			walkWest();
		}

	}

	private void walkNorth() {
		posisionStr.setYCord(posisionStr.getYCord() + 1);
	}

	private void walkWest() {
		posisionStr.setXCord(posisionStr.getXCord() - 1);
	}

	private void walkEast() {
		posisionStr.setXCord(posisionStr.getXCord() + 1);

	}

	private void walkSouth() {
		posisionStr.setYCord(posisionStr.getYCord() - 1);

	}

	public String getName() {
		String str = mrRobotName;
		return str;
	}

	public Posision getPosision() {
		Posision str = posisionStr;
		return str;
	}

	public Orientation getOrientation() {
		Orientation orientation = orientationStr;

		return orientation;
	}

	@Override
	public String toString() {
		String name = "Robot info: \nName: " + getName() + "\n";
		String posString = "PosisionStr: " + getPosision().toString() + "\n";
		String orientation = "Orientation: " + getOrientation().toString() + ".";
		return name + posString + orientation;
	}
	public String getReport() {
		String str = getPosision().toString()+" "+getOrientation().toString();
		return str;
	}

	public static void main(String[] args) {
		// test case for map, test handling wrong input and program exit
		// Map map=new Map();

		// test white space input
		//Map map = new Map();
		
		
		
		
	}

}