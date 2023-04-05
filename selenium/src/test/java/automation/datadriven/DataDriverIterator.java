package automation.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriverIterator {
	public static void main(String[] args) throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\v-gokulsam\\Downloads\\WBA\\CredsWB.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet =	workbook.getSheet("credentials");
		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cellItr = row.cellIterator();
			while (cellItr.hasNext()) {
				Cell cell = cellItr.next();
				CellType cType = cell.getCellType();
				switch(cType) {
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
