package edu.tongji.comm.example.poi;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
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
 * @Date: 2018/9/25
 */
public class NationalDayReadXLSX {


    private static List<CouponItem> couponItemList = Lists.newArrayList();
    private static List<CouponItem> outBreakCouponItemList = Lists.newArrayList();

    public static void main(String[] args) {
        read("双平台优惠券-20180926.xlsx");
        System.out.println("预热期券");
        System.out.println(JSON.toJSONString(couponItemList));
        System.out.println("***********************");
        System.out.println("爆发期券");
        System.out.println(JSON.toJSONString(outBreakCouponItemList));
    }


    public static void read(String filePath) {
        InputStream inputStream = ReadXLSX.class.getClassLoader().getResourceAsStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 2; rowIndex < 17; rowIndex++) {
                CouponItem outBreakCouponItem = new CouponItem();
                CouponItem couponItem = new CouponItem();
                try {

                    XSSFRow row = sheet.getRow(rowIndex);

                    XSSFCell money = row.getCell(0);
                    XSSFCell mtNew = row.getCell(10);
                    XSSFCell dpNew = row.getCell(11);
                    XSSFCell mtOld = row.getCell(13);
                    XSSFCell dpOld = row.getCell(14);

                    couponItem.setMoney((int) money.getNumericCellValue());
                    couponItem.setMtNew((int) mtNew.getNumericCellValue());
                    couponItem.setDpNew((int) dpNew.getNumericCellValue());
                    couponItem.setMtOld((int) mtOld.getNumericCellValue());
                    couponItem.setDpOld((int) dpOld.getNumericCellValue());


                    XSSFCell outBreakMtNew = row.getCell(2);
                    XSSFCell outBreakDpNew = row.getCell(3);
                    XSSFCell outBreakMtOld = row.getCell(5);
                    XSSFCell outBreakDpOld = row.getCell(6);

                    outBreakCouponItem.setMoney((int) money.getNumericCellValue());
                    outBreakCouponItem.setMtNew((int) outBreakMtNew.getNumericCellValue());
                    outBreakCouponItem.setDpNew((int) outBreakDpNew.getNumericCellValue());
                    outBreakCouponItem.setMtOld((int) outBreakMtOld.getNumericCellValue());
                    outBreakCouponItem.setDpOld((int) outBreakDpOld.getNumericCellValue());


                } catch (Exception ex) {
                    continue;
                }
                couponItemList.add(couponItem);
                outBreakCouponItemList.add(outBreakCouponItem);
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
    public static class CouponItem {
        private Integer money;
        private Integer dpNew;
        private Integer dpOld;
        private Integer mtNew;
        private Integer mtOld;
    }


}
