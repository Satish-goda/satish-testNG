package seleniumTraining.TestComponents;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {
	public static void main(String[] args) throws IOException { // TODO Auto-generated method stub
		String fruitName = "Apple";
		String updatedValue = "6086";
		String fileName = "C:\\Users\\ctuser\\Downloads\\download.xlsx";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html"); // download
		driver.findElement(By.cssSelector("#downloadButton")).click(); // Edit excel - getColumnNumber of Price
																		// -getRownumber of APple-> update excel with
																		// row,col
		int col = getColumnNumber(fileName, "season");
		System.out.print("\n--col--\n");
		System.out.print(col);
		int row = getRowNumber(fileName, "Apple");
		System.out.print("\n--row--\n");
		System.out.print(row);

		Assert.assertTrue(updateCell(fileName, row, col, updatedValue)); // upload
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("C:\\Users\\ctuser\\Downloads\\download.xlsx"); // wait for success message to show up and wait
																		// for disappear
		By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		String toastText = driver.findElement(toastLocator).getText();
		System.out.println(toastText);
		Assert.assertEquals("Updated Excel Data Successfully.", toastText);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator)); // verify updated excel data showing
																					// in the web table
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='" + fruitName
				+ "']/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']")).getText();
		System.out.println(actualPrice);
		Assert.assertEquals(updatedValue, actualPrice);

		driver.quit();
	}

	private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException { // TODO
																													// Auto-generated
																													// method
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row rowField = sheet.getRow(row - 1);
		System.out.print("\n-----rowField-------\n");
		System.out.print(rowField);
		Cell cellField = rowField.getCell(col - 1);
		cellField.setCellValue(updatedValue);
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		workbook.close();
		fis.close();
		return true;
	}

	private static int getRowNumber(String fileName, String text) throws IOException { // TODO Auto-generated method
																						// stub
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1"); // Identify Testcases coloum by scanning the entire 1st row
		Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
//		System.out.print("\n--rows from getRowNumber number--\n");
//		System.out.print(rows);
		int k = 1;
		int rowIndex = -1;
		while (rows.hasNext()) {
			Row row = rows.next();
			System.out.print("\n--row!! from getRowNumber number--\n");
			System.out.print(row);
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				Cell cell = cells.next();
				System.out.print("\n--cell!! from getRowNumber number--\n");
				System.out.print(cell);
				if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(text)) {
					rowIndex = k;
				}

			}
			k++;
		}
		return rowIndex;
	}

	private static int getColumnNumber(String fileName, String colName) throws IOException { // TODO Auto-generated
																								// method stub
//		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1"); // Identify Testcases coloum by scanning the entire 1st row
		Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
		System.out.print("rows from get column number\n");
		System.out.print(rows);

		Row firstrow = rows.next();
		System.out.print("\nfirstrow from get column number\n");
		System.out.print(firstrow);
		Iterator<Cell> ce = firstrow.cellIterator(); // row is collection of cells
		System.out.print("\nce\n");
		System.out.print(ce);
		int k = 1;
		int coloumn = 0;
		while (ce.hasNext()) {
			Cell value = ce.next();
			System.out.print("\n--value.getStringCellValue()--\n");
			System.out.print(value.getStringCellValue());
			if (value.getStringCellValue().equalsIgnoreCase(colName)) {
				coloumn = k;
				System.out.print("\n--k--\n");
				System.out.print(k);
				System.out.print("\n--coloumn--\n");
				System.out.print(coloumn);
			}

			k++;
		}
		System.out.println(coloumn);

		return coloumn;
	}
}