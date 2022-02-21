package modelncontactdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	public XSSFWorkbook Workbook = null;
	public Sheet sheet =null;
	public Cell cell = null;
	String cellValue =null;
	
	public String readexcelData( int rownum, int columnnum) throws IOException
	{
		File file = new File("D:\\excel\\Data.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		 Workbook = new XSSFWorkbook(inputStream);
		 sheet = Workbook.getSheet("sheet1");
		
		int row =sheet.getLastRowNum();
		int column = sheet.getRow(1).getLastCellNum();
		
		
			cell = sheet.getRow(rownum).getCell(columnnum);
			if (CellType.STRING.equals(cell.getCellType())) 
				cellValue= cell.getStringCellValue();
			return cellValue;		
	}
/*	public void WriteExcelData(String data, int rownum, int columnnum) throws IOException
	{

		XSSFWorkbook	Workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = Workbook.createSheet("Caremark");
		XSSFRow Row = sheet.createRow(rownum);
		XSSFCell cell = Row.createCell(columnnum);
		 		cell.setCellValue(data);
		 		
		 		FileOutputStream outstream = new FileOutputStream("D:\\\\excel\\result.xlsx");
		 		Workbook.write(outstream);
		 		outstream.close();
		 		System.out.println("successfully written");
		 		
	} */
	
	 public void WriteExcelData(String data, int rownum, int columnnum) throws EncryptedDocumentException, IOException 
	{
		
	
        FileInputStream inputStream = new FileInputStream("D:\\excel\\result.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(rownum);
                 
        Cell cell = row.createCell(columnnum);
        cell.setCellValue(data);
		
    inputStream.close();

    FileOutputStream outputStream = new FileOutputStream("D:\\excel\\result.xlsx");
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
     
} 
}