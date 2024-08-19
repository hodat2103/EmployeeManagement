package com.example.demo.dto.export;

import com.example.demo.dto.EmployeeDto;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class EmployeeExcelExporter{
    private Workbook workbook;
    private Sheet sheet;
    private List<EmployeeDto> listEmployees;

    public EmployeeExcelExporter(List<EmployeeDto> listEmployees) {
        this.listEmployees = listEmployees;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Employees");
    }
    private void writeHeaderRow(){
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("Code");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Name");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Email");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("Phone");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("Age");
        cell.setCellStyle(style);


    }
    private void writeDataRow(){
        int rowCount = 1;
        for(EmployeeDto employeeDto : listEmployees){
            Row row = sheet.createRow(rowCount++);
            CellStyle style = workbook.createCellStyle();
            XSSFFont font = (XSSFFont) workbook.createFont();
            font.setFontHeight(14);
            style.setFont(font);

            Cell cell = row.createCell(0);
            cell.setCellValue(employeeDto.getCode());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(employeeDto.getName());
            sheet.autoSizeColumn(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(employeeDto.getEmail());
            sheet.autoSizeColumn(2);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(employeeDto.getPhone());
            sheet.autoSizeColumn(3);
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(employeeDto.getAge());
            sheet.autoSizeColumn(4);
            cell.setCellStyle(style);

        }
    }
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRow();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }
}
