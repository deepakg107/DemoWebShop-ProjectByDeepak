package org.dwsapp.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary implements ProjectConstant{

	
	public FileInputStream fis;
	
	public FileOutputStream fos;
	
	Workbook book;
	
	public String readData(String sheetname, int rownum, int columnnum)
	{
		try {
			fis=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			book=WorkbookFactory.create(fis);
		} catch (IOException|EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return book.getSheet(sheetname).getRow(rownum).getCell(columnnum).getStringCellValue();
		
	}
}
