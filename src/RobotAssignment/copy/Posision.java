package RobotAssignment.copy;


/**
 * Posision class represent the position of the robot in 2D Cartesian space.
 * @author johan
 *
 */
public class Posision {
	private int x;
	private int y;

	
	/**
	 * Posision constructor takes in the values x and y and sets the position accordingly.
	 * @param x integer value represent the object position in the x-axle (relative to the map width).
	 * @param y integer value represent the object position in the x-axle (relative to the map width).
	 */
	public Posision(int x, int y) {
		setXCord(x);
		setYCord(y);
	}

	/**
	 * sets the y coordinates
	 * @param y2 integer value representing the y-coordinates
	 */
	public void setYCord(int y2) {
		y = y2;
	}

	/**
	 * sets the x coordinates
	 * @param x2 integer value representing the x-coordinates
	 */
	public void setXCord(int x2) {
		x = x2;

	}
	
	/**
	 * Gets the x coordinates 
	 * @return integer value containing the x value
	 */
	public int getXCord() {
		int xCord=x;
		return xCord;
	}

	/**
	 * Gets the y coordinates 
	 * @return integer value containing the y value
	 */
	public int getYCord() {
		int yCord=y;
		return yCord;
	}
	@Override
	/**
	 * Tostring overrider the ingereted method and return a formated string containing the position value in x y format
	 * @return string object contains the position in x,y format.
	 */
	public String toString() {
		String posStr= getXCord()+" "+getYCord();
		return posStr;
		
	}
}
