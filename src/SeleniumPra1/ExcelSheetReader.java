package SeleniumPra1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReader {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		String filename=System.getProperty("user.dir")+"\\input.xlsx";
		System.out.println(filename);
		File fs=new File(filename);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		Row row=sheet.getRow(0);
		Cell cell=row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));

	}

}
