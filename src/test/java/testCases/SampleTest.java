package testCases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest
{
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.monster.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		String parent= driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows);
		int count = allwindows.size();
		System.out.println("number of windows "+count);
		for(String child: allwindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.close();
			}
		}
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[@id='block']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Jobseeker Login']")).click();
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("signInName")).sendKeys("peramsravani001@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).sendKeys("sivakamala");
		Thread.sleep(2000);
		
		driver.findElement(By.id("signInbtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("SE_home_autocomplete")).sendKeys("devops ");
		Thread.sleep(2000);
		 
		//driver.findElement(By.id("SE_home_autocomplete")).sendKeys("Bengaluru/Bangalore");
		//Thread.sleep(2000);
		try {
			
		
		List <WebElement> list= driver.findElements(By.xpath("//div[@class='ac_results home_ac custom-v-scroll']//li/descendant::div[@class='home_ac']"));
		
		System.out.println(list.size());
		
		
		for(int i=0;i<=list.size();i++)
		{
			String s=list.get(i).getText();
			if(s.contains("Devops Engineer")) {
				list.get(i).click();
			}
			
			
			
			
		}
		
		}
		
		catch(Exception e)
		{
			
		}
		Thread.sleep(5000);
	
		try
		{
		driver.findElement(By.xpath("//input[@class='input location_ac']")).sendKeys("ch");
		Thread.sleep(2000);
		
		List<WebElement> chi=driver.findElements(By.xpath("//div[@class='ac_results home_ac custom-v-scroll']//li/descendant::div[@class='location_ac']"));
		
		System.out.println(chi.size());
		
		for(int j=0;j<=chi.size();j++)
		{
			String s=chi.get(j).getText();
			if(s.contains("China"))
			{
				chi.get(j).click();
				
			}
			Thread.sleep(2000);
			
		}
		}
		catch(Exception e) {
		
		}
		
		
		
		
		
		
		
		
		
		
		driver.close();
		
		
	}
	
	
	
	
	
}
	
	
	
	


