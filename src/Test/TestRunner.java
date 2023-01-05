package Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {  
	   public static void main(String[] args) {  
		  
	      Result result = JUnitCore.runClasses(TestRobotController.class);  
	          
	      for (Failure fail : result.getFailures()) {  
	         System.out.println(fail.toString());  
	      }  
	          
	      System.out.println(result.wasSuccessful());  
	   }  
	}