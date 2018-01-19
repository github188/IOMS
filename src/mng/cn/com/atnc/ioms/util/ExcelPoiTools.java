/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-28 下午3:48:40
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.util.StringTools;

/**
 * @author:HuangYijie
 * @date:2014-3-28 下午3:48:40
 * @version:1.0
 */

public class ExcelPoiTools {

	public static Vector<Vector<String>> readFile(String fileName, int columnNum)
			throws FileNotFoundException, IOException, InvalidFormatException {

		if (!StringTools.hasText(fileName)) {
			return null;
		}
		Vector<Vector<String>> resultVec = new Vector<Vector<String>>();
		// office2007工作区
		Workbook wb = ExcelPoiTools.create(new FileInputStream(fileName));
		// 获得该工作区的第一个sheet
		Sheet sheet = wb.getSheetAt(0);
		// 总共有多少行,从0开始
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			// 取得该行
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			Vector<String> rowVec = new Vector<String>();
			for (int j = 0; j < columnNum; j++) {
				if (row.getCell(j) == null) {
					rowVec.add(" ");
					continue;
				}
				switch (row.getCell(j).getCellType()) {
				case Cell.CELL_TYPE_STRING:
					String cellValue = row.getCell(j).getStringCellValue();
					if (StringTools.hasText(cellValue)) {
						rowVec.add(cellValue);
					} else {
						rowVec.add(" ");
					}
					break;
				case Cell.CELL_TYPE_NUMERIC:
					// 单元格为整数，读取后变成1.0，删除.0
					Double num = row.getCell(j).getNumericCellValue();
					if ((num + "").endsWith(".0")) {
						rowVec.add(num.intValue() + "");
					} else {
						rowVec.add(num + "");
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					rowVec.add(row.getCell(j).getBooleanCellValue() + "");
					break;
				case Cell.CELL_TYPE_BLANK:
				case Cell.CELL_TYPE_ERROR:
				case Cell.CELL_TYPE_FORMULA:
					rowVec.add("");
					break;
				default:
					break;
				}

			}

			if (!CollectionUtils.isEmpty(rowVec)) {
				resultVec.add(rowVec);
			}
		}
		return resultVec;
	}
//slot导入
	public static Vector<Vector<String>> readFile2(String fileName, int columnNum)
			throws FileNotFoundException, IOException, InvalidFormatException {

		if (!StringTools.hasText(fileName)) {
			return null;
		}
		Vector<Vector<String>> resultVec = new Vector<Vector<String>>();
		// office2007工作区
		Workbook wb = ExcelPoiTools.create(new FileInputStream(fileName));
		// 获得该工作区的第二个sheet
		Sheet sheet = wb.getSheetAt(1);
		// 总共有多少行,从0开始
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			// 取得该行
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			Vector<String> rowVec = new Vector<String>();
			for (int j = 0; j < columnNum; j++) {
				if (row.getCell(j) == null) {
					rowVec.add(" ");
					continue;
				}
				switch (row.getCell(j).getCellType()) {
				case Cell.CELL_TYPE_STRING:
					String cellValue = row.getCell(j).getStringCellValue();
					if (StringTools.hasText(cellValue)) {
						rowVec.add(cellValue);
					} else {
						rowVec.add(" ");
					}
					break;
				case Cell.CELL_TYPE_NUMERIC:
					// 单元格为整数，读取后变成1.0，删除.0
					Double num = row.getCell(j).getNumericCellValue();
					if ((num + "").endsWith(".0")) {
						rowVec.add(num.intValue() + "");
					} else {
						rowVec.add(num + "");
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					rowVec.add(row.getCell(j).getBooleanCellValue() + "");
					break;
				case Cell.CELL_TYPE_BLANK:
				case Cell.CELL_TYPE_ERROR:
				case Cell.CELL_TYPE_FORMULA:
					rowVec.add("");
					break;
				default:
					break;
				}

			}

			if (!CollectionUtils.isEmpty(rowVec)) {
				resultVec.add(rowVec);
			}
		}
		return resultVec;
	}
	
	public static List<List<String>> readFile2List(String fileName,
			int columnNum) throws FileNotFoundException, IOException,
			InvalidFormatException {

		if (!StringTools.hasText(fileName)) {
			return null;
		}
		List<List<String>> resultVec = new ArrayList<>();
		// office2007工作区
		Workbook wb = ExcelPoiTools.create(new FileInputStream(fileName));
		// 获得该工作区的第一个sheet
		Sheet sheet = wb.getSheetAt(0);
		// 总共有多少行,从0开始
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			// 取得该行
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<String> rowVec = new ArrayList<String>();
			for (int j = 0; j < columnNum; j++) {
				if (row.getCell(j) == null) {
					rowVec.add(" ");
					continue;
				}
				switch (row.getCell(j).getCellType()) {
				case Cell.CELL_TYPE_STRING:
					String cellValue = row.getCell(j).getStringCellValue();
					if (StringTools.hasText(cellValue)) {
						rowVec.add(cellValue);
					} else {
						rowVec.add(" ");
					}
					break;
				case Cell.CELL_TYPE_NUMERIC:
					Double num = row.getCell(j).getNumericCellValue();
					if ((num + "").endsWith(".0")) {
						rowVec.add(num.intValue() + "");
					} else {
						rowVec.add(num + "");
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					rowVec.add(row.getCell(j).getBooleanCellValue() + "");
					break;
				case Cell.CELL_TYPE_BLANK:
				case Cell.CELL_TYPE_ERROR:
				case Cell.CELL_TYPE_FORMULA:
					rowVec.add(" ");
					break;
				default:
					rowVec.add(" ");
					break;
				}

			}

			if (!CollectionUtils.isEmpty(rowVec)) {
				resultVec.add(rowVec);
			}
		}
		return resultVec;
	}

	public static Workbook create(InputStream inp) throws IOException,
			InvalidFormatException {
		if (!inp.markSupported()) {
			inp = new PushbackInputStream(inp, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(inp)) {
			return new HSSFWorkbook(inp);
		}
		if (POIXMLDocument.hasOOXMLHeader(inp)) {
			return new XSSFWorkbook(OPCPackage.open(inp));
		}
		throw new IllegalArgumentException("对不起，无法解析此Excel版本！");
	}

}
