package steps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ReportingUtil.Reporters;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
	
	WebDriver driver;
	
	Reporters R1;

	@Given("user launch browser")
	public void user_launch_browser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Then("user opens URL as {string}")
	public void user_opens_url_as(String URL) throws Throwable, IOException {
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		R1 = new Reporters();
		R1.CreateHTMLReport("TC01_AddSkills");
		
		R1.logger(driver,"URL LAUNCH" , "Succefully launched");

	}

	@Then("user enters username as {string} and password as {string} and clicks login btn")
	public void user_enters_username_as_and_password_as_and_clicks_login_btn(String USERNAME, String PASSWORD) throws InterruptedException, Throwable {
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		Thread.sleep(3000);
		
		R1.logger(driver, "Login credentials", "after entering login credentials");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

	}

	@Then("user clicks admin")
	public void user_clicks_admin() {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();

	}

	@Then("clicks qualification dropdown and clicks skills option")
	public void clicks_qualification_dropdown_and_clicks_skills_option() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[1]")).click();
		Thread.sleep(2000);

	}

	@Then("click add button")
	public void click_add_button() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
		R1.logger(driver, "skills page", "bbefore entering skilldetails");

	}

	@Then("enter skillname as {string} and skill description as {string} and clicks save btn")
	public void enter_skillname_as_and_skill_description_as_and_clicks_save_btn(String SKILLNAME, String SKILLDESC) throws InterruptedException, IOException {

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys(SKILLNAME);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")).sendKeys(SKILLDESC);
		
		Thread.sleep(2000);
		R1.logger(driver, "Skill details", "after entering sklill details");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
	}

	@Then("logout")
	public void logout() {

	}

	@Then("close browser")
	public void close_browser() {
		
		R1.closeReport();

	}

}
