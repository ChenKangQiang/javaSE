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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/11/13
 */
public class BarShopReadXLSX {

    private static final String SIZE = "@670w_300h_1e_1c";

    public static void main(String[] args) {
        read("src/main/resources/barshop.xlsx", 0, 19);

        System.out.println("*****************");
    }

    public static void read(String filePath, int start, int end) {
        InputStream inputStream = BarShopReadXLSX.class.getClassLoader().getResourceAsStream(filePath);
        InputStream inputStream1 = BarShopReadXLSX.class.getClassLoader().getResourceAsStream("src/main/resources/shoppic.xlsx");

        Map<Integer, String> shopToPicMap = Maps.newHashMap();
        try {
            XSSFWorkbook picWorkbook = new XSSFWorkbook(inputStream1);
            XSSFSheet picSheet = picWorkbook.getSheetAt(0);
            for (int rowIndex = 1; rowIndex < picSheet.getPhysicalNumberOfRows(); rowIndex++) {
                XSSFRow picRow = picSheet.getRow(rowIndex);
                XSSFCell shopId = picRow.getCell(0);
                XSSFCell url = picRow.getCell(1);
                shopToPicMap.put((int) shopId.getNumericCellValue(), filterImageUrl(url.getStringCellValue()));
            }

            System.out.println(JSON.toJSONString(shopToPicMap));

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            for (int i = start; i < end; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                List<ShopInfoLionItem> shopInfoLionItemList = Lists.newArrayList();

                for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                    try {
                        XSSFRow row = sheet.getRow(rowIndex);
                        XSSFCell dpShopId = row.getCell(0);
                        XSSFCell mtShopId = row.getCell(1);
                        XSSFCell pic = row.getCell(6);

                        ShopInfoLionItem shopInfoLionItem = new ShopInfoLionItem();
                        shopInfoLionItem.setDpShopId((int) dpShopId.getNumericCellValue());
                        shopInfoLionItem.setMtShopId((int) mtShopId.getNumericCellValue());
                        if (pic != null && StringUtils.isNotEmpty(pic.getStringCellValue())) {
                            shopInfoLionItem.setShopPic(pic.getStringCellValue() + SIZE);
                        }


                        shopInfoLionItemList.add(shopInfoLionItem);

                    } catch (Exception ex) {
                        continue;
                    }
                }


                shopInfoLionItemList
                        .stream()
                        .filter(item -> shopToPicMap.get(item.getDpShopId()) != null)
                        .forEach(item -> item.setShopPic(shopToPicMap.get(item.getDpShopId())));

                System.out.println("size:" +shopInfoLionItemList.size() + ", " + sheet.getSheetName() + ":" + JSON.toJSONString(shopInfoLionItemList));
                System.out.println("*****************************");
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




    private static final String IMAGE_REGEX = "https://[\\S]*(\\.jpg|\\.png|\\.JPG|\\.PNG)";

    /**
     * 正则匹配jpg和png图片http url
     *
     * @param imageUrl
     * @return
     */
    public static String filterImageUrl(String imageUrl) {
        Pattern pattern = Pattern.compile(IMAGE_REGEX);
        Matcher matcher = pattern.matcher(imageUrl);
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return imageUrl;
        }
    }



    @Data
    public static class ShopInfoLionItem {
        private Integer dpShopId;
        private Integer mtShopId;
        private String shopPic;
    }

}
