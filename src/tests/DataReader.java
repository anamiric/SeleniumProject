package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String value;

	public DataReader(String filePath) throws IOException {

		this.file = new File(filePath);
		this.fis = new FileInputStream(file);
		this.wb = new XSSFWorkbook(fis);
	}

	public String getData(String sheetName, int columnNumber, int rowNumber) {

		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber - 1);
		cell = row.getCell(columnNumber - 1);
		if (cell.getCellType() == CellType.NUMERIC) {
			value = String.valueOf((int) cell.getNumericCellValue());
		} else {
			value = cell.getStringCellValue();
		}
		return value;
	}

	public int getNumberData(String sheetName, int columnNumber, int rowNumber) {

		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber - 1);
		cell = row.getCell(columnNumber - 1);
		return (int) cell.getNumericCellValue();
	}

}
