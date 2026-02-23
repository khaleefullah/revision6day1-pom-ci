package dataprovider;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import utils.ExcelReader;
import java.util.Hashtable;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		Path excelPath = Paths.get(System.getProperty("user.dir"),"src","test","resources","excel","testdata.xlsx");
		ExcelReader excel = new ExcelReader(excelPath.toString());

		String sheetName = m.getName();
		int totalRows = excel.getRowCount(sheetName);
		int totalColumns = excel.getColumnCount(sheetName);

		Object[][] data = new Object[totalRows - 1][1];
		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= totalRows; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < totalColumns; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}
}
