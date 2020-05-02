package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class Handson1StepDef {
	WebDriver driver;
	@Given("^User comes on phptravels homepage$")
	public void user_is_on_homepage_of_phptravels(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Then("^user clicks the button of Myaccount and then click on sign up tab$")
	public void user_needs_to_click_on_Myaccount_and_next_click_on_sign_up() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[2]")).click();		
		
	}
	@Then("^enter the user details$")
	public void enter_the_details_of_user(DataTable credentials) {
		List<List<String>> userData =  credentials.raw();
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[3]/div[1]/div/label/input")).sendKeys(userData.get(0).get(0));
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[3]/div[2]/div/label/input")).sendKeys(userData.get(0).get(1));
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[4]/label/input")).sendKeys(userData.get(0).get(2));
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[5]/label/input")).sendKeys(userData.get(0).get(3));
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[6]/label/input")).sendKeys(userData.get(0).get(4));
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[7]/label/input")).sendKeys(userData.get(0).get(5));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	@Then("^after giving details submit the form$")
	public void after_giving_details_submit_the_form()  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[8]/button")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3"))));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals("My Account",driver.getTitle());
		driver.close();
	}

}
