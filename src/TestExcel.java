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
		
			testSetRow();
		}
	
	public static void testSetRow(){
		ArrayList<Cell> fila = new ArrayList<Cell>();
		fila=ExcelOperations.getRow("path","testSheet",4);
		Cell celda = fila.get(3);
		celda.setCellValue("Test");
		ExcelOperations.setCell(fila, "path", "testSheet", celda,3,3);
		ExcelOperations.getRow("path", "testSheet", 4);
		
	}

}
