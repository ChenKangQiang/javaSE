package edu.tongji.comm.excel;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-04-19
 */
public class SceneCityId {

    private static final List<String> cityIds = Lists.newArrayList();

    private static List<String> grades = Lists.newArrayList("S", "A", "B", "C");

    public static void main(String[] args) {
        read("src/main/resources/scene_cityId.xlsx");
        System.out.println(JSON.toJSONString(cityIds));
    }


    public static void read(String filePath) {
        InputStream inputStream = SceneCityId.class.getClassLoader().getResourceAsStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 2; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                try {
                    XSSFRow row = sheet.getRow(rowIndex);
                    XSSFCell dpCityId = row.getCell(0);
                    XSSFCell grade = row.getCell(3);
                    XSSFCell mtCityId = row.getCell(4);

                    if (grades.contains(grade.getStringCellValue())) {
                        int temp = (int) dpCityId.getNumericCellValue();
                        if (temp != 20) {
                            cityIds.add(String.valueOf(temp));
                        }
                    }

                } catch (Exception ex) {
                    continue;
                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
