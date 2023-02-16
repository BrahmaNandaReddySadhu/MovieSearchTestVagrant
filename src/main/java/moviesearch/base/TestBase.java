package moviesearch.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author brahma
 *
 */
public class TestBase {

	public static WebDriver driver;
	public static Properties properties;

	public TestBase() {
		properties = new Properties();
		File file = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\moviesearch\\config\\confi.properties");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			System.out.println("Loading the properties file" + file);
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			System.err.println("File is not available during loading the properies");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Io Exception occured ");
			e.printStackTrace();
		}
	}

	public void initialize_driver() {
		System.out.println("browser initailization");
		String browserName = properties.getProperty("browser");
		System.out.println("browser name : " + browserName);
		switch (browserName) {
		case "chrome":
			System.out.println("chrome driver instantiation");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			System.out.println("firefox driver instantiation");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.out.println("edge driver instantiation");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("supported browsers are chrome,edge,firefox");
			break;
		}

	}

	public void launchBrowserUrl(String urlName) {
		System.out.println("URL Name:" + urlName);
		driver.get(urlName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	}

	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing driver");
		initialize_driver();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("closing driver");
		driver.quit();
	}

}
