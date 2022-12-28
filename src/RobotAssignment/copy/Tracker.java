package RobotAssignment.copy;

import java.awt.Robot;

import javax.swing.JOptionPane;

import org.junit.validator.PublicClassValidator;

public class Tracker {

	private Map map;
	private MrRobot robot;

	public Tracker(Map map, MrRobot robot) {
		setMap(map);
		setRobot(robot);
		Tracker();
	}

	public Tracker(Map map) {
		setMap(map);
		setRobot(new MrRobot());
		Tracker();
	}

	public Tracker(MrRobot robot) {
		setMap(new Map());
		setRobot(robot);
		Tracker();
	}

	public Tracker() {
		TrackerInIt();

		Tracker();
	}

	//maybe leave the initialisation of the MrRobot and Map be separate in own classes?
	private void TrackerInIt() {
		
		setMap(new Map());
		setRobot(new MrRobot());
		int xCord, yCord;
		String  name = JOptionPane.showInputDialog(
				"Please enter the robot name");

		

	}

	private void Tracker() {
		while (true) {

			String input = GetUserInput(0);

			String newPos = updateNewPos(input);
			JOptionPane.showMessageDialog(null, "New Posision: " + newPos);

		}
	}

	private String GetUserInput(int index) {
		if (index >= 2) {
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
		if (checkUserInput(input)) {
			return input;
		}

		return GetUserInput(index++);
	}

	private boolean checkUserInput(String input) {
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

	private String updateNewPos(String input) {
		MrRobot tmpRobot = robot;

		int index = 0;

		while (input.length() > index) {
			tmpRobot.act(input.charAt(index));
			index++;
			try {

				if (!withinBond(tmpRobot)) {
					throw new Exception("Robot walked out of bounds. \nGood Luck next time");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Robot walked out of bounds. \nGood Luck next time");
				System.exit(0);
			}

		}
		setRobot(tmpRobot);
		return robot.getPosision().toString();
	}

	private boolean withinBond(MrRobot robot) {
		boolean withinBound = true;
		if (robot.getPosision().getXCord() >= map.getWidth() || robot.getPosision().getXCord() < 0
				|| robot.getPosision().getYCord() >= map.getDeepth() || robot.getPosision().getYCord() < 0) {
			withinBound = false;
		}
		return withinBound;
	}

	private void setRobot(MrRobot robot) {

		this.robot = robot;

	}

	private void setMap(Map map) {

		this.map = map;
	}

}
