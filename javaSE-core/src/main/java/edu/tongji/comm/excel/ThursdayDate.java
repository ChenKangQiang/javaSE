package edu.tongji.comm.excel;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import edu.tongji.comm.example.poi.ReadXLSX;
import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/11/21
 */
public class ThursdayDate {

    private static Map<String, Coupon> dpCouponMap = Maps.newHashMap();
    private static Map<String, Coupon> mtCouponMap = Maps.newHashMap();

    public static void main(String[] args) {
        read("src/main/resources/coupon20181205.xlsx");

        System.out.println(JSON.toJSONString(dpCouponMap));
        System.out.println(dpCouponMap.size());
        System.out.println("*****************");
        System.out.println(JSON.toJSONString(mtCouponMap));
        System.out.println(mtCouponMap.size());


    }

    public static void read(String filePath) {
        InputStream inputStream = ReadXLSX.class.getClassLoader().getResourceAsStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(2);

            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                try {
                    XSSFRow row = sheet.getRow(rowIndex);
                    XSSFCell dpDealIds = row.getCell(0);
                    XSSFCell mtDealIds = row.getCell(3);
                    XSSFCell dpPrice = row.getCell(1);
                    XSSFCell dpCouponId = row.getCell(2);
                    XSSFCell mtCouponId = row.getCell(5);
                    XSSFCell mtPrice = row.getCell(4);

                    String[] dpDealIdArray = dpDealIds.getStringCellValue().split(",");
                    String[] mtDealIdArray = mtDealIds.getStringCellValue().split(",");

                    for (String dpDealId : dpDealIdArray) {
                        Coupon coupon = new Coupon();
                        coupon.setCouponGroupId((int) dpCouponId.getNumericCellValue());
                        coupon.setCouponPrice((int) dpPrice.getNumericCellValue());
                        dpCouponMap.put(dpDealId, coupon);
                    }

                    for (String mtDealId : mtDealIdArray) {
                        Coupon coupon = new Coupon();
                        coupon.setCouponGroupId((int) mtCouponId.getNumericCellValue());
                        coupon.setCouponPrice((int) mtPrice.getNumericCellValue());
                        mtCouponMap.put(mtDealId, coupon);
                    }
                } catch (Exception ex) {
                    System.out.println(rowIndex);
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



    @Data
    private static class Coupon {
        private Integer couponGroupId;
        private Integer couponPrice;
    }

}
