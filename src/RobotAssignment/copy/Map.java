package RobotAssignment.copy;

public class Map {

	private int map[][];
	private int width;
	private int deepth;

	public Map(int widthLength, int deepLength) {

		setMapDimensions(widthLength, deepLength);
	}

	public Map() {

		int defaultwidth = 10;
		int defualtdeepth = 10;
		setMapDimensions(defaultwidth, defualtdeepth);

	}

	private void setMapDimensions(int width, int deepth) {

		setDeepth(deepth);
		setWidth(width);
		map = new int[getWidth()][getDeepth()];

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
