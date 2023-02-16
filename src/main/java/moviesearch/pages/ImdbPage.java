package moviesearch.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moviesearch.base.TestBase;

import moviesearch.utils.Utilities;

public class ImdbPage extends TestBase {
	
	@FindBy(xpath = "//*[@placeholder='Search IMDb']")
	private WebElement searchBoxFieldOfImdb;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement searchIcon;
	
	@FindBy(xpath = "//*[@data-testid=\"Details\"]")
	private WebElement detailsSection;
	
	@FindBy(xpath = "//*[@data-testid='Details']// descendant::a[text()='Release date']/../div/descendant::a")
	private WebElement releaseDateText;
	
	@FindBy(xpath = "//*[@data-testid='title-details-section']//descendant::li/button[text()='Country of origin']/../child::div/descendant::a")
	private WebElement originOfCountry;
	
	
	@FindBy(xpath = "//*[contains(@class,'ipc-metadata-list-summary-item')]//a")
	private List<WebElement> listOfMovies;
	
	
	
	public ImdbPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 *  this method is entering the movie name and searching for the matched movie and clicking on it
	 */
	public void enterMoviewNameToSearch(String movieName) {
		System.out.println("Entering the movie Name :"+movieName);
		searchBoxFieldOfImdb.sendKeys(movieName, Keys.ENTER);
	}
	
	/*
	 *  getting the release date
	 */
	public String getReleaseDateText() {
		String releaseDate= releaseDateText.getText();
		System.out.println("relase date from imdb page :"+releaseDate);
		return releaseDate;
	}
	
	/*
	 *  getting country
	 */
	public String getOriginCountry() {
		String originCountry=originOfCountry.getText();
		System.out.println("original country from imdb page :"+originCountry);
		return originCountry;
		
	}
	/*
	 * scrolling o detail section
	 */
	public void scrolltoDetailsSection()  {
		System.out.println("Scrolling to Detail Section");
		Utilities.scrollToElement(driver, detailsSection);
		Utilities.waitForSpecifiedTimeInSecond(driver, 10);
	}
	
	
	public void clickTheMatchedMovieName(String movieValue)  {
		System.out.println("Searchin Movie Name"+movieValue);
		for(int i=0;i<listOfMovies.size();i++) {
			String text = listOfMovies.get(i).getText();
			System.out.println("movie list name in the searching page  :"+text);
		   String movieNameFromList = listOfMovies.get(i).getText();
		   if(movieValue.contains(movieNameFromList));{
			   System.out.println(movieValue +" contained in "+ movieNameFromList);
			   listOfMovies.get(i).click();
		   }
			
		}
	}

}
