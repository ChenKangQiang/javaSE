package edu.tongji.comm.example.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen on 2017/7/14.
 * 枚举类，枚举了大学名及其代号
 */
public enum  UniversityEnum {

    TONGJI(1, "同济"),
    FUDU(2, "复旦"),
    JIAODA(3, "交大");

    public int code;
    public String name;

    private static Map<Integer, UniversityEnum> universities = new HashMap<>();

    static {
        for (UniversityEnum university : UniversityEnum.values()) {
            universities.put(university.code, university);
        }
    }

    private UniversityEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static UniversityEnum getUniversityEnum(int code) {
        return universities.get(code);
    }


}
