package generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	
	public String  getExcelDdataUsingData(String sheetName ,int rowNum,int celNum) throws EncryptedDocumentException, IOException
	{
		
		
		 FileInputStream fisExcel = new FileInputStream("src/test/resources/TestData10to12.xlsx");
         Workbook book = WorkbookFactory.create(fisExcel);
         Sheet sh = book.getSheet(sheetName);
         Row rw = sh.getRow(rowNum);
         Cell cel =  rw.getCell(celNum);
         // fetch the data from file
         String orgData = cel.getStringCellValue();
		return orgData;
	}
	
	public String  getExcelDdataUsingDataformater(String sheetName ,int rowNum,int celNum) throws EncryptedDocumentException, IOException
	{
		
		
		 FileInputStream fisExcel = new FileInputStream("src/test/resources/TestData10to12.xlsx");
         Workbook book = WorkbookFactory.create(fisExcel);
        DataFormatter formate = new DataFormatter();
        String value = formate.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(celNum));
		return value;
	}
}


