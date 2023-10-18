package data;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excel_reader {
    private FileInputStream fileInputStream;

    public FileInputStream getFileInputStream() throws IOException {
        String filepath = System.getProperty("user.dir") + "/src/main/java/data/excelfile.xlsx";
        File src = new File(filepath);
        fileInputStream = new FileInputStream(src);
        return fileInputStream;
    }

    public Object[][] excelData() throws IOException {
        fileInputStream = getFileInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = 4;
        String[][] dataOfCells = new String[noOfRows][noOfColumns];

        for (int i = 0; i < noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < noOfColumns; j++) {
                if (row != null) {
                    XSSFCell cell = row.getCell(j);
                    if (cell != null) {
                        dataOfCells[i][j] = cell.toString();
                    } else {
                        dataOfCells[i][j] = ""; // Handle null cells
                    }
                } else {
                    dataOfCells[i][j] = ""; // Handle null rows
                }
            }
        }

        workbook.close();
        return dataOfCells;
    }
}