package automation.datadriven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WriteDataPOI {

	public static void main(String[] args)  {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("SheetOne");

		Object[][] data = {{"Name","Location","Age"},
				{"Gokul","Chennai",23},
				{"Edison","Hosur",24}};

	

		int rowSize = data.length;
		int colSize = data[0].length;

		for (int i = 0; i < rowSize; i++) {
			XSSFRow row = sheet.createRow(i);
			for (int j = 0; j < colSize; j++) {
				XSSFCell cell = row.createCell(j);
				Object cellValue=data[i][j];

				if(cellValue instanceof String) {
					cell.setCellValue((String)cellValue);
				}
				else if(cellValue instanceof Integer) {
					cell.setCellValue((Integer)cellValue);
				}
				else if(cellValue instanceof Boolean) {
					cell.setCellValue((Boolean)cellValue);
				}
			}

		}
		File file = new File("C:\\Users\\v-gokulsam\\Downloads\\WBA\\new.xlsx");
		FileOutputStream result;
		try {
			result = new FileOutputStream(file);
			workbook.write(result);
			workbook.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Completed");
	}


}
