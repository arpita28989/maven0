package Arpita;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	 
	SoftAssert softAssert = new SoftAssert();
	 

//------------PRIORITY IS TO RUN ACCORDING TO SEQUENCE--------------------	
	
	
  @Test (priority=1)
  public void hometest() {
	  
	  System.out.println("I am in home test");
	  
	  System.out.println("Before Assertion");
	  
	  Assert.assertTrue(4>3,"verifying element");
	  
	  System.out.println("After assertion");
	  
	  Assert.assertEquals("abc", "abc");
  }
	  
//-----------SOFT ASSERT----------------------------
	  
	  
	  @Test (priority=2, dependsOnMethods="hometest" , groups= {"smoke","sanity"}) //----DEPENDENCIES WILL SKIP THE DEPENDENT TEST ID THE TEST THAT IT DEPENDS ON  FAILS----
	  public void mainTest() {
		  
		  System.out.println("I am in main test");
		  
		  System.out.println("Before Assertion");
		  
		  softAssert.assertTrue(2>3,"verifying element");
		  
		  System.out.println("After assertion");
		  
		  softAssert.assertAll(); //-SAME AS ERRORCOLLECTOR-----------
	  
	  }
	  
	  @Test (priority=3, dependsOnMethods="mainTest", groups = "smoke")
	  public void endTest() {
		  
		  System.out.println("I am in end test");
		  
		  System.out.println("Before Assertion");
		  
		  softAssert.assertTrue(2>3,"verifying element");
		  
		  System.out.println("After assertion");
		  
		  softAssert.assertEquals("abc", "abc1");
		  
		  System.out.println("After second Assertion");
		  
		  softAssert.assertAll();
	  }
	
}
