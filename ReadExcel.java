package week5.day2.assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] exceldata(String filename) throws IOException {
 
		XSSFWorkbook wb = new XSSFWorkbook("./Data\\"+filename+".xlsx");
		
		XSSFSheet sheet = wb.getSheet("sheet1");

		int rowcount = sheet.getLastRowNum();
		short cellcount = sheet.getRow(0).getLastCellNum();
		
		String [][] data = new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell = row.getCell(j);
		String stringCellValue = cell.getStringCellValue();
		data[i-1][j] = stringCellValue;
		//System.out.println(stringCellValue + " ");
			}
		}
				wb.close();
				return data;
			}
}
