import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;


public class TestExcel {

	
	public static void main(String[] args) {
//		ArrayList<Cell> rowValues=	ExcelOperations.getRow("path","testSheet",0);
//		System.out.println("Longitud="+rowValues.size());
//		for(int a=0; a< rowValues.size();a++){
//			System.out.println("El valor de la columna ="+a+"es:" +rowValues.get(a).toString());
//		}
		
			//testSetRow(4,"Ljacino");
			System.out.println(ExcelOperations.getNumRows("path", "testSheet"));
		}
	
	public static void testSetRow(int rowIndex,String value){
		ArrayList<Cell> fila = new ArrayList<Cell>();
		fila=ExcelOperations.getRow("path","testSheet",rowIndex);
		Cell celda = fila.get(3);
		celda.setCellValue(value);
		ExcelOperations.setCell(fila, "path", "testSheet", celda,3,3);
		ExcelOperations.getRow("path", "testSheet", 4);
		
	}
	
	

}
