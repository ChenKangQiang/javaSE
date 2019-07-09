package edu.tongji.comm.example.poi;

import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author chenkangqiang
 * @date 2017/9/15
 * <p>
 * 利用POI读取Excel文档
 */
public class POITest {

    private static final String FILEPATH = "src/main/resources/user.xlsx";

    private static final Map<String, String> MAP = Maps.newHashMap();

    /**
     * 静态加载资源文件
     */
    static {
        try {
            InputStream inputStream = POITest.class.getClassLoader().getResourceAsStream(FILEPATH);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            int sheetNum = workbook.getNumberOfSheets();
            //System.out.println(sheetNum);
            //for循环遍历单元格内容
            for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
                //根据下标获取sheet
                XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
                //workbook.getSheetName(sheetIndex) 根据下标获取sheet 名称
                System.out.println("sheet序号：" + sheetIndex + "，sheet名称：" + workbook.getSheetName(sheetIndex));
                //循环该sheet页中的有数据的每一行
                //打印行数
                System.out.println(sheet.getPhysicalNumberOfRows());
                //遍历每行内容从行号为0开始
                for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                    //System.out.println(rowIndex);打印遍历行号
                    //根据行号，遍历该行
                    XSSFRow row = sheet.getRow(rowIndex);
                    //如果该行为空，则结束本次循环
                    if (row == null) {
                        continue;
                    }

                    XSSFCell key = row.getCell(0);
                    XSSFCell value = row.getCell(1);
                    if (key != null && value !=null) {
                        MAP.put(key.toString(), value.toString());
                    }

                    //num为该行有效单元格个数，取num的话，取值会不全
                    //lastnum为有效单元格最后各个单元格的列号，这样可以遍历取到该行所有的单元格
                    for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                        XSSFCell cell = row.getCell(cellIndex);
                        if (cell != null) {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            //打印出读出的数据
                            System.out.println("第" + rowIndex + "行      第" + cellIndex + "列    内容为：" + cell.getRichStringCellValue().getString());
                        }
                    }
                }
                System.out.println(MAP);
                System.out.println("------------------+++++++++++++++++++--------------------");
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static class FileLoader {
        public static final POITest instance = new POITest();
    }

    private POITest() {

    }

    public static POITest getInstance() {
        return FileLoader.instance;
    }


    public static void main(String[] args) {
        POITest instance1 = getInstance();
        POITest instance2 = getInstance();
        System.out.println(instance1 == instance2);
    }


}
