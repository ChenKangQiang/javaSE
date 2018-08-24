package edu.tongji.comm.example.poi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import lombok.Data;
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
 * @Date: 2018/8/22
 */
public class ReadXLSX {

    private static List<LionItem> dpLionItemList = Lists.newArrayList();
    private static List<LionItem> mtLionItemList = Lists.newArrayList();

    public static void main(String[] args) {
        read("Lion.xlsx");
        System.out.println(JSON.toJSONString(dpLionItemList, SerializerFeature.WriteMapNullValue));
        System.out.println("***************************************");
        System.out.println(JSON.toJSONString(mtLionItemList, SerializerFeature.WriteMapNullValue));
    }


    public static void read(String filePath) {
        InputStream inputStream = ReadXLSX.class.getClassLoader().getResourceAsStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue;
                }

                LionItem dpLionItem = new LionItem();
                LionItem mtLionItem = new LionItem();

                XSSFCell dpShopId = row.getCell(0);
                XSSFCell mtShopId = row.getCell(1);
                XSSFCell dpDealId = row.getCell(4);
                XSSFCell mtDealId = row.getCell(5);
                XSSFCell comment = row.getCell(6);

                dpLionItem.setShopId(dpShopId == null ? null : (int) dpShopId.getNumericCellValue());
                dpLionItem.setDealId(dpDealId == null ? null : (int) dpDealId.getNumericCellValue());
                dpLionItem.setComment(comment == null ? null : comment.getStringCellValue());

                mtLionItem.setShopId(mtShopId == null ? null :(int) mtShopId.getNumericCellValue());
                mtLionItem.setDealId(mtDealId == null ? null :(int) mtDealId.getNumericCellValue());
                mtLionItem.setComment(comment == null ? null : comment.getStringCellValue());

                dpLionItemList.add(dpLionItem);
                mtLionItemList.add(mtLionItem);

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
    private static class LionItem {
        /**
         * 团单Id
         */
        private Integer dealId;
        /**
         * 商户Id
         */
        private Integer shopId;
        /**
         * 达人评价
         */
        private String comment;
        /**
         * 达人头像
         */
        private String userFace;
        /**
         * 子频道类型, 1：约会， 2：聚会， 3：独享， 4：团建
         */
        private Integer channelType;
        /**
         * 折扣券的券组Id
         */
        private Integer discountCouponGroupId;
        /**
         * 免单券的券组Id
         */
        private Integer freeCouponGroupId;
    }


}
