package moviesearch.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {

	XSSFWorkbook workbook;

	public ExcelUtil() {
		File file = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\moviesearch\\exceldata\\MovieSearch.xlsx");

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			System.err.println("exception occured during excel file reading " + e.getMessage());
		}
	}

	@DataProvider(name = "movieNamesData")
	public String[][] movieNameList() {
		ExcelUtil utils = new ExcelUtil();
		XSSFSheet sheet = workbook.getSheet("movieSearch");
		int row = sheet.getPhysicalNumberOfRows();
		System.out.println("number of the rows in excel" + row);
		int columns = sheet.getRow(0).getLastCellNum();
		System.out.println("number of the columns" + columns);
		String[][] string = new String[row][columns];
		for (int i = 0; i <= row - 1; i++) {
			for (int j = 0; j < columns; j++) {
				DataFormatter dataFormatter = new DataFormatter();
				string[i][j] = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println("movie names are :" + string[i][j]);
			}
		}

		return string;

	}

}
