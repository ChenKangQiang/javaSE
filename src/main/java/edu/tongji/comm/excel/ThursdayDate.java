package edu.tongji.comm.excel;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.tongji.comm.example.poi.ReadXLSX;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
        read("coupon.xlsx");

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
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                try {
                    XSSFRow row = sheet.getRow(rowIndex);
                    XSSFCell dpDealId = row.getCell(2);
                    XSSFCell dpCouponId = row.getCell(3);
                    XSSFCell price = row.getCell(4);
                    XSSFCell mtDealId = row.getCell(5);
                    XSSFCell mtCouponId = row.getCell(6);

                    Coupon dpCoupon = new Coupon();
                    Coupon mtCoupon = new Coupon();

                    dpCoupon.setCouponGroupId((int) dpCouponId.getNumericCellValue());
                    dpCoupon.setCouponPrice((int) price.getNumericCellValue());

                    mtCoupon.setCouponGroupId((int) mtCouponId.getNumericCellValue());
                    mtCoupon.setCouponPrice((int) price.getNumericCellValue());

                    Coupon aaa = dpCouponMap.get((int) dpDealId.getNumericCellValue() + "");
                    if (aaa != null) {
                        System.out.println(rowIndex);
                    }

                    dpCouponMap.put((int) dpDealId.getNumericCellValue() + "", dpCoupon);
                    mtCouponMap.put((int) mtDealId.getNumericCellValue() + "", mtCoupon);

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
