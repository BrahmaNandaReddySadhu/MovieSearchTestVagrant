package moviesearch.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import moviesearch.base.TestBase;
import moviesearch.pages.ImdbPage;
import moviesearch.pages.WikiPage;
import moviesearch.utils.ExcelUtil;
import moviesearch.utils.Utilities;

public class Validate extends TestBase{
	ImdbPage imdbPage;
	WikiPage wikiPage;
	ExcelUtil excelUtil;
	
	
	@Test(dataProvider = "movieNamesData",dataProviderClass = ExcelUtil.class )
	public void checkMovieDetailsPositiveCase(String idmbMovieName,String wikiMovieName){
		System.out.println("launching url :https://www.imdb.com/");
		imdbPage= new ImdbPage();
		wikiPage= new WikiPage();
		excelUtil=new ExcelUtil();
		launchBrowserUrl("https://www.imdb.com/");
		imdbPage.enterMoviewNameToSearch(idmbMovieName);
		imdbPage.clickTheMatchedMovieName(idmbMovieName);
		imdbPage.scrolltoDetailsSection();
		String originCountryFromImdb = imdbPage.getOriginCountry();
		String releaseDateTextImdb = imdbPage.getReleaseDateText();
		System.out.println("fetched the origin country Value from imdb :"+originCountryFromImdb);
		System.out.println("fetched the release date from imdb :"+originCountryFromImdb);
		System.out.println("Navigating to url:https://en.wikipedia.org/");
		driver.navigate().to("https://en.wikipedia.org/");
		wikiPage.searchMovieName(wikiMovieName);
		String releaseDateFromWiki = wikiPage.getReleaseDate();
		System.out.println("fetched the release date from wiki :"+releaseDateFromWiki);
		String countryFromWiki = wikiPage.getCountry();
		System.out.println("fetched the country from wiki :"+countryFromWiki);
		String dateFromImdbValue = Utilities.getDateFromImdbValue(releaseDateTextImdb);
		String releaseDateFromWikiValue = Utilities.getDateInStringFormat(releaseDateFromWiki, "d MMMM yyyy");
		String releaseDateFromImdbValue = Utilities.getDateInStringFormat(dateFromImdbValue, "MMMMd,yyyy");
		System.out.println("release date after convertion into proper format from wiki:"+releaseDateFromWikiValue);
		System.out.println("release date after convertion into proper format from imdb:"+releaseDateFromImdbValue);
		Assert.assertEquals(originCountryFromImdb, countryFromWiki,"countries are not equal");
		Assert.assertEquals(releaseDateFromImdbValue, releaseDateFromWikiValue,"Release dates are not equal");	
	
	}
	
	
}
