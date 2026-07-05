package org.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
/**
 * This method will fetch the data from properties file
 * @param key
 * @return
 * @throws IOException 
 */

	public String readDataFromPropertiesFile(String key) throws IOException 
	{
		//create object for FileInputStream class and pass the properties file path
		FileInputStream pfis= new FileInputStream("./src/test/resources/commonproperties.properties");
		
//		create object of File Type (properties file)
		Properties prop = new Properties();
		
//		load the data in  to test script
		prop.load(pfis);
		
//		fetch the data from properties file
		 String value = prop.getProperty(key);
		 
		 return value;
		 
    }
	/**
	 * This method will fetch the data from Excel file
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @return 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	
	public String readDatafromExcelFile(String SheetName,int RowNum,int CellNum) throws EncryptedDocumentException, IOException
	{
//		create object of FileInputStream class and pass the excel file path
		FileInputStream efis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		
//		Open the excel File
	    Workbook wb = WorkbookFactory.create(efis);
	    
//	    traverse to sheet
	    String value = wb.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
	    
	    return value;
		
	}
}
