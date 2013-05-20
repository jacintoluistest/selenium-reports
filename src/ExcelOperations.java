import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.model.RowBlocksReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static void readAllExcel(String sheet) {
		try {
			FileInputStream file = new FileInputStream(new File(
					ConfigurationHelper.getPropiedad("path")));
			XSSFWorkbook libroExcel = new XSSFWorkbook(file);
			XSSFSheet hoja = libroExcel.getSheet(ConfigurationHelper
					.getPropiedad(sheet));
			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = hoja.iterator();
			while (rowIterator.hasNext()) {

				// Itera en la fila
				Row fila = rowIterator.next();

				// Itera las celdas
				Iterator<Cell> celliterator = fila.cellIterator();
				while (celliterator.hasNext()) {

					Cell cell = celliterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					}
				}
				System.out.println("");
			}
			file.close();
			FileOutputStream out = new FileOutputStream(
					new File("C:\\test.xls"));
			libroExcel.write(out);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static ArrayList<Cell> getRow(String path, String sheet, int row) {
		ArrayList<Cell> celdasArray = new ArrayList<Cell>();
		int rowCounter = 0;
		try {
			FileInputStream file = new FileInputStream(new File(
					ConfigurationHelper.getPropiedad(path)));
			XSSFWorkbook libroExcel = new XSSFWorkbook(file);
			XSSFSheet hoja = libroExcel.getSheet(ConfigurationHelper
					.getPropiedad(sheet));
			// Iterate through each rows from first sheet

			// Iterator<Row> rowIterator = hoja.iterator();
			XSSFRow fila = hoja.getRow(row);
			Iterator<Cell> celliterator = fila.iterator();
			while (celliterator.hasNext()) {

				Cell celda = celliterator.next();
				System.out.println("RowCounter=" + rowCounter);
				celdasArray.add(rowCounter, celda);

				switch (celda.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:

					// System.out.print(celda.getBooleanCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_NUMERIC:

					// System.out.print(celda.getNumericCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_STRING:
					// System.out.print(celda.getStringCellValue() + "\t\t");
					break;

				}
				rowCounter++;

			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return celdasArray;

	}

	public void getNameColumns(String path, String sheet) {

		try {
			FileInputStream file = new FileInputStream(new File(
					ConfigurationHelper.getPropiedad(path)));
			XSSFWorkbook libroExcel = new XSSFWorkbook(file);
			XSSFSheet hoja = libroExcel.getSheet(ConfigurationHelper
					.getPropiedad(sheet));
			// Iterate through each rows from first sheet

			// Iterator<Row> rowIterator = hoja.iterator();
			XSSFRow fila = hoja.getRow(0);
			Iterator<Cell> celliterator = fila.iterator();

			while (celliterator.hasNext()) {
				Cell celda = celliterator.next();

				switch (celda.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(celda.getBooleanCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(celda.getNumericCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.print(celda.getStringCellValue() + "\t\t");
					break;
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void setCell(ArrayList<Cell> fila, String path, String sheet,
			Cell celda, int rowIndex, int cellIndex) {

		try {
			FileInputStream file = new FileInputStream(new File(
					ConfigurationHelper.getPropiedad(path)));
			XSSFWorkbook libroExcel = new XSSFWorkbook(file);
			XSSFSheet hoja = libroExcel.getSheet(ConfigurationHelper
					.getPropiedad(sheet));
			
			XSSFRow filatoUpdate = hoja.getRow(rowIndex);
			XSSFCell celltoUpdate = filatoUpdate.getCell(cellIndex);

			switch (celltoUpdate.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				celltoUpdate.setCellValue(fila.get(cellIndex).getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				celltoUpdate.setCellValue(fila.get(cellIndex).getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				celltoUpdate.setCellValue(fila.get(cellIndex).getStringCellValue());
				break;
			
			}
			
			System.out.println("Terminé");
			
			
			file.close();
			System.out.println(ConfigurationHelper.getPropiedad(path));
			FileOutputStream out = new FileOutputStream(
			new File(ConfigurationHelper.getPropiedad(path)));
			libroExcel.write(out);
			out.close();
			

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
