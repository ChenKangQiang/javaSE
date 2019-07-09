package edu.tongji.comm.example.enums;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-03-08
 */
public class DynamicEnum {

    public static void main(String[] args) {
        System.out.println("原始数据：");
        for (UniversityEnum universityEnum : UniversityEnum.values()) {
            System.out.println(universityEnum);
        }
        System.out.println("-----------------------------");
        DynamicEnumUtils.addEnum(UniversityEnum.class, "HUASHI", new Class[] {
                int.class, String.class }, new Object[] {4, "huashi"});
        System.out.println("添加后的数据：");
        for (UniversityEnum universityEnum : UniversityEnum.values()) {
            System.out.println(universityEnum);
        }
        System.out.println("-----------------------------");
        UniversityEnum universityEnum = UniversityEnum.valueOf("HUASHI");
        System.out.println("新添加的枚举类型可以正常使用：");
        System.out.println(universityEnum.code);
        System.out.println(universityEnum.name);
    }


}
