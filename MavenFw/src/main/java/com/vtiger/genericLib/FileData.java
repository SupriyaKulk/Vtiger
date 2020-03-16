package com.vtiger.genericLib;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileData{
	
	
		public String FetchDataFromProperty(String key) throws IOException
		{
			FileInputStream file= new FileInputStream("F:\\TestData\\CommonData.properties");
			Properties pobj=new Properties();
			pobj.load(file);
			String value=pobj.getProperty(key);
			return value;
			
		}
		
		public String fetchDatafromExcel(String sheetname, int rownum,int cellnum) throws IOException
		{
			FileInputStream file=new FileInputStream("F:\\TestData\\TestcaseData.xlsx");
			Workbook book=WorkbookFactory.create(file);
			Sheet sh=book.getSheet(sheetname);
			Row row=sh.getRow(rownum);
			Cell cell=row.getCell(cellnum);
			String value=cell.getStringCellValue();
			return value;
			
		}

		
	}



