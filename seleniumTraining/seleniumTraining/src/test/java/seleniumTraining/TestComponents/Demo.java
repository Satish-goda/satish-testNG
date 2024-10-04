package seleniumTraining.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo {

	public static ArrayList<String> getExcellData(String testCaseName) throws IOException {

		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fileInput = new FileInputStream("//home//ctuser//Downloads//data.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fileInput);
		int sheets = workBook.getNumberOfSheets();
		System.out.println(sheets);
		for (int i = 0; i < sheets; i++) {
			if (workBook.getSheetName(i).equalsIgnoreCase("testData")) {
				XSSFSheet sheet = workBook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
//				System.out.println("rows");
//				System.out.println(rows);
				Row firstRow = rows.next();
//				System.out.println("firstRow");
				System.out.println(firstRow);
				Iterator<Cell> ce = firstRow.cellIterator();
//				System.out.println("ce");
//				System.out.println(ce);
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
					}
					k++;
				}
				/// scan entire column once identified
				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType() == c.getCellType().STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}

		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(getExcellData("Add Profile"));

	}

}
