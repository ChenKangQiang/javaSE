package edu.tongji.comm.excel;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import edu.tongji.comm.example.poi.ReadXLSX;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-03-19
 */
public class SceneList {


    private static final List<SceneConfig> SCENE_CONFIGS = Lists.newArrayList();
    private static final Map<Integer, Set<String>> cateToKeyWords = Maps.newHashMap();

    public static void main(String[] args) {
        read("src/main/resources/scenelist.xlsx");
        System.out.println(JSON.toJSONString(SCENE_CONFIGS));

        Map<Integer, String> bbb = Maps.newHashMap();
        cateToKeyWords.entrySet().stream().forEach(entry -> bbb.put(entry.getKey(), StringUtils.join(entry.getValue(), "-")));

        StringBuilder stringBuilder = new StringBuilder();
        bbb.entrySet().stream().forEach(entry -> stringBuilder.append(String.format("when CateId = %d then \'%s\'", entry.getKey(), entry.getValue())).append("\n"));
        System.out.println(stringBuilder.toString());
    }

    public static void read(String filePath) {
        InputStream inputStream = SceneList.class.getClassLoader().getResourceAsStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                try {
                    XSSFRow row = sheet.getRow(rowIndex);
                    XSSFCell sceneId = row.getCell(0);
                    XSSFCell sceneName = row.getCell(1);
                    XSSFCell tag = row.getCell(2);
                    XSSFCell cateIds = row.getCell(3);
                    XSSFCell description = row.getCell(6);
                    XSSFCell pic = row.getCell(7);
                    XSSFCell pic2 = row.getCell(8);
                    XSSFCell words = row.getCell(9);

                    SceneConfig sceneConfig = new SceneConfig();

                    sceneConfig.setSceneId((int) sceneId.getNumericCellValue());
                    sceneConfig.setDescription(description.getStringCellValue());
                    sceneConfig.setSceneName(sceneName.getStringCellValue());
                    sceneConfig.setPic(pic.getStringCellValue());
                    sceneConfig.setLandingPagePic(pic2.getStringCellValue());


                    List<String> tagIds = Lists.newArrayList();
                    if (tag != null) {
                        if (tag.getNumericCellValue() > 0) {
                            String tagId = String.valueOf((int) tag.getNumericCellValue());
                            tagIds.add(tagId);
                            sceneConfig.setTagIds(tagIds);
                        }
                    }

                    String[] cateIdString = cateIds.getStringCellValue().split("、");
                    List<Integer> temp = Arrays.stream(cateIdString).map(NumberUtils::toInt).collect(Collectors.toList());
                    sceneConfig.setCategoryIds(temp);

                    String[] keyWords = null;
                    if (StringUtils.isNotEmpty(words.getStringCellValue())) {
                        keyWords = words.getStringCellValue().split(">");
                    }

                    if (keyWords != null) {
                        List<String> temp1 = Arrays.stream(keyWords).collect(Collectors.toList());
                        sceneConfig.setKeyWords(temp1);
                        for (Integer cate : temp) {
                            if (cateToKeyWords.containsKey(cate)) {
                                cateToKeyWords.get(cate).addAll(temp1);
                            } else {
                                cateToKeyWords.put(cate, Sets.newHashSet(temp1));
                            }
                        }
                    }

                    SCENE_CONFIGS.add(sceneConfig);
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
    public static class SceneConfig {
        public static final int SPRING = 1;             //春
        public static final int SUMMER = 2;             //夏
        public static final int AUTUMN = 3;             //秋
        public static final int WINTER = 4;             //冬
        public static final int BIRTHDAY = 5;           //生日
        public static final int NOCTURNAL_ANIMAL = 6;   //夜行动物
        public static final int NEARBY = 7;             //附近好玩
        public static final int HOT_SHOP = 8;           //网红潮店
        public static final int SINGLE = 9;             //一人乐
        public static final int DATE = 10;              //约会
        public static final int FAMILY = 11;            //家庭
        public static final int PARTY = 12;             //聚会
        public static final int TEAM_BUILDING = 13;     //团建
        public static final int ART = 14;               //艺术
        public static final int RELAX = 15;             //放松
        public static final int FUN_SPORT = 16;         //趣运动

        public static final Set<Integer> SEASONS = ImmutableSet.of(SPRING, SUMMER, AUTUMN, WINTER);

        /**
         * 场景id
         */
        private int sceneId;
        /**
         * 场景名
         */
        private String sceneName;
        /**
         * 优先级，默认为2
         */
        private int priority = 2;
        /**
         * 描述
         */
        private String description;
        /**
         * 该场景对应的类目id
         */
        private List<Integer> categoryIds;
        /**
         * 该场景对应的标签
         */
        private List<String> tagIds;
        /**
         * 图片
         */
        private String pic;
        private String landingPagePic;
        /**
         * 商户推荐理由搜索关键词
         */
        private List<String> keyWords;
    }

}
