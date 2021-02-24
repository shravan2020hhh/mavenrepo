package excelOprations;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByIndex 
{

	
	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Desktop\\excel file 2.xlsx");
		FileOutputStream fos=null;
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row=null;
		XSSFCell cell=null;
		XSSFFont font = workbook.createFont();
		XSSFCellStyle style=workbook.createCellStyle();
		
		row=sheet.getRow(4);
		cell=row.getCell(4);
		
		font.setFontName("Algerian");
		font.setFontHeight(14.0);
		font.setBold(true);
	
		
		style.setFont(font);
		
		cell.setCellStyle(style);
		cell.setCellValue("STOP");
		
		
		fos=new FileOutputStream("C:\\Users\\HP\\Desktop\\excel file 2.xlsx");
		workbook.write(fos);
		fos.close();
	}

}
