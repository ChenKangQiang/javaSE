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

    private static String aaa = "[\n" +
            "  {\n" +
            "    \"templateId\": 9361291,\n" +
            "    \"time\": \"2018-08-01T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361292,\n" +
            "    \"time\": \"2018-08-02T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361293,\n" +
            "    \"time\": \"2018-08-03T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361294,\n" +
            "    \"time\": \"2018-08-04T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361295,\n" +
            "    \"time\": \"2018-08-05T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361296,\n" +
            "    \"time\": \"2018-08-06T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361297,\n" +
            "    \"time\": \"2018-08-07T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361298,\n" +
            "    \"time\": \"2018-08-08T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361299,\n" +
            "    \"time\": \"2018-08-09T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361300,\n" +
            "    \"time\": \"2018-08-10T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361301,\n" +
            "    \"time\": \"2018-08-11T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361302,\n" +
            "    \"time\": \"2018-08-12T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361303,\n" +
            "    \"time\": \"2018-08-13T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361304,\n" +
            "    \"time\": \"2018-08-14T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361305,\n" +
            "    \"time\": \"2018-08-15T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361306,\n" +
            "    \"time\": \"2018-08-16T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361307,\n" +
            "    \"time\": \"2018-08-17T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361308,\n" +
            "    \"time\": \"2018-08-18T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361309,\n" +
            "    \"time\": \"2018-08-19T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361310,\n" +
            "    \"time\": \"2018-08-20T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361311,\n" +
            "    \"time\": \"2018-08-21T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361312,\n" +
            "    \"time\": \"2018-08-22T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361313,\n" +
            "    \"time\": \"2018-08-23T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361314,\n" +
            "    \"time\": \"2018-08-24T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361315,\n" +
            "    \"time\": \"2018-08-25T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361316,\n" +
            "    \"time\": \"2018-08-26T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361317,\n" +
            "    \"time\": \"2018-08-27T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361318,\n" +
            "    \"time\": \"2018-08-28T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361319,\n" +
            "    \"time\": \"2018-08-29T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361320,\n" +
            "    \"time\": \"2018-08-30T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361321,\n" +
            "    \"time\": \"2018-08-31T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361322,\n" +
            "    \"time\": \"2018-09-01T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361323,\n" +
            "    \"time\": \"2018-09-02T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361324,\n" +
            "    \"time\": \"2018-09-03T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361325,\n" +
            "    \"time\": \"2018-09-04T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361326,\n" +
            "    \"time\": \"2018-09-05T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361327,\n" +
            "    \"time\": \"2018-09-06T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361328,\n" +
            "    \"time\": \"2018-09-07T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361329,\n" +
            "    \"time\": \"2018-09-08T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361330,\n" +
            "    \"time\": \"2018-09-09T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361331,\n" +
            "    \"time\": \"2018-09-10T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361332,\n" +
            "    \"time\": \"2018-09-11T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361333,\n" +
            "    \"time\": \"2018-09-12T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361334,\n" +
            "    \"time\": \"2018-09-13T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361335,\n" +
            "    \"time\": \"2018-09-14T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361336,\n" +
            "    \"time\": \"2018-09-15T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361337,\n" +
            "    \"time\": \"2018-09-16T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361338,\n" +
            "    \"time\": \"2018-09-17T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361339,\n" +
            "    \"time\": \"2018-09-18T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361340,\n" +
            "    \"time\": \"2018-09-19T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361341,\n" +
            "    \"time\": \"2018-09-20T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361342,\n" +
            "    \"time\": \"2018-09-21T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361343,\n" +
            "    \"time\": \"2018-09-22T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361344,\n" +
            "    \"time\": \"2018-09-23T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361345,\n" +
            "    \"time\": \"2018-09-24T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361346,\n" +
            "    \"time\": \"2018-09-25T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361347,\n" +
            "    \"time\": \"2018-09-26T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361348,\n" +
            "    \"time\": \"2018-09-27T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361349,\n" +
            "    \"time\": \"2018-09-28T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361350,\n" +
            "    \"time\": \"2018-09-29T12:00\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"templateId\": 9361351,\n" +
            "    \"time\": \"2018-09-30T12:00\"\n" +
            "  }\n" +
            "]";

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

        List<TemplateInfo> templateInfos = JSONObject.parseArray(aaa, TemplateInfo.class);
        System.out.println(LocalDateTime.now().isBefore(templateInfos.get(0).getTime()));
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
