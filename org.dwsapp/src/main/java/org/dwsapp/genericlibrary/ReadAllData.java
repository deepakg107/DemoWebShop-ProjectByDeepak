package org.dwsapp.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllData implements ProjectConstant {

	public static void data() throws IOException
	{
	FileInputStream fis=new FileInputStream(excelPath);

	XSSFWorkbook book=new XSSFWorkbook(fis);

	XSSFSheet sheet=book.getSheet("TestData");

	int rows=sheet.getLastRowNum();
	int cells=sheet.getRow(1).getLastCellNum();

	for(int i=0;i<=rows;i++)
	{
		XSSFRow row=sheet.getRow(i);

		for(int j=0;j<cells;j++)
		{
			XSSFCell cell=row.getCell(j);

			switch (cell.getCellType())
			{
			case STRING: System.out.print(cell.getStringCellValue()); break;

			case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;

			case NUMERIC: System.out.print(cell.getNumericCellValue());	break;

			
			}
			System.out.print(" ");
			
		}
		System.out.println("");
		
	}
	
	System.out.println();
}
	public static void main(String[] args) throws IOException {
		data();
	}
}
