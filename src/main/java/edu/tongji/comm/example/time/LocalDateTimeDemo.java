package edu.tongji.comm.example.time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/23
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now:" + now);

        LocalDateTime time1 = LocalDateTime.parse("2018-07-31T12:00:00");
        LocalDateTime time2 = LocalDateTime.parse("2018-07-31T17:00:00");
        LocalDateTime time3 = LocalDateTime.parse("2018-07-31T20:00:00");
        LocalDateTime end = LocalDateTime.parse("2018-09-30T20:00:00");

        int templateId = 300;
        List<TemplateInfoString> templateInfoStringList = Lists.newArrayList();

        while (time3.isBefore(end)) {
            time1 = time1.plusHours(24);
            time2 = time2.plusHours(24);
            time3 = time3.plusHours(24);
            templateInfoStringList.add(new TemplateInfoString(templateId++, time1.toString()));
            templateInfoStringList.add(new TemplateInfoString(templateId++, time2.toString()));
            templateInfoStringList.add(new TemplateInfoString(templateId++, time3.toString()));
        }

        String json = JSON.toJSONString(templateInfoStringList);
        System.out.println(json);

        List<TemplateInfo> templateInfos = JSONObject.parseArray(json, TemplateInfo.class);
        System.out.println(templateInfos.get(0));

        System.out.println("{\"postbox\":null}");

    }


    @Data
    @NoArgsConstructor
    private static class TemplateInfo {
        private int templateId;
        private LocalDateTime time;
    }


    @AllArgsConstructor
    @Data
    private static class TemplateInfoString {
        private int templateId;
        private String time;
    }

}
