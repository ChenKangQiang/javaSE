package edu.tongji.comm.excel;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import edu.tongji.comm.example.poi.NationalDayReadXLSX;
import edu.tongji.comm.example.poi.ReadXLSX;
import lombok.AllArgsConstructor;
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
 * @Date: 2018/11/8
 */
public class JarListReadXLSX {


    private static List<CityInfoLionItem> dpCityInfoLionItemList = Lists.newArrayList();

    private static List<CityInfoLionItem> mtCityInfoLionItemList = Lists.newArrayList();

    private static final String WEBP = ".webp";

    private static final String SHOP_PIC = "https://p0.meituan.net/joymerchant/-2151864702188384125-759960-1495869286659.jpg@670w_300h_1e_1c.webp";

    public static void main(String[] args) {
        read("src/main/resources/酒吧榜单城市.xlsx");
        System.out.println(JSON.toJSONString(dpCityInfoLionItemList));

        System.out.println("*****************");

        System.out.println(JSON.toJSONString(mtCityInfoLionItemList));
    }


    public static void read(String filePath) {
        InputStream inputStream = ReadXLSX.class.getClassLoader().getResourceAsStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex < 20; rowIndex++) {
                CityInfoLionItem dpCityInfoLionItem = new CityInfoLionItem();
                CityInfoLionItem mtCityInfoLionItem = new CityInfoLionItem();

                try {

                    XSSFRow row = sheet.getRow(rowIndex);

                    XSSFCell cityName = row.getCell(0);
                    XSSFCell dpCityId = row.getCell(1);
                    XSSFCell mtCityId = row.getCell(2);
                    XSSFCell cityBig = row.getCell(4);
                    XSSFCell cityPic = row.getCell(5);
                    XSSFCell citySmall = row.getCell(6);

                    dpCityInfoLionItem.setCityName(cityName.getStringCellValue());
                    dpCityInfoLionItem.setCityId((int) dpCityId.getNumericCellValue());
                    dpCityInfoLionItem.setCityBigPic(cityBig.getStringCellValue() + WEBP);
                    dpCityInfoLionItem.setCityPic(cityPic.getStringCellValue() + WEBP);
                    dpCityInfoLionItem.setCitySmallPic(citySmall.getStringCellValue() + WEBP);
                    dpCityInfoLionItem.setCityDescription(Lists.newArrayList("老洋房 夜上海", "这里有不一样的微醺魅力"));
                    dpCityInfoLionItem.setShopInfoLionItems(getDpShopInfo());

                    mtCityInfoLionItem.setCityName(cityName.getStringCellValue());
                    mtCityInfoLionItem.setCityId((int) mtCityId.getNumericCellValue());
                    mtCityInfoLionItem.setCityBigPic(cityBig.getStringCellValue() + WEBP);
                    mtCityInfoLionItem.setCityPic(cityPic.getStringCellValue() + WEBP);
                    mtCityInfoLionItem.setCitySmallPic(citySmall.getStringCellValue() + WEBP);
                    mtCityInfoLionItem.setCityDescription(Lists.newArrayList("老洋房 夜上海", "这里有不一样的微醺魅力"));
                    mtCityInfoLionItem.setShopInfoLionItems(getMtShopInfo());


                } catch (Exception ex) {
                    continue;
                }

                dpCityInfoLionItemList.add(dpCityInfoLionItem);
                mtCityInfoLionItemList.add(mtCityInfoLionItem);
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



    public static List<ShopInfoLionItem> getDpShopInfo() {
        List<ShopInfoLionItem> dpShopInfoLionItems = Lists.newArrayList();
        dpShopInfoLionItems.add(new ShopInfoLionItem(504671, "95%的人说环境很棒", SHOP_PIC));
        dpShopInfoLionItems.add(new ShopInfoLionItem(17642397, "95%的人说环境很棒", SHOP_PIC));
        dpShopInfoLionItems.add(new ShopInfoLionItem(73603371, "95%的人说环境很棒", SHOP_PIC));
        dpShopInfoLionItems.add(new ShopInfoLionItem(57529888, "95%的人说环境很棒", SHOP_PIC));
        return dpShopInfoLionItems;
    }



    public static List<ShopInfoLionItem> getMtShopInfo() {
        List<ShopInfoLionItem> mtShopInfoLionItems = Lists.newArrayList();
        mtShopInfoLionItems.add(new ShopInfoLionItem(384558, "95%的人说环境很棒", SHOP_PIC));
        mtShopInfoLionItems.add(new ShopInfoLionItem(454345, "95%的人说环境很棒", SHOP_PIC));
        mtShopInfoLionItems.add(new ShopInfoLionItem(2460608, "95%的人说环境很棒", SHOP_PIC));
        mtShopInfoLionItems.add(new ShopInfoLionItem(425473, "95%的人说环境很棒", SHOP_PIC));
        return mtShopInfoLionItems;
    }




    @Data
    public static class CityInfoLionItem {
        private Integer cityId;
        private String cityName;
        private List<String> cityDescription;
        private String cityBigPic;
        private String cityPic;
        private String citySmallPic;
        private List<ShopInfoLionItem> shopInfoLionItems;
    }


    @Data
    @AllArgsConstructor
    public static class ShopInfoLionItem {
        private Integer shopId;
        private String shopDescription;
        private String shopPic;
    }

}
