package Utils;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelFile {

  public static  FileInputStream inputStream;
  public static XSSFWorkbook workbook;
  public static  String [][] array ;


  public static int totalRowsMethod(String fileName, String SheetName)throws Exception {
      int totalRows = 0;

          inputStream = new FileInputStream(fileName);
          workbook = new XSSFWorkbook(inputStream);
          int row = workbook.getSheet(SheetName).getLastRowNum();
          if(row == 0){
               totalRows = 1;
          }
          else{
              totalRows = row ;
          }
          workbook.close();

      return totalRows;

  }
    public static int totalCellsMethod(String fileName, String SheetName)throws Exception {
        int totalCells = 0;

            inputStream = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(inputStream);
            int cell = workbook.getSheet(SheetName).getRow(0).getLastCellNum();
            totalCells = cell

            ;

            workbook.close();

        return totalCells;

    }




    public static String[][] getExcelData(String filepath, String sheetName)throws Exception{

            inputStream = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(inputStream);
            int totalRow = totalRowsMethod(filepath,sheetName);
            int totalCell = totalCellsMethod(filepath,sheetName);

            array = new String[totalRow][totalCell];

            for (int i = 1; i <= totalRow; i++) {
                for (int j = 0; j < totalCell; j++) {
                    array[i-1][j] = workbook.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
                }
            }
            workbook.close();


        return array;
    }


}
