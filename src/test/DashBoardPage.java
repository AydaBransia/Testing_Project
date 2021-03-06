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


class DashboardPage extends PageBase {
    private By logout = By.xpath("//*[@id='user_login_logout']/a[2]");
    private By mainCardBy = By.xpath("//div[@class='Card-content']/div/div/h2/span");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }    
    
    public String getMainCardTitle(){
        return this.waitAndReturnElement(mainCardBy).getText();
    }
	
	
	
	public void logout() {
		
                
        this.waitAndReturnElement(logout).click();
		return new MainPage(this.driver);
    }
}



