package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReader extends BaseClass {
	XSSFWorkbook workbook;

	public ExcelReader(String Filepath) throws IOException {
		File f = new File(Filepath);

		FileInputStream fis = new FileInputStream(f);

		workbook = new XSSFWorkbook(fis);

	}

	public int getAllRowCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getLastRowNum() +1;
	}

	public int getAllCellsCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	}

	public Object getSpecificData(int sheetindex, int row, int columns) {
		XSSFCell cell = workbook.getSheetAt(sheetindex).getRow(row).getCell(columns);

		if (cell == null) {
			return "";
		}
		if (cell != null) {
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cell.getRawValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cell.getBooleanCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
				return cell.getCellFormula();
			}
		}
		return null;
	}

	public Object[][] getAllSheetData(int sheetindex) {
		int row = getAllRowCount(sheetindex);
		int columns = getAllCellsCount(sheetindex);

		Object[][] data = new Object[row][columns];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < columns; j++) {
				data[i][j] = getSpecificData(sheetindex, row, columns);

			}
		}
		return data;
	}

}
