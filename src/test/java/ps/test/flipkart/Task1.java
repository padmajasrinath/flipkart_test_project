package ps.test.flipkart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Task1 {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\eclipse-workspace\\seleniumProjectPrac\\drivers\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver(); 
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	
		WebElement loginWindow=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		loginWindow.click();
		Thread.sleep(3000);		
	      
		Actions objAction=new Actions(driver);
		
		//Electronics first mouseover 
		WebElement lnkElectronics=driver.findElement(By.xpath("//span[text()='Electronics']"));
		
		objAction.moveToElement(lnkElectronics).perform();
		Thread.sleep(3000);
		
		//Click Laptops  
	   WebElement txtLaptops=driver.findElement(By.xpath("//a[text()='Laptops']"));
	   txtLaptops.click();
       Thread.sleep(2000);
       
       //click lenova
       WebElement lenovaLaptop=driver.findElement(By.xpath("//div[text()='Lenovo']"));
       lenovaLaptop.click();
       Thread.sleep(2000);
       //selecting min range in price
       WebElement minRange=driver.findElement(By.xpath("//select[@class='_2YxCDZ']"));
       //use Select ref object
       Select optionSelect=new Select(minRange);
       optionSelect.selectByValue("30000");
       
     //finding the items listed on search
       List<WebElement> list = driver.findElements(By.tagName("a")); 
       System.out.println(list.size());
            
       //finding the item listed on search
       List<WebElement> itemsList = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
       int searchListSize = itemsList.size();
       System.out.println("The size of search result"+searchListSize);
     
       //iterating in the list
       for(int i=0;i<searchListSize;i++)
       { //Beginning of list iteration
    	String textSearchResult = itemsList.get(i).getText();
        System.out.println("Search Result is"+"\t"+textSearchResult);
       }//End of list iteration 
       
       //to avoid duplicates in the obtained list convert to set
       
       Set <WebElement>referenceSet=new HashSet(itemsList);
       
       //Size of set 
       int searchSetsize = referenceSet.size(); 
       System.out.println("The search result itemcount after removing duplicates (if any) " +searchSetsize );

       //iterating over the set 
       for (WebElement setResult : referenceSet) {
    	   //Beginnning of set iteration
    	   System.out.println("Search Result is from the Set is"+"\t"+setResult.getText());
	}//End of set iteration
       
       driver.close();
	}//End of main()
       
 
}//End of class

