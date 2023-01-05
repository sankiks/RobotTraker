package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import RobotAssignment.copy.Map;
import RobotAssignment.copy.MrRobot;
import RobotAssignment.copy.Orientation;
import RobotAssignment.copy.Posision;


public class TestRobotController {

	@Test
	public void testMap() {
		// Map map= new Map(5, 6); old constructor
		Map map = new Map();
		// make sure when inputing the dimension the depth or y value is set to 6
		assertEquals(6, map.getDepth());

	}

	@Test
	public void testSetMapDeepth() {
		// map(width, depth)
		Map map = new Map(13, 15);
		assertEquals(15, map.getDepth());

	}
	@Test
	public void testSetMapWidth() {
		// map(width, depth)
		Map map = new Map(13, 15);
		assertEquals(13, map.getWidth());

	}
	@Test
	public void testMapDimenssions() {
		Map map = new Map(13, 15);
		assertEquals("Width: 13 Deepth: 15", map.getDimentions());
		
	}
	

	
	@Test
	public void testMrRobotName() {
		MrRobot robot =new MrRobot("MrRobot", new Posision(3, 3), Orientation.North);
		
		assertEquals("MrRobot", robot.getName()); 
	}
	
	@Test
	public void testMrRobotAct() {
		MrRobot robot =new MrRobot("MrRobot", new Posision(3, 3), Orientation.North);
		robot.act('f');
		assertEquals("3 4 North", robot.getReport());
		
	}

}
