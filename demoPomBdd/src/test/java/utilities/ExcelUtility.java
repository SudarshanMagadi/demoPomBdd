package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
    static XSSFRow row;
	static XSSFCell cell;
	
	
	public static void loadExcelFile(String filePath,String sheetName ) throws IOException {
	// Open the file
	FileInputStream file=new FileInputStream(filePath);
    // Create Workbook instance
    workBook=new XSSFWorkbook(file);
    // Access the first sheet
    sheet=workBook.getSheet(sheetName);
	}
	
	public static String getCellData(int rowNumber, int colNumber) {
		 row=sheet.getRow(rowNumber);
		 cell=row.getCell(colNumber);
	     return cell.toString(); 
	}
	

}

