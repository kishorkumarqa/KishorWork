import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.gargoylesoftware.htmlunit.javascript.host.Set;


public class Tatoc {



	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");

		//***********************FIRST PAGE*********************************************
		driver.findElement(By.linkText("Basic Course")).click();

		//********************************SECOND PAGE*************************************************

		driver.findElement(By.className("greenbox")).click();

		//*********************************THIRD PAGE**************************************************	
		driver.switchTo().frame(driver.findElement(By.id("main")));
		String Box1 = driver.findElement(By.id("answer")).getAttribute("class");
		String Box2 = null;
		do {
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#child")));
			Box2 = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(Box1.equals(Box2)){
				driver.findElement(By.linkText("Proceed")).click();
				break;
			}
			else driver.findElement(By.linkText("Repaint Box 2")).click();
		}
		while(!Box1.equals(Box2));


		//***********************************FOURTH PAGE(Drag and Drop)****************************************************

		WebElement Drag = driver.findElement(By.id("dragbox"));

		WebElement Drop = driver.findElement(By.id("dropbox"));

		Actions builder = new Actions(driver);

		builder.dragAndDrop(Drag, Drop).build().perform();

		driver.findElement(By.linkText("Proceed")).click();
		//**************************************************FIFTH PAGE(POP UP)*************************************************
		driver.findElement(By.linkText("Launch Popup Window")).click();

		String parentWindow = driver.getWindowHandle(); 
		String childWindow = null;

		java.util.Set<String> windows = driver.getWindowHandles();

		Iterator itr = (Iterator) windows.iterator();
		while(itr.next() != null)
			
		{
			childWindow= driver.getWindowHandles();
		}
		driver.switchTo().window(childWindow);
		driver.findElement(By.id("name")).sendKeys("hello");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.linkText("Proceed")).click();

		//******************************Cookie Handling********************************************************************
		driver.findElement(By.linkText("Generate Token")).click();
		String token1 = driver.findElement(By.id("token")).getText();
		String Token2 = token1.substring(token1.indexOf(":")+2);
		Cookie cookie = new Cookie("Token",Token2);
		driver.manage().addCookie(cookie);
		driver.findElement(By.linkText("Proceed")).click();

	}}
