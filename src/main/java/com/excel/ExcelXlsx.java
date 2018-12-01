package com.excel;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelXlsx {

    /**
     * Uses the XSSF Event SAX helpers to do most of the work
     * of parsing the Sheet XML, and outputs the contents
     * as a (basic) CSV.
     */
    private static class SheetToCSV implements XSSFSheetXMLHandler.SheetContentsHandler {
        private boolean firstCellOfRow = false;
        private int currentRow = -1;
        private int currentCol = -1;

        private StringBuffer lineBuffer = new StringBuffer();

        /**
         * Destination for data
         */
        private FileOutputStream outputStream;

        public SheetToCSV(FileOutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void startRow(int rowNum) {
            /**
             * If there were gaps, output the missing rows:
             *  outputMissingRows(rowNum - currentRow - 1);
             */
            // Prepare for this row
            firstCellOfRow = true;
            currentRow = rowNum;
            currentCol = -1;

            lineBuffer.delete(0, lineBuffer.length());  //clear lineBuffer
        }

        @Override
        public void endRow(int rowNum) {
            lineBuffer.append('\n');
            try {
                outputStream.write(lineBuffer.substring(0).getBytes());
            } catch (IOException e) {
                throw new RuntimeException("save date to file error at row number: " + currentCol);
            }
        }

        @Override
        public void cell(String cellReference, String formattedValue, XSSFComment comment) {
            if (firstCellOfRow) {
                firstCellOfRow = false;
            } else {
                lineBuffer.append(',');
            }

            // gracefully handle missing CellRef here in a similar way as XSSFCell does
            if (cellReference == null) {
                cellReference = new CellAddress(currentRow, currentCol).formatAsString();
            }

            int thisCol = (new CellReference(cellReference)).getCol();
            //空缺单元格的个数，合并单元格和没有内容的单元格都算是丢失的col
            int missedCols = thisCol - currentCol - 1;
            if (missedCols > 1) {   //合并单元格的地方，不打印逗号
                lineBuffer.append(',');
            }
            currentCol = thisCol;
            if (formattedValue.contains("\n")) {    //去除换行符
                formattedValue = formattedValue.replace("\n", "");
            }
            formattedValue = "\"" + formattedValue + "\"";  //有些excel文档 2300的数值为2,300
            lineBuffer.append(formattedValue);
        }

        @Override
        public void headerFooter(String text, boolean isHeader, String tagName) {
            // Skip, no headers or footers in CSV
        }
    }
    private static void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings,
                                     XSSFSheetXMLHandler.SheetContentsHandler sheetHandler, InputStream sheetInputStream) throws Exception {
        DataFormatter formatter = new DataFormatter();
        InputSource sheetSource = new InputSource(sheetInputStream);
        try {
            XMLReader sheetParser = SAXHelper.newXMLReader();
            ContentHandler handler = new XSSFSheetXMLHandler(
                    styles, null, strings, sheetHandler, formatter, false);
            sheetParser.setContentHandler(handler);
            sheetParser.parse(sheetSource);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }
    public static void process(String srcFile, String destFile) throws Exception {
        File xlsxFile = new File(srcFile);
        OPCPackage xlsxPackage = OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ);
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(xlsxPackage);
        XSSFReader xssfReader = new XSSFReader(xlsxPackage);
        StylesTable styles = xssfReader.getStylesTable();
        XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
        int index = 0;
        while (iter.hasNext()) {
            InputStream stream = iter.next();
            String sheetName = iter.getSheetName();
            System.out.println(sheetName + " [index=" + index + "]");
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            processSheet(styles, strings, new SheetToCSV(fileOutputStream), stream);
            stream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            ++index;
        }
        xlsxPackage.close();
    }

    public static void main(String[] args) throws Exception {
        ExcelXlsx.process("D:\\pos1.xlsx", "D:\\test-1.csv");
    }
}
