

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class gmailTests {
   WebDriver driver;
   String url = "https://gmail.com";
   
   @BeforeTest
   public void LaunchSignInPage() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\DeadpooL\\Downloads\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get(url);
   }
   
   @Test(priority=0)
   public void loginGmail() {
	   loginPage obj = new loginPage(driver);
	   obj.login("kvikas0069", "01122782020");
   }
   
   @Test(priority=1, enabled=true)
   public void unreadMails() {
	   LoggedInPage obj = new LoggedInPage(driver);
	   obj.unreadEmails();
   }
   
   @Test(priority=2)
   public void readFirstUnreadMail() {
	   LoggedInPage obj = new LoggedInPage(driver);
	   obj.readFirstUnreadEmail();
   }
   
   @Test(priority=3) 
   public void updateUnreadMails() {
	   System.out.println("After reading first unread mail");
	   LoggedInPage obj = new LoggedInPage(driver);
	   obj.unreadEmails();
   }
   
   @AfterTest
   public void close() throws InterruptedException {
	  // Thread.sleep(2500);
	   //driver.close();
   }
   
	
}
