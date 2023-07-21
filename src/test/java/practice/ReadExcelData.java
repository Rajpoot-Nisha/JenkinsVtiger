package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData10to12.xlsx"); 
		Workbook book = WorkbookFactory.create(fis);
		Sheet s1 = book.getSheet("Sheet1");
		Row row = s1.getRow(1);
        Cell cel = row.getCell(1);
        String data = cel.getStringCellValue();
        System.out.println(data);
	}

}
