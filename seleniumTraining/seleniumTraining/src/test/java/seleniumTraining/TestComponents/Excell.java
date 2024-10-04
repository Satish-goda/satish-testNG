package seleniumTraining.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excell {

	public static void getFIleData() throws IOException { 
	FileInputStream fis = new FileInputStream("C:\\Users\\ctuser\\Downloads\\download.xlsx"); 
	XSSFWorkbook  wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet("Sheet1");
	Iterator<Row> rows = sheet.iterator();
	Row firstRow = rows.next();
	Row secondRow = firstRow;

	
	System.out.println(firstRow);
	
	}
	
	public static void main(String[] args) throws IOException {
		
		getFIleData();
		
	}
	
}
