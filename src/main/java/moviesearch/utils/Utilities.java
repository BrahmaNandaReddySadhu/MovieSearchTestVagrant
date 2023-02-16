package moviesearch.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	public static void waitUntilClikable(WebDriver driver, WebElement element, long timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		if (element != null) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		waitUntilPageLoaded(driver, 10);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void waitUntilPageLoaded(WebDriver driver, long timeOut) {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

	}

	/*
	 * Convert the date into December 17,2021 to 2021-12-17 since dates are two
	 * different format in fetched value
	 */

	public static String getDateInStringFormat(String date, String dateFormator) {

		LocalDate dateValue = null;
		String string = date;
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormator);
			dateValue = LocalDate.parse(string, format);
		} catch (Exception e) {

		}
		return dateValue.toString();
	}

	public static String getDateFromImdbValue(String dateContainedText) {
		String dateFormatString = "";
		String[] dateString = dateContainedText.split(" ");
		dateFormatString = dateFormatString + dateString[0] + dateString[1] + dateString[2];
		return dateFormatString;

	}
	
	public static void waitForSpecifiedTimeInSecond(WebDriver driver,long timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
