import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PaginationSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		
		
		//**************************************************
		List<String> price;
		do{
		//scan the name column with get text  -> Beans -> print the price of the rice 
			List<WebElement> copyWEL=driver.findElements(By.xpath("//tr/td[1]"));
price=copyWEL.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		 
		
		//*************************************************	
		
		
		////scan the name column with get text  -> Beans -> print the price of the rice [which is present in different pages]
		
			if (price.size()<1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();				
			}
		}
		while(price.size()<1);
		
		}
	
	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		 String pricevalue=s.findElement(By.xpath("following-sibling :: td[1]")).getText();
		return pricevalue;

	}

}
