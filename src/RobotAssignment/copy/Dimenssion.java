package RobotAssignment.copy;

/**
 * Dimenssion class represent the robots coordinates in a 2D dimensional space
 * @author johan
 *
 */
public class Dimenssion {
	private int width;
	private int deepth;

	/**
	 * Dimenssion Constructor sets the coordinates of the robot 
	 * @param width1 represent the robot movement in the x axle
	 * @param deepth2 represent the robot movement in the y axle
	 */
	public Dimenssion(int width1, int deepth2) {
		width1 = width;
		deepth2 = deepth;
	}
	
	/**
	 * DetDimenssion return the dimensions in the format <xCord> <yCord>
	 * @return a string object containing the stored coordinates
	 */
	private String getDimenssion() {

		String str = " ";

		return getWidth() + str + getDeepth();
	}

	/**
	 * 
	 * @return string object representing the depth of the robot, where it is in relation in the y-axle.
	 */
	private String getDeepth() {
		// TODO Auto-generated method stub

		String deepthStr = Integer.toString(deepth);
		return deepthStr;
	}
	/**
	 * 
	 * @return string object representing the width of the robot, where it is in relation in the x-axle.
	 */
	private String getWidth() {
		// TODO Auto-generated method stub

		String widthStr = Integer.toString(width);
		return widthStr;
	}

}
