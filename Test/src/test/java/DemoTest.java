import org.testng.annotations.Test;

public class DemoTest {
	
	
	@Test(groups= {"smokeTest"})
	
	public void demoTest() {
		System.out.println("========test1=========ADITYA==========");
		System.out.println("hiii");
	}

   @Test(groups= {"full"})
	
	public void demoTest1() {
		System.out.println("========test2===========khare========");
		System.out.println("hiii");
	}
}

