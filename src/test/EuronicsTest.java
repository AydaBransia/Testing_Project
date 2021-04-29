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
import java.util.*;  


public class EuronicsTest {
    public WebDriver driver;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void Login() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.login();
        DashboardPage dashboardPage = loginPage.login("imuhxuufv@nucleant.org","123456789");
        
        System.out.println(dashboardPage.getUserName());
        Assert.assertTrue(dashboardPage.getUserName().contains("YYYYYY"));
		
    }
	
	@Test
    public void staticPage() {
        MainPage mainPage = new MainPage(this.driver);
		String[] links = new String[] {

         "AKCIÓS AJÁNLATOK", "TV, Audio, Videó", "Telefon és navigáció" , "Háztartási nagygépek" , "Fotó &amp; videó",

         };
		 for (String link : links) { 
		 
		 Assert.assertTrue(mainPage.getBodyText().contains(link));

           }

	}

    @Test
    public void Logout() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.login();
        DashboardPage dashboardPage = loginPage.login("imuhxuufv@nucleant.org","123456789");
		MainPage logoutPage = dashboardPage.logout();
		Assert.assertTrue(mainPage.getBodyText().contains("BELÉPÉS | REGISZTRÁCIÓ"));
		
}
	@Test
	public void register(){
		MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.login();
        DashboardPage dashboardPage = loginPage.register("YYYYYY","xxxxxx","7008102288","imuhxuufv@nucleant.org","123456789");
        
        System.out.println(dashboardPage.getUserName());
        Assert.assertTrue(dashboardPage.getUserName().contains("YYYYYY"));
	}
	@Test
	public void update(){
		MainPage mainPage = new MainPage(this.driver);
        UpdatePage updatePage = mainPage.toupdatePage();
        DashboardPage dashboardPage = updatePage.update("YYYYYY12","xxxxxx","7008102288","1103","Budapest", "House","15");
        
        System.out.println(dashboardPage.getUserName());
        Assert.assertTrue(dashboardPage.getUserName().contains("YYYYYY12"));
	}
	
	
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
	

}
