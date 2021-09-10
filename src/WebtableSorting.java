import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebtableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		//click on column
		//capture all web elements into list
		//capture text of all webelements into new (original) list
		//sort in the list of step 3 -> sorted list 
		//compare original list v/s sorted list
		//***************************************
	
		//click on column
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		
		//capture all web elements into list
		List<WebElement> WEL=driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new (original) list
		List<String> originallist=WEL.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort in the list of step 3 -> sorted list
		List<String> sortedlist=originallist.stream().sorted().collect(Collectors.toList());
		
		//compare original list v/s sorted list
		Assert.assertTrue(originallist.equals(sortedlist));
		
		
		 
		
		
		
	}

}
