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
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/8/22
 */
public class ReadXLSX {

    private static String yuhui = "约会";
    private static String juhui = "聚会";
    private static String duxiang = "独享";
    private static String tuanjian = "团建";

    private static List<LionItem> dpLionItemList = Lists.newArrayList();
    private static List<LionItem> mtLionItemList = Lists.newArrayList();

    public static void main(String[] args) {
        read("src/main/resources/data.xlsx");
        System.out.println(JSON.toJSONString(dpLionItemList, SerializerFeature.WriteMapNullValue));
        System.out.println("***************************************");
        System.out.println(JSON.toJSONString(mtLionItemList, SerializerFeature.WriteMapNullValue));
    }




    public static void read(String filePath) {
        InputStream inputStream = ReadXLSX.class.getClassLoader().getResourceAsStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            for (int rowIndex = 1; rowIndex < 31; rowIndex++) {
                XSSFSheet sheet = workbook.getSheetAt(0);
                LionItem dpLionItem = new LionItem();
                LionItem mtLionItem = new LionItem();
                try {
                    XSSFRow row = sheet.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }

//                        List<Integer> channelTypes = Lists.newArrayList();
//                        Random random = new Random();
//                        channelTypes.add(1 + random.nextInt(4));
//                        channelTypes.add(1 + random.nextInt(5));

                    if (rowIndex == 5 || rowIndex == 18) {
                        XSSFCell dpShopId = row.getCell(1);
                        XSSFCell mtShopId = row.getCell(2);
                        XSSFCell url = row.getCell(13);
                        XSSFCell comment = row.getCell(14);
                        XSSFCell type = row.getCell(15);

                        dpLionItem.setShopId(dpShopId == null ? null : (int) dpShopId.getNumericCellValue());
                        dpLionItem.setDealId(0);
                        dpLionItem.setFreeCouponGroupId(0);
                        dpLionItem.setDiscountCouponGroupId(0);
                        dpLionItem.setComment(comment == null ? null : comment.getStringCellValue());
                        dpLionItem.setUserFace(url == null ? null : url.getStringCellValue());
                        dpLionItem.setChannelTypes(getChannelTypes(type.getStringCellValue()));

                        mtLionItem.setShopId(mtShopId == null ? null : (int) mtShopId.getNumericCellValue());
                        mtLionItem.setDealId(0);
                        mtLionItem.setFreeCouponGroupId(0);
                        mtLionItem.setDiscountCouponGroupId(0);
                        mtLionItem.setComment(comment == null ? null : comment.getStringCellValue());
                        mtLionItem.setUserFace(url == null ? null : url.getStringCellValue());
                        mtLionItem.setChannelTypes(getChannelTypes(type.getStringCellValue()));

                    } else {
                        XSSFCell dpShopId = row.getCell(1);
                        XSSFCell mtShopId = row.getCell(2);
                        XSSFCell dpDealId = row.getCell(7);
                        XSSFCell mtDealId = row.getCell(8);
                        XSSFCell dpFree = row.getCell(9);
                        XSSFCell mtFree = row.getCell(10);
                        XSSFCell dpDiscount = row.getCell(11);
                        XSSFCell mtDiscount = row.getCell(12);
                        XSSFCell url = row.getCell(13);
                        XSSFCell comment = row.getCell(14);
                        XSSFCell type = row.getCell(15);

                        dpLionItem.setShopId(dpShopId == null ? null : (int) dpShopId.getNumericCellValue());
                        dpLionItem.setDealId(dpDealId == null ? null : (int) dpDealId.getNumericCellValue());
                        dpLionItem.setFreeCouponGroupId(dpFree == null ? null : (int) dpFree.getNumericCellValue());
                        dpLionItem.setDiscountCouponGroupId(dpDiscount == null ? null : (int) dpDiscount.getNumericCellValue());
                        dpLionItem.setComment(comment == null ? null : comment.getStringCellValue());
                        dpLionItem.setUserFace(url == null ? null : url.getStringCellValue());
                        dpLionItem.setChannelTypes(getChannelTypes(type.getStringCellValue()));

                        mtLionItem.setShopId(mtShopId == null ? null : (int) mtShopId.getNumericCellValue());
                        mtLionItem.setDealId(mtDealId == null ? null : (int) mtDealId.getNumericCellValue());
                        mtLionItem.setFreeCouponGroupId(dpFree == null ? null : (int) mtFree.getNumericCellValue());
                        mtLionItem.setDiscountCouponGroupId(mtDiscount == null ? null : (int) mtDiscount.getNumericCellValue());
                        mtLionItem.setComment(comment == null ? null : comment.getStringCellValue());
                        mtLionItem.setUserFace(url == null ? null : url.getStringCellValue());
                        mtLionItem.setChannelTypes(getChannelTypes(type.getStringCellValue()));
                    }

                } catch (Exception ex) {
                    continue;
                }
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



    private static List<Integer> getChannelTypes(String str) {
        List<Integer> channelTypes = Lists.newArrayList();
        List<String> args = Arrays.asList(str.split("、"));
        if (args.contains(yuhui)) {
            channelTypes.add(1);
        }
        if (args.contains(juhui)) {
            channelTypes.add(2);
        }
        if (args.contains(duxiang)) {
            channelTypes.add(3);
        }
        if (args.contains(tuanjian)) {
            channelTypes.add(4);
        }
        return channelTypes;
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
        private List<Integer> channelTypes;
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
