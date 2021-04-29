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


class LoginPage extends PageBase {

    private By nameInputBoxBy = By.name("j_username");
    private By passwordInputBoxBy = By.name("j_password");
    private By lastName = By.name("lastName");
    private By firstName = By.name("firstName");
    private By phone = By.name("phone");
    private By email = By.name("email");     
	private By pwd = By.name("pwd");
	private By checkPwd = By.name("checkPwd");
    private By path = By.xpath("//*[@id='euronicsRegisterForm']/div[10]/div[2]/button");

   public LoginPage(WebDriver driver) {
        super(driver);
    }    
    
    public DashboardPage login(String username, String password){
        this.waitAndReturnElement(nameInputBoxBy).sendKeys(username);
        this.waitAndReturnElement(passwordInputBoxBy).sendKeys(password+"\n");
        return new DashboardPage(this.driver);
    }
	
    public DashboardPage register(String nom,String prenom,String num ,String mail, String password){
        this.waitAndReturnElement(lastName).sendKeys(nom);
		this.waitAndReturnElement(firstName).sendKeys(prenom);
		this.waitAndReturnElement(email).sendKeys(mail);
		this.waitAndReturnElement(phone).sendKeys(num);
        this.waitAndReturnElement(pwd).sendKeys(password);
		this.waitAndReturnElement(checkPwd).sendKeys(password);
	    this.waitAndReturnElement(path).click();

        return new DashboardPage(this.driver);
		
    }
}
