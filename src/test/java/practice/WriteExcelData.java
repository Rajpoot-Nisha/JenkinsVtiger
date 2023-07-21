package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// nevigate to the file location where we need to write data
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData10to12.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet s1 = book.getSheet("Sheet1");
		Row row = s1.getRow(0);
	Cell cel = row.createCell(1);
	cel.setCellValue("iphone");
		
		// code for inserting data into excell file
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData10to12.xlsx");
		book.write(fos);
		System.out.println("Data added successfully....");
		book.close();
		
		
        
	}

}
