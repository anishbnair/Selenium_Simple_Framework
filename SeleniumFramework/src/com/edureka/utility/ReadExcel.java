package com.edureka.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] getData(String filename,String sheetname) throws Exception {
		
		File file = new File(filename);
		FileInputStream fin = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook();
		Sheet sh = wb.getSheet(sheetname);
		int rowNum = sh.getLastRowNum();
		int colNum = sh.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowNum][colNum];
		
		for(int i = 0; i < rowNum; i++) {
			Row row = sh.getRow(i);
			for(int j = 0; j < colNum; j++) {
				Cell cell = row.getCell(j);
				String value = new DataFormatter().formatCellValue(cell);
				data[i][j] = value;				
			}
		}	
		return data;
	}
	
}
