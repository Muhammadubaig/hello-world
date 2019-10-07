package Stepdefinition;

import java.util.*;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features" , glue= {"Stepdefinition"})

public class Stepdefine {
	WebDriver driver;
	
	@Given("I have link  {string}")
	public void i_have_link(String string) throws Throwable {
		System.setProperty("webdriver.chrome.driver","G:\\SELENIUM  PRACTISE\\Chrome\\chromedriver.exe\\");//https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLoginhttps://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/");	    
	}

	@When("I enter valid {string}")
	public void i_enter_valid(String string) throws Throwable  {
	   driver.findElement(By.xpath("//*[@name='q']")).sendKeys("hygieia");	   
	}

	@When("click search")
	public void click_search() throws Throwable {
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		WebElement githubbutn = driver.findElement(By.xpath("//*[@id=\"jump-to-suggestion-search-global\"]/a/div[3]/span[2]"));
		action.moveToElement(githubbutn).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"jump-to-suggestion-search-global\"]/a/div[3]/span[2]")).click();
	}
	
	@Then("is should display the Result")
	public void is_should_display_the_Result() throws Throwable {
	try {
	    //String data = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[3]/div")).getText();        
	    //System.out.println(data);
		String repo_count=driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[3]/div/div[1]/h3")).getText();
		String[] pj = repo_count.split(" ");
		System.out.println(pj[0]);
		System.out.println(repo_count);
		List<WebElement>  Major_links_count = driver.findElements(By.xpath("//a[@class='v-align-middle']"));
		int pagelinks_count = Major_links_count.size();
		System.out.println(pagelinks_count);

		if(pagelinks_count>=3)
		{
			System.out.println(pj[0]);
		}

		for(int i=1;i<=pagelinks_count;i++)
		{
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[3]/div/div[2]/div/a["+ i +"]")).click();
		int x=i+1;
		System.out.println(pj[x]);
		}
		}catch(NoSuchElementException e){
		}
}
}
	
		
