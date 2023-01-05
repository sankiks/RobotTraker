package RobotAssignment.copy;

import javax.swing.JOptionPane;
/**
 * Class map defines the map boundaries in a 2D Cartesian space. An array of arrys
 * 
 * @author johan
 *
 */
public class Map {

	private int map[][];
	private int width;
	private int depth;

	/**
	 * Map constructor. Asks user for map dimensions input.
	 */
	public Map() {
		// start on initialising map
		setMapDimensions(3);

	}
	/**
	 * Map constructor sets map dimensions.
	 * @param width of the map or xCordinates.
	 * @param depth of the map or yCordinates.
	 */
	public Map(int width,int depth) {
		// start on initialising map
		setMapDimensions(width,depth);

	}
	/**
	 * Sets map dimensions.
	 * 
	 * @param width of the map.
	 * @param depth of the map.
	 */
	private void setMapDimensions(int width, int depth) {
		//for test purposes 
		map = new int[width][depth];
		setDepth(depth);
		setWidth(width);
		
	}

	
	/**
	 * Asks user for map dimension input and sets them.
	 * @throws wrong input exception at the third retry.
	 * @param repIndex is number of repeat times the program can asks for input before Program throws expection.
	 */
	private void setMapDimensions(int repIndex) {
		int depth, width;
		System.out.print(repIndex);

		String string = JOptionPane.showInputDialog(
				"Please enter the map dimmension. \nAcceptable vales should be in the form '<width> <deepth>' where width and deepth are Integer values\nEntering 10 15 gives 10 width and 15 deepth");
		if (repIndex <= 1) {
			try {
				throw new Exception("Wrong input.");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Retry Error: setting map dimensions wrong 3 times.\nProgram terminates!");
				
			} finally {
				System.exit(0);
			}
		}
		try {
			width = Integer.parseInt(string.split(" ")[0]);
			depth = Integer.parseInt(string.split(" ")[1]);
			map = new int[width][depth];
			setDepth(map[0].length);
			setWidth(map.length);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "unexpected char instead of integer value" + e.getMessage());
			repIndex--;
			setMapDimensions(repIndex);

		} // end of initialising map
		System.out.print(getDimentions());

	}

	/**
	 * Sets the depth of the map.
	 * @param depth of the map or y coordinate.
	 */
	private void setDepth(int depth) {
		// sets the map depth

		this.depth = depth;

	}
	
	/**
	 * sets the width of the map.
	 * @param width2.
	 */
	private void setWidth(int width2) {
		// sets the map width
		this.width = width2;

	}
	
	/**
	 * Gets the width of map.
	 * @return integer value width.
	 */

	public int getWidth() {
		int width1 = this.width;
		return width1;

	}
	
	/**
	 * Gets the depth of the map.
	 * 
	 * @return integer value depth
	 */
	public int getDepth() {
		int deepth1 = this.depth;
		return deepth1;

	}

	/**
	 * GetDimension return a string in the format "Width:xx Depth:xx"
	 * @return a string containing map dimensions.
	 */
	public String getDimentions() {
		String strWidth = "Width: ", strDeepth="Deepth: ";
		

		return strWidth+ Integer.toString(getWidth()) + " "+strDeepth + Integer.toString(getDepth());

	}

}
