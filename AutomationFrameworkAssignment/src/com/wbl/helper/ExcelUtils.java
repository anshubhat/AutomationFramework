package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

public class ExcelUtils {
	private static Logger logger=Logger.getLogger(ExcelUtils.class);
	
	static String LOCATION=System.getProperty("user.dir")+"\\resources\\";
	public Object[][] getExcelData(String sheetName, String FileName){
		
		Object[][] data=null;
		if (logger.isDebugEnabled()){
		logger.debug("In excel data reading");
		}
		try {
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(LOCATION + "data\\"+filename));
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		int noOfRows = sheet.getLastRowNum();
		
		data = new Object[noOfRows][];
		Row row=null;
		for (int i=1; i<=noOfRows; i++){
			row = sheet.getRow(i);
			
			int noOfcolumns = row.getLastCellNum();
			
			String[] strData= new String[noOfcolumns];
		
			for (int j=0; j<=noOfcolumns; j++){
				strData[j]=row.getCell(j).getStringCellValue();
			}
			
			data[i-1]= strData;
			
		}
		} catch (FileNotFoundException e) {
			 logger.error("File Not found-Please give correct file detail");
		 }
		 catch (IOException e) {
			// TODO Auto-generated catch block
			 logger.error("Issue reading the given config properties file");
		 }	
			
			 
		return data;
	}

}
