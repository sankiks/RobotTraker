package RobotAssignment.copy;

public class Dimenssion {
	private int width;
	private int deepth;
	
	public Dimenssion(int width1,int deepth2) {
		width1=width;
		deepth2=deepth;
	}
	
	public Dimenssion() {
		
	}
	
	private String getDimenssion() {
		
		String str= " ,";
		
		return getWidth()+str+getDeepth();
	}

	private String getDeepth() {
		// TODO Auto-generated method stub
		
		String deepthStr= Integer.toString(deepth);
		return deepthStr;
	}

	private String getWidth() {
		// TODO Auto-generated method stub
		
		String widthStr= Integer.toString(width);
		return widthStr;
	}
	
	

}
