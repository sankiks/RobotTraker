package RobotAssignment.copy;

public class Posision {
	private int x;
	private int y;

	public Posision(int x, int y) {
		setXCord(x);
		setYCord(y);
	}

	public void setYCord(int y2) {
		y = y2;
	}

	public void setXCord(int x2) {
		x = x2;

	}
	
	public int getXCord() {
		int xCord=x;
		return xCord;
	}
	
	public int getYCord() {
		int yCord=y;
		return yCord;
	}
	public String toString() {
		String posStr= getXCord()+", "+getYCord();
		return posStr;
		
	}
}
