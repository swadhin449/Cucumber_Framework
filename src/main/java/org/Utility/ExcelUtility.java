package org.Utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

/*
Agenda:
1. Create Utility method that return list of hashmap
- Count Number of Columns
- Read Excel file headers and add to list of Collection
- Iterate through all the rows and increase column count
2. Creating multiple selenium webdriver testng testcases
- Create utility methods that return browser instances
Eg: test1 <--- TestCase1 test data from Excel...
    test2 <--- TestCase2 test data from Excel...

 */
public class ExcelUtility {
    public static List<Map<String,String>> getTestDataInMap(){
        List<Map<String,String>> testDataAllRows = null;
        Map<String, String> testData = null;
        try{
            FileInputStream file = new FileInputStream("path");
            Workbook wb = new XSSFWorkbook(file);
            Sheet sheet = wb.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();

            List list = new ArrayList();
            for(int i=0;i<lastColNum;i++){
                Row row = sheet.getRow(0);
                Cell cell = row.getCell(i);
                String rowHeader = cell.getStringCellValue().trim();

                list.add(rowHeader);
            }
            testDataAllRows = new ArrayList<Map<String,String>>();
            for(int j=1;j<=lastRowNum;j++){
                Row row = sheet.getRow(j);
                testData = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
                for(int k=0;k<lastColNum;k++) {
                    Cell cell = row.getCell(k);
                    String colValue = cell.getStringCellValue().trim();
                    testData.put((String) list.get(k), colValue);
                }
                testDataAllRows.add(testData);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return testDataAllRows;
    }
}