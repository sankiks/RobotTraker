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

	public MrRobot() {
		setMrRobotName("MrRobot");
		setPosision(new Posision(0, 0));
		setOrientation(Orientation.North);

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

			orientationStr=Orientation.East;

		case East:

			orientationStr=Orientation.South;

		case South:

			orientationStr=Orientation.West;

		case West:

			orientationStr=Orientation.North;
		}
		
	}
	
	
	public void rotateleft() {
		switch (orientationStr) {
		case North:

			orientationStr=Orientation.West;

		case East:

			orientationStr=Orientation.North;

		case South:

			orientationStr=Orientation.East;

		case West:

			orientationStr=Orientation.South;
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

	public static void main(String[] args) {
		String string;
		string = JOptionPane.showInputDialog("hej");
		JOptionPane.showMessageDialog(null, string);
	}

}