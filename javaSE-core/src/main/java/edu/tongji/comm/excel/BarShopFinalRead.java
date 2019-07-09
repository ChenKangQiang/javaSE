package edu.tongji.comm.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.math.NumberUtils;
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
 * @Date: 2018-12-18
 */
public class BarShopFinalRead {

    private static final String CITY_NAME_CITY_ID = "{\n" +
            "  \"上海\": \"1-10-https://p1.meituan.net/scarlett/ad4fe1f305a0e3dae73d3ed4521d083b1273886.png\",\n" +
            "  \"北京\": \"2-1-https://p0.meituan.net/scarlett/bd502657126b4d3894a32afafe8dece31175631.png\",\n" +
            "  \"广州\": \"4-20-https://p0.meituan.net/scarlett/72a320a6b649333312cb5dcc99ce2e14939400.png\",\n" +
            "  \"杭州\": \"3-50-https://p0.meituan.net/scarlett/ab019be93f7988873ed6bb3eb4b91c61822060.png\",\n" +
            "  \"成都\": \"8-59-https://p0.meituan.net/scarlett/e04a382d95855cd26090de93cc8e254c959245.png\",\n" +
            "  \"深圳\": \"7-30-https://p1.meituan.net/scarlett/c80c327eb8f03ade457abcd8c6b068ad827700.png\",\n" +
            "  \"天津\": \"10-40-https://p1.meituan.net/scarlett/c0194fec07cfddc671e4d1a1ef713952816450.png\",\n" +
            "  \"贵阳\": \"258-107-https://p1.meituan.net/scarlett/3f31315ed90caff8b553954fceb14261988640.png\",\n" +
            "  \"武汉\": \"16-57-https://p1.meituan.net/scarlett/598b8c7a618f184fd34e84acec11721f789685.png\",\n" +
            "  \"重庆\": \"9-45-https://p0.meituan.net/scarlett/139ce4b67cfa72e638ceb9f2b678039e1280343.png\",\n" +
            "  \"西安\": \"17-42-https://p1.meituan.net/scarlett/a47afd2a17dcde06bf769aaa6dde8aba635965.png\",\n" +
            "  \"昆明\": \"267-114-https://p1.meituan.net/scarlett/17c511a39fb707605a9b15ea51520ce11294697.png\",\n" +
            "  \"青岛\": \"21-60-https://p0.meituan.net/scarlett/6fd42999fe2a11d294b28a701c0a369f1034309.png\",\n" +
            "  \"厦门\": \"15-62-https://p0.meituan.net/scarlett/d397961b3d49368e9c874a7bbaa6c834770292.png\",\n" +
            "  \"南京\": \"5-55-https://p1.meituan.net/scarlett/8930bc6512fff2429b263527d15afcca858329.png\",\n" +
            "  \"沈阳\": \"18-66-https://p1.meituan.net/scarlett/9823af976df4d389abf90c99d636b1cb1083182.png\",\n" +
            "  \"苏州\": \"6-81-https://p1.meituan.net/scarlett/119e3cb052654e190cac81036d4ef6ad708489.png\",\n" +
            "  \"大连\": \"19-65-https://p1.meituan.net/scarlett/dbc3f585a0d80dc1dc80305725e0ea031045642.png\",\n" +
            "  \"丽江\": \"279-334-https://p0.meituan.net/scarlett/e6d1c00d070bfd5734892608e81429ae1148848.png\"\n" +
            "}";

    private static Map<String, JSONObject> shopConfig = Maps.newHashMap();

    private static final Map<String, Integer> DP_CITY_NAME_CITY_ID = Maps.newHashMap();
    private static final Map<String, Integer> MT_CITY_NAME_CITY_ID = Maps.newHashMap();
    private static final Map<String, String> CITY_NAME_PIC = Maps.newHashMap();

    private static final Map<String, List<Integer>> MT = Maps.newHashMap();
    private static final Map<String, List<Integer>> DP = Maps.newHashMap();

    static {
        JSONObject jsonObject = JSON.parseObject(CITY_NAME_CITY_ID);
        jsonObject.entrySet().stream().forEach(entry -> {
            String[] config = ((String) entry.getValue()).split("-");
            DP_CITY_NAME_CITY_ID.put(entry.getKey(), NumberUtils.toInt(config[0]));
            MT_CITY_NAME_CITY_ID.put(entry.getKey(), NumberUtils.toInt(config[1]));
            CITY_NAME_PIC.put(entry.getKey(), config[2]);
        });

    }

    public static void main(String[] args) {
        read("src/main/resources/barshopfinalconfig.xlsx", 0, 19);
        System.out.println(JSON.toJSONString(shopConfig));
        System.out.println("****************");
        System.out.println(JSON.toJSONString(MT));
        System.out.println("****************");
        System.out.println(JSON.toJSONString(DP));
    }


    public static void read(String filePath, int start, int end) {
        InputStream inputStream = BarShopReadXLSX.class.getClassLoader().getResourceAsStream(filePath);

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            for (int i = start; i < end; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                String sheetName = sheet.getSheetName();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pic", CITY_NAME_PIC.get(sheetName));

                JSONObject shop = new JSONObject();
                List<Integer> mtShopIds = Lists.newArrayList();
                List<Integer> dpShopIds = Lists.newArrayList();
                for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                    try {
                        XSSFRow row = sheet.getRow(rowIndex);
                        XSSFCell dpShopId = row.getCell(0);
                        XSSFCell mtShopId = row.getCell(1);
                        XSSFCell comment = row.getCell(6);

                        String key = (int) dpShopId.getNumericCellValue() + "-" + (int) mtShopId.getNumericCellValue();
                        shop.put(key, comment == null ? "" : comment.getStringCellValue());

                        mtShopIds.add((int) mtShopId.getNumericCellValue());
                        dpShopIds.add((int) dpShopId.getNumericCellValue());

                    } catch (Exception ex) {
                        continue;
                    }
                }

                jsonObject.put("shop", shop);
                shopConfig.put(DP_CITY_NAME_CITY_ID.get(sheetName) + "-" + MT_CITY_NAME_CITY_ID.get(sheetName), jsonObject);

                MT.put(sheetName + "-" + MT_CITY_NAME_CITY_ID.get(sheetName), mtShopIds);
                DP.put(sheetName + "-" + DP_CITY_NAME_CITY_ID.get(sheetName), dpShopIds);
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
