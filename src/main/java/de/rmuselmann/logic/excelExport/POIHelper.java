package de.rmuselmann.logic.excelExport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class POIHelper {

	public static Row getRow(Sheet sheet, int index) {
		Row row = sheet.getRow(index);
		if (row == null) {
			row = sheet.createRow(index);
		}
		return row;
	}

	public static Cell getCell(Row row, int index) {
		Cell cell = row.getCell(index);
		if (cell == null) {
			cell = row.createCell(index);
		}
		return cell;
	}
}
