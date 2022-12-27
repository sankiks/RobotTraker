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
		setMap(new Map());
		setRobot(new MrRobot());
		Tracker();
	}

	private void Tracker() {
		
		String input = GetUserInput();
		
		input=input.toLowerCase();
		checkUserInput(input);
		String newPos = validateNewPos(input);

	}

	private String GetUserInput() {
		String input=JOptionPane.showInputDialog("input movement");
		//den ska ta emot user input
		
		return input;
	}

	private void checkUserInput(String input) {
		// TODO Auto-generated method stub
		boolean validate=true;
		while (validate &&  input.length()<index) {

			
			
		}
	}

	private String validateNewPos(String input) {
		char steps[] = input.toCharArray();
		Orientation orientation = this.robot.getOrientation();
		String poString = robot.getPosision().getXCord() + ", " + robot.getPosision().getYCord();
		
		
		
		readNewPos(input);
		

		return null;
	}

	private void readNewPos(String input) {

		int index = 0;

		while (charArr.length > index) {

			act(input.charAt(index));

			robot.walkForward();
		}
	}

	private MrRobot act(Character character ) {
		
		MrRobot robotTemp=robot;
		
		switch (character) {
		
			case 'l':
				
				robotTemp.rotateleft();
				
				
			case 'r':
				
				robotTemp.rotateRight();
			case 'f':
				
				robotTemp.walkForward();
				
			default:
				false;
			}
		
		

	}

	private void setRobot(MrRobot robot) {

		this.robot = robot;

	}

	private void setMap(Map map) {

		this.map = map;
	}

}
