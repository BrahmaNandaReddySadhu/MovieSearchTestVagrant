package moviesearch.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moviesearch.base.TestBase;
import moviesearch.utils.Utilities;

public class WikiPage extends TestBase {
	// wiki search box locator
	@FindBy(xpath = "//*[@name='search']")
	private WebElement wikiSearchBox;

	// wiki searchIcon locator
	@FindBy(xpath = "//button[@text()='Search']")
	private WebElement searchIcon;

	// wiki releaseDate locator
	@FindBy(xpath = "//*[@class='infobox vevent']//descendant::*[text()='Release date']/../following-sibling::td/div/ul/li")
	private WebElement releaseDate;

	// wiki country locator
	@FindBy(xpath = "//*[@class='infobox vevent']//descendant::*[text()='Country']/../td")
	private WebElement country;

	// list of all the movie names
	@FindBy(xpath = "//*[@class='mw-search-results']/li/descendant::a")
	private List<WebElement> searchListValues;

	public WikiPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * This method is used to search the name of the Movie in wiki page , after
	 * searching it is showing list of the movies list from that list it selecting
	 * the matched movie name and clicking on it
	 */
	public void searchMovieName(String movieName) {
		Utilities.waitForSpecifiedTimeInSecond(driver, 10);
		System.out.println("searchng movie name in the wiki:" + movieName);
		Utilities.waitUntilClikable(driver, wikiSearchBox, 20);
		wikiSearchBox.click();
		wikiSearchBox.sendKeys(movieName, Keys.ENTER);
		if (searchListValues.size() > 0) {
			for (int i = 0; i < searchListValues.size(); i++) {
				System.out.println("movie list values " + searchListValues.get(i).getText());
				if (movieName.equalsIgnoreCase(searchListValues.get(i).getText())) {
					searchListValues.get(i).click();
				}
			}
		}
	}

	/*
	 * this method is getting the release date from the wikipage
	 */

	public String getReleaseDate() {
		Utilities.scrollToElement(driver, releaseDate);
		System.out.println("release date from the wikipage : " + releaseDate.getText());
		return releaseDate.getText();
	}

	/*
	 * this method getting the country from the wikipage
	 */
	public String getCountry() {
		System.out.println("country from the wikipage : " + country.getText());
		return country.getText();
	}

}
