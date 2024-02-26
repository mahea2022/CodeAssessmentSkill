package webstaurantStore;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class webstaurantSearch {
	WebDriver driver;
	By SEARCH_BOX = By.xpath("//*[@id=\"searchval\"]");
	By SUBMIT_BUTTON = By.xpath("//*[@id=\"searchForm\"]/div/button");
	By VIEW_CART = By.xpath("//*[@id=\"watnotif-wrapper\"]/div/p/div[2]/div[2]/a[1]");
	By EMPTY_CART = By.xpath("//*[@id=\"main\"]/div[1]/div/div[1]/div/button");
	By CONFIRM_TO_EMPTY_CART = By.xpath("//*[@id=\"td\"]/div[11]/div/div/div/footer/button[1]");

	@Before
	
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.webstaurantstore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void searchItem() {
		driver.findElement(SEARCH_BOX).sendKeys("stainless work table");
		driver.findElement(SUBMIT_BUTTON).click();
		String searchQuery = "table";
		
		List<WebElement> productList = driver.findElements(By.cssSelector("#react_0HN1KUUMM9J1F > div > div.search__wrap > h1 > span"));
		 for (WebElement product : productList) {
	            String title = product.getText();
	            if (title.toLowerCase().contains(searchQuery.toLowerCase())) {
	                System.out.println("Product title contains table " );
	            } else {
	                System.out.println("Product title does not contain the table title ");
	            }
	            WebElement lastAddToCartButton = driver.findElement(By.xpath("//*[@id=\"ProductBoxContainer\"]/div[4]/form/div/div/input[2]"));
	            lastAddToCartButton.click();
	            
	            
	            
	            driver.findElement(VIEW_CART).click();
	            
	            driver.findElement(EMPTY_CART).click();
	            
	            driver.findElement(CONFIRM_TO_EMPTY_CART).click();
	            
	}
		 
		 }
	
	@After
	public void tearDown() {
		driver.close();
	}

}

