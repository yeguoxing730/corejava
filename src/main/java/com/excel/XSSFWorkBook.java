package com.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;

public class XSSFWorkBook {
    public static void main(String[] args){
        String filePath = "D:\\pos1.xlsx";
        List<String> result=  readExcelByFileForXlsx(new File(filePath),0,0,1);
        System.out.println(result);
    }
    /*读取xlsx文件*/
    public static List<String> readExcelByFileForXlsx(File file, int startrow, int startcol, int sheetnum) {
        List<String> varList = new ArrayList<String>();
        try {
            //File target = new File(filepath, filename);
            //File target = new File(file);
            FileInputStream fi = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fi);//xslx
            XSSFSheet sheet= wb.getSheetAt(sheetnum); //sheet 从0开始
            int rowNum = sheet.getLastRowNum() + 1;                     //取得最后一行的行号

            for (int i = startrow; i < rowNum; i++) {                    //行循环开始

                StringBuilder varpd = new StringBuilder();
                XSSFRow row = sheet.getRow(i);                             //行
                int cellNum = row.getLastCellNum();                     //每行的最后一个单元格位置

                for (int j = startcol; j < cellNum; j++) {                //列循环开始

                    XSSFCell cell = row.getCell(Short.parseShort(j + ""));
                    String cellValue = null;
                    if (null != cell) {
                        switch (cell.getCellType()) {                     // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
                            case 0:
                                cellValue = String.valueOf((int) cell.getNumericCellValue());
                                break;
                            case 1:
                                cellValue = cell.getStringCellValue();
                                break;
                            case 2:
                                cellValue = cell.getNumericCellValue() + "";
                                // cellValue = String.valueOf(cell.getDateCellValue());
                                break;
                            case 3:
                                cellValue = "";
                                break;
                            case 4:
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case 5:
                                cellValue = String.valueOf(cell.getErrorCellValue());
                                break;
                        }
                    } else {
                        cellValue = "";
                    }
                    System.out.println("var"+j+ cellValue);
                    varpd.append(cellValue);

                }
                varList.add(varpd.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return varList;
    }
}
