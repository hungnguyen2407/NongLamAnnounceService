package vn.edu.hcmuaf.NongLamAnnounceService.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vn.edu.hcmuaf.NongLamAnnounceService.model.InformationUser;

public class ReadExcel {
	public static List<InformationUser> readUserExcel(String file) {
		List<InformationUser> listUser = new ArrayList<InformationUser>();
		try {
			// Đọc một file XSL.
			FileInputStream inputStream = new FileInputStream(new File(file));

			// Đối tượng workbook cho file XSL.
			Workbook workbook = new XSSFWorkbook(inputStream);

			// Lấy ra sheet đầu tiên từ workbook
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter fmt = new DataFormatter();

			// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// Lấy Iterator cho tất cả các cell của dòng hiện tại.
				Iterator<Cell> cellIterator = row.cellIterator();
				int x = 0;
				InformationUser user = new InformationUser();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Đổi thành getCellType() nếu sử dụng POI 4.x
					CellType cellType = cell.getCellTypeEnum();

					switch (cellType) {
					case _NONE:
						System.out.print("");
						System.out.print("\t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						System.out.print("\t");
						break;
					case BLANK:
						System.out.print("");
						System.out.print("\t");
						break;
					case FORMULA:

						// Công thức
						System.out.print(cell.getCellFormula());
						System.out.print("\t");

						FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

						// In ra giá trị từ công thức
						System.out.print(evaluator.evaluate(cell).getNumberValue());
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue());
						System.out.print("\t");
					case STRING:
						System.out.print(cell.getStringCellValue());
						System.out.print("\t");
						switch (x) {
						case 0:
							user.setId(cell.getStringCellValue());
							x++;
							break;
						case 1:
							user.setEmail(cell.getStringCellValue());
							x++;
							break;
						case 2:
							user.setfName(cell.getStringCellValue());
							x++;
							break;
						case 3:
							user.setlName(cell.getStringCellValue());
							x++;
							break;
						case 4:
							user.setBirthday(cell.getStringCellValue());
							x++;
							break;
						case 5:
							user.setFacultyID(cell.getStringCellValue());
							x++;
							break;
						case 6:
							user.setClassID(cell.getStringCellValue());
							x++;
							break;
						case 7:
							user.setPass(cell.getStringCellValue());
							x++;
							break;
						case 8:
							user.setLevel(Byte.valueOf(cell.getStringCellValue()));
							x++;
							break;
						default:
							break;
						}
						break;
					case ERROR:
						System.out.print("!");
						System.out.print("\t");
						break;
					}

				}
				System.out.println("");
				listUser.add(user);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;
	}
}
