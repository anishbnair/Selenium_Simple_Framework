package com.edureka.utility;

import java.io.File;
import java.io.FileInputStream;

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
		
				
		
	}

}
