import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;

class MainPage extends PageBase {

    private By searchBarTogglerBy = By.xpath("//a[@href='/search']");
    private By searchBarBy = By.id("js-site-search-input");
    private By userIcon = By.xpath("//*[@id='user_login_logout']/a");
	private By userIconUpdateData = By.xpath("//*[@id="sideBannerWrapper"]/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/a/img");
	
	
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://euronics.hu/");
    }


public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchBarTogglerBy).click();
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }
	
	/*
     
     Get title 
     
    */
public String getTitle() {
        return (this.driver).getTitle();
    }
  
    
public void logout() {
        this.login();
        WebElement menu = this.waitAndReturnElement(By.xpath("//*[@id="user_login_logout"]/a[2]"));
        Actions action = new Actions(this.driver);
        action.moveToElement(menu).perform();
        this.waitAndReturnElement(By.linkText("Check Out")).click();
    }
	 /*
     
     Go to register and login  page
     
    */
		public void loginPage(){
	this.waitAndReturnElement (userIcon).click();
	return new Login (this.driver);	
		
	}
    /*
     
     Go to updatePage
     
    */
public void toupdatePage(){
	this.waitAndReturnElement (userIconUpdateData).click();
	return new UpdatePage (this.driver);	
	
}
	
}
