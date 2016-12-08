package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class VetsXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
    	Sheet sheet = workbook.createSheet("Spring");
    	Collection<Vet> vets = (Collection<Vet>) model.get("vetsCollection");
    	CellStyle highlight = workbook.createCellStyle();
    	highlight.cloneStyleFrom(sheet.getColumnStyle(0));
        highlight.setFillPattern(FillPatternType.SOLID_FOREGROUND );
        highlight.setFillForegroundColor(IndexedColors.RED.getIndex());
        int row = 0;
        for (Vet v : vets) {
        	Row courseRow = sheet.createRow(row);
        	Cell c1 = courseRow.createCell(0);
        	c1.setCellValue(v.getId());
        	courseRow.createCell(1).setCellValue(v.getFirstName());
        	courseRow.createCell(2).setCellValue(v.getLastName());
        	if (v.getNrOfSpecialties() > 1) {
               c1.setCellStyle(highlight);
            }
            row++;
        } 
	}
}
