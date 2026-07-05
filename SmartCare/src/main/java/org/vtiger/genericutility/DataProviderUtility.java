package org.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	@DataProvider (name = "dataproviderwithworkbook")
	public Object[][] dataproviderwithworkbook() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigertestdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("multipledatacampaign");
		
		int lastrownum = sheet.getLastRowNum();
		int physicalnumberofcells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] objarr = new Object[lastrownum][physicalnumberofcells];
		for (int i = 1; i <= lastrownum; i++) {
			
			 Row row = sheet.getRow(i);
			 for (int j = 0; j < physicalnumberofcells; j++) {
//		To keep the data in from the zeroth row we added the objarr[i-1] 		 
				 objarr[i-1][j] = row.getCell(j).getStringCellValue();
				
			}
			
		}
		wb.close();
		return objarr;
	}
	
	
	

}
