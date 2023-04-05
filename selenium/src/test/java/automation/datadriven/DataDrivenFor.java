package automation.datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenFor {
	public static void main(String[] args) throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\v-gokulsam\\Downloads\\WBA\\CredsWB.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet =	workbook.getSheet("credentials");
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(1).getLastCellNum();
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow rows = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = rows.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				default:
					System.out.print("No Matching Cell Type");
					break;
				}System.out.print("|");
			}System.out.println("");
		}
		
		workbook.close();
	}
}