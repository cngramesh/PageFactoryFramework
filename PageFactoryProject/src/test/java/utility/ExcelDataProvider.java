package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() throws FileNotFoundException
	{
		
		File src = new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read the TestData excel file."+e.getMessage());
		}

	}

	public String getStringData(int sheetIndex,int Row, int Column)
	{
		return wb.getSheetAt(sheetIndex).getRow(Row).getCell(Column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int Row, int Column)
	{
		return wb.getSheet(sheetName).getRow(Row).getCell(Column).getStringCellValue();
	}
	
	
	public double getNumericData(String sheetName,int Row, int Column)
	{
		return wb.getSheet(sheetName).getRow(Row).getCell(Column).getNumericCellValue();
	}
	
	
	
}//End of Class	