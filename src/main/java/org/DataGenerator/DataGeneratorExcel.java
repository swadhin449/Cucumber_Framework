package org.DataGenerator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class DataGeneratorExcel {
    String path=null;
    DataGeneratorExcel(String path){
        this.path = path;
    }
    public void readFromExcel(String sheetName) throws Exception{
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        if(sheet==null||sheet.getPhysicalNumberOfRows()==0){
            System.out.println("Sheet not found");
        }
        Row row = sheet.getRow(rowCount-1);
        int cellCount = 0;
        if(row!=null){
            cellCount = row.getPhysicalNumberOfCells();
        }



    }
}
