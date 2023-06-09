package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ProjectDataProvider {
	
	
	@DataProvider(name="fetchData")
	public static Object[][] getData() throws IOException{
		
		FileInputStream fis = new FileInputStream("./testData/Facebook.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rc = sheet.getLastRowNum();
		System.out.println("Number of Rows -----"+rc);
		
		int cc = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of Columns ----"+cc);
		
		Object[][] testData = new Object[rc][cc];
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(int i=1; i<=rc; i++) {
			
			for(int j=0; j<cc; j++) {
				String header = sheet.getRow(0).getCell(j).getStringCellValue();
				CellType type = sheet.getRow(i).getCell(j).getCellType();
				Object value = null;
				if(type==CellType.STRING) {
					value = sheet.getRow(i).getCell(j).getStringCellValue();
				}else if(type==CellType.NUMERIC) {
					value = sheet.getRow(i).getCell(j).getNumericCellValue();
				}
				map.put(header, value);
				
			}
			testData[i-1][0]=map;
		}
		
		return testData;
	}

}
