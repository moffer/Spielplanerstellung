package de.rmuselmann.logic.excelExport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import de.rmuselmann.logic.general.Person;
import de.rmuselmann.logic.match.Match;
import de.rmuselmann.logic.team.Team;

public class ExportTeams {

	private CellStyle dateCellStyle;
	private CellStyle boldFontStyle;

	public void export(File file, List<Team> teams, List<Match> matches) throws IOException {

		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook();

		boldFontStyle = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		boldFontStyle.setFont(boldFont);
		HSSFCreationHelper createHelper = workbook.getCreationHelper();
		dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("hh:mm"));

		createTeamSheet(teams, workbook);
		createMatchesSheet(matches, workbook);

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	private void createMatchesSheet(List<Match> matches, HSSFWorkbook workbook) {
		Sheet matchSheet = workbook.createSheet("Spielplan");

		Row headRow = POIHelper.getRow(matchSheet, 0);
		Cell headCell = POIHelper.getCell(headRow, 0);
		headCell.setCellValue("Spiele");

		int currentRow = 2;

		Collections.sort(matches, new MatchesComparator());

		for (Match match : matches) {
			Row matchRow = POIHelper.getRow(matchSheet, currentRow);

			Cell dateCell = POIHelper.getCell(matchRow, 0);
			dateCell.setCellValue(match.getDate());
			dateCell.setCellStyle(dateCellStyle);

			Cell teamACell = POIHelper.getCell(matchRow, 1);
			teamACell.setCellValue(match.getTeamA().getTeamName());

			Cell teamBCell = POIHelper.getCell(matchRow, 2);
			teamBCell.setCellValue(match.getTeamB().getTeamName());
			currentRow++;
		}
	}

	private void createTeamSheet(List<Team> teams, HSSFWorkbook workbook) {
		// Get first sheet from the workbook
		Sheet teamSheet = workbook.createSheet("Teams");

		Row headRow = POIHelper.getRow(teamSheet, 0);
		Cell headCell = POIHelper.getCell(headRow, 0);
		headCell.setCellValue("Teams");

		int currentRow = 2;
		for (Team team : teams) {
			Row row = POIHelper.getRow(teamSheet, currentRow);
			Cell teamCell = POIHelper.getCell(row, 0);
			teamCell.setCellValue("Team:");
			teamCell.setCellStyle(boldFontStyle);
			POIHelper.getCell(row, 1).setCellValue(team.getTeamName());

			Row headlineRow = POIHelper.getRow(teamSheet, ++currentRow);
			Cell headCellOne = POIHelper.getCell(headlineRow, 0);
			headCellOne.setCellValue("Mitgliedsname");
			headCellOne.setCellStyle(boldFontStyle);

			Cell headCellTwo = POIHelper.getCell(headlineRow, 1);
			headCellTwo.setCellValue("Altersklasse");
			headCellOne.setCellStyle(boldFontStyle);

			for (Person person : team.getMembers()) {
				currentRow++;
				POIHelper.getCell(POIHelper.getRow(teamSheet, currentRow), 0).setCellValue(person.getName());
				POIHelper.getCell(POIHelper.getRow(teamSheet, currentRow), 1).setCellValue(person.getAge().getName());
			}
			currentRow += 2;
		}
	}

	private class MatchesComparator implements Comparator<Match> {

		@Override
		public int compare(Match o1, Match o2) {
			return o1.getDate().compareTo(o2.getDate());
		}

	}
}
