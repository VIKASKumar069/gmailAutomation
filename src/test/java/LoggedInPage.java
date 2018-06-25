import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage {
   WebDriver driver;
   
   public LoggedInPage(WebDriver driver) {
	   this.driver = driver;
   }
   
   public void readFirstUnreadEmail() {
	//   WebDriverWait wait = new WebDriverWait(driver, 10);
	  // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aio.UKr6le > span > a")));

	   	List<WebElement> unread_mails = driver.findElements(By.cssSelector("div.Cp > div > table.F.cf.zt > tbody > tr.zA.zE"));
      //System.out.println(unread_mails.size());
      unread_mails.get(0).click();
    //  driver.findElement(By.cssSelector("div.aio.UKr6le > span > a")).click();
   }
   
   
   public void unreadEmails() {
	   WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aio.UKr6le")));
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aio.UKr6le > span > a")));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#\\3a hb > div > div.aio.UKr6le > span > a")));
	//WebElement inboxBtn = driver.findElement(By.cssSelector("a:contains[linkText^=Inbox]"));
		//WebElement inboxBtn = driver.findElement(By.cssSelector("div.aio.UKr6le > span > a"));
	   	WebElement inboxBtn = driver.findElement(By.partialLinkText("Inbox"));
	   	String unread_inbox = inboxBtn.getAttribute("title");
	   	String total_unread = inboxBtn.getAttribute("aria-label");
	   	System.out.println("Unread Primary Mails = " + unread_inbox.substring(7, unread_inbox.length()-1));
	   	System.out.println("Total unread Mails = " + total_unread.substring(6, total_unread.length()-7));
   }
}
