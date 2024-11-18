package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.Framework.Automation_Framework.Basepage;

public class ReadExcelData  {
	

	
	
	public static String [][] readData(String fileName) throws IOException{
		
		//identify workbooks
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		//identify worksheets
		XSSFSheet ws= wb.getSheet("Sheet1");
		
		// to get no of rows
		int rowcount=ws.getLastRowNum();
		System.out.println("row count: "+rowcount);
		
		// to get no of cells n row
		int cellcount=ws.getRow(0).getLastCellNum();
		System.out.println(cellcount);
		
		//declare 2D array
		
		String[][] data= new String[rowcount][cellcount];
		
		for (int i = 1; i <=rowcount; i++) { //traverse throuh row
			for (int j = 0; j < cellcount; j++) { //0,1,2				
				String cellValue=ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=cellValue;
				System.out.println(cellValue);
				
			}
			
		}
		wb.close();
		return data;
		
	}

}
