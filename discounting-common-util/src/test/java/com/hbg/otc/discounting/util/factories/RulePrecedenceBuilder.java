package com.hbg.otc.discounting.util.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hbg.otc.discounting.model.RulePrecedence;


public class RulePrecedenceBuilder {
	private static final String FILE_NAME = "D:\\HBG_OTC_Discounting\\hbg-discounting\\discounting-common-util\\DefinePriority.xlsx";

	public static List<RulePrecedence> loadRulePrecedence() { 

		List<RulePrecedence> listRulePrecedence = new ArrayList<RulePrecedence>();
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);

			Iterator<Row> iterator = datatypeSheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				RulePrecedence rulePrecedence = new RulePrecedence();	
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				if (i==0) {
					i++;
					continue;
				}

				int j =0;
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if(j==0) {
						rulePrecedence.setRuleName(currentCell.getStringCellValue());
						j ++;
					} else if(j==1) {
						rulePrecedence.setPriority(currentCell.getStringCellValue());
					}

				}
				listRulePrecedence.add(rulePrecedence);
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listRulePrecedence;
	}
}