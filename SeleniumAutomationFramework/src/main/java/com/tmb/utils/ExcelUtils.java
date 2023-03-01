package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstant;

public final class ExcelUtils {

	private ExcelUtils() {
	}

	public static List<Map<String, String>> getTestDetails(String sheetname) {
		List<Map<String, String>> list = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(FrameworkConstant.getExcelpath());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);

			XSSFSheet sheet = workbook.getSheet(sheetname);
			int lastrownum = sheet.getLastRowNum();
			int lastcolumnnum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list = new ArrayList<>();

			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap<>();

				for (int j = 0; j < lastcolumnnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					System.out.println("Key : "+key);
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println("value : "+value);
					map.put(key, value);
				}
				list.add(map);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (Objects.nonNull(fs)) {
					fs.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}

		}
		return list;
	}

}
