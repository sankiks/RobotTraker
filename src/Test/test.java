package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import RobotAssignment.copy.Map;

class test {

	@Test
	void test() {
		//Map map= new Map(5, 6); old constructor
		Map map= new Map();
		assertEquals( 6, map.getDeepth());
		
		
	}

	

}
