package RobotAssignment.copy;

import javax.swing.JOptionPane;

public class Map {

	private int map[][];
	private int width;
	private int deepth;

	public Map() {
		// start on initialising map
		setMapDimensions(3);

	}
	
	public Map(int width,int depth) {
		// start on initialising map
		setMapDimensions(width,depth);

	}
	
	private void setMapDimensions(int width, int depth) {
		//for test purposes 
		map = new int[width][deepth];
		setDeepth(depth);
		setWidth(width);
		
	}

	private void setMapDimensions(int repIndex) {
		int deepth, width;
		System.out.print(repIndex);

		String string = JOptionPane.showInputDialog(
				"Please enter the map dimmension. \nAcceptable vales should be in the form '<width> <deepth>' where width and deepth are Integer values\nEntering 10 15 gives 10 width and 15 deepth");
		if (repIndex <= 1) {
			try {
				throw new Exception();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Retry Error: setting map dimensions wrong 3 times.\nProgram terminates!");

			} finally {
				System.exit(0);
			}
		}
		try {
			width = Integer.parseInt(string.split(" ")[0]);
			deepth = Integer.parseInt(string.split(" ")[1]);
			map = new int[width][deepth];
			setDeepth(map[0].length);
			setWidth(map.length);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "unexpected char instead of integer value" + e.getMessage());
			repIndex--;
			setMapDimensions(repIndex);

		} // end of initialising map
		System.out.print(getDimentions());

	}

	private void setDeepth(int deepth) {
		// sets the map deepth

		this.deepth = deepth;

	}

	private void setWidth(int width2) {
		// sets the map width
		this.width = width2;

	}

	public int getWidth() {
		int width1 = this.width;
		return width1;

	}

	public int getDeepth() {
		int deepth1 = this.deepth;
		return deepth1;

	}

	public String getDimentions() {
		String str = " ,";

		return Integer.toString(getWidth()) + str + Integer.toString(getDeepth());

	}

}
