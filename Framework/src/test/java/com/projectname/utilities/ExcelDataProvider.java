package com.projectname.utilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		try {
			FileInputStream fis= new FileInputStream("TestData/SampleExcelFile.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file" + e.getMessage());
		}
	}
	
	public String getStringData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	public double getIntData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
