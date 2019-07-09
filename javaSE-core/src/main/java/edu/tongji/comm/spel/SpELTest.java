package edu.tongji.comm.spel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.springframework.core.ResolvableType;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-06-26
 */
public class SpELTest {

    public static void main(String[] args) {

        try {

            //System.out.println(SpELTest.class.getMethod("getType2", String.class).toGenericString());

            Type listType = getType2("test2");
            System.out.println(listType);
            Type mapType = getType2("test3");
            System.out.println(mapType);
            Type mapmapType = getType2("test4");
            System.out.println(mapmapType);

            Type nnnn = ((ParameterizedType) mapmapType).getActualTypeArguments()[1];

            ExpressionParser parser = new SpelExpressionParser();

            String str = (String) parser.parseExpression("'你好'").getValue();
            System.out.println(str);

            int intVal = (Integer) parser.parseExpression("0x2F").getValue();
            System.out.println(intVal);

            double doubleVal = (Double) parser.parseExpression("4329759E+22").getValue();
            System.out.println(doubleVal);

            boolean booleanVal = (boolean) parser.parseExpression("true").getValue();
            System.out.println(booleanVal);

//            JexlEngine jexl = new JexlEngine();
//            Expression e = jexl.createExpression("new com.alibaba.fastjson.TypeReference<String>() {}");
//            Object result = e.evaluate(null);

            EvaluationContext context = new StandardEvaluationContext();

            List<User> users = Lists.newArrayList();
            users.add(new User("hello", 123));
            users.add(new User("world", 234));

            Map<Integer, User> map = Maps.newHashMap();
            map.put(1, new User("hello", 123));
            Class aaaaa = map.get(1).getClass();

            //MyTypeReference myTypeReferenc = new edu.tongji.comm.spel.SpELTest.MyTypeReference<List<User>>();
            TypeReference reference = new TypeReference<List<User>>(){};

            String userstring = JSON.toJSONString(users);
            String userMapStr = JSON.toJSONString(map);

            List<User> DDD = JSON.parseObject(userstring, reference.getType());
            List<User> DDD2 = JSON.parseObject(userstring, getType(users));
            List<User> DDD3 = JSON.parseObject(userstring, listType);

            TypeReference reference2 = new TypeReference<Map<Integer, User>>(){};
            Map<Integer, User> eee = JSON.parseObject(userMapStr, reference2.getType());
            Map<Integer, User> eee2 = JSON.parseObject(userMapStr, mapType);
            Map<Integer, User> eee3 = JSON.parseObject(userMapStr, nnnn);

            TypeToken a = new com.google.common.reflect.TypeToken<Map<Integer, String>>() {};

            TypeReference typeReference = new com.alibaba.fastjson.TypeReference<String>() {};



            Object bbb = parser.parseExpression("new String('helloworld')").getValue();

            Object ccc = parser.parseExpression("new com.alibaba.fastjson.TypeReference<String>() {}").getValue();

            //Object ddd = parser.parseExpression("new com.google.common.reflect.TypeToken<String>() {}").getValue();

            Object ddd = parser.parseExpression("new edu.tongji.comm.spel.SpELTest.MyTypeReference<Map<Integer, String>>()").getValue();

//            int sourceId = 1;
//            int result2 = parser.parseExpression("#sourceId").getValue(Integer.class);
//            System.out.println(result2);

            List<Integer> shopIds = Lists.newArrayList(111, 222);
            context.setVariable("shopIds", shopIds);
            context.setVariable("users", users);
            List<Integer> result1 = (List<Integer>) parser.parseExpression("#shopIds").getValue(context);
            Object object = parser.parseExpression("#shopIds.toArray()").getValue(context);
            Integer aaa = (Integer) parser.parseExpression("#shopIds[0]").getValue(context);
            System.out.println(aaa);
            Object name = parser.parseExpression("#users[0].name").getValue(context);
            System.out.println(name);
            System.out.println(JSON.toJSONString(result1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class User {
        private String name;
        private int age;
    }


    public static class MyTypeReference<T> extends TypeReference<T> {
        public MyTypeReference() {
            super();
        }
    }


    public static <T> Type getType(T t) {
        Type superClass = t.getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        return type;
    }


    public static List<User> test2() {
        return null;
    }


    public static Map<Integer, User> test3() {
        return null;
    }

    public static Map<Integer, Map<Integer, User>> test4() {
        return null;
    }


    public static Type getType2(String methodName) throws NoSuchMethodException {
        //Type result = null;
        Method method = SpELTest.class.getMethod(methodName);
        Type returnType = method.getGenericReturnType();// 获取返回值类型

        ResolvableType resolvableType = ResolvableType.forMethodReturnType(method);
        ParameterizedType type = (ParameterizedType) resolvableType.getType();
        //ParameterizedType type2 = (ParameterizedType) type.getActualTypeArguments()[1];

        if (type.getRawType().getTypeName().equals("java.util.Map")) {
            return type.getActualTypeArguments()[1];
        } else {
            return type;
        }

//        if (type instanceof ParameterizedType) { // 判断获取的类型是否是参数类型
//            System.out.println(type);
//            Type[] typesto = ((ParameterizedType) type).getActualTypeArguments();// 强制转型为带参数的泛型类型，
//            // getActualTypeArguments()方法获取类型中的实际类型，如map<String,Integer>中的
//            // String，integer因为可能是多个，所以使用数组
//            for (Type type2 : typesto) {
//                System.out.println("泛型类型" + type2);
//            }
//            result = typesto[0];
//        }

        //ParameterizedType parameterizedType = (ParameterizedType) type;

        //Type argType = parameterizedType.getActualTypeArguments()[0];
        //Type rawType = parameterizedType.getRawType();
        //Type[] argTypes = parameterizedType.getActualTypeArguments();

//        int actualIndex = 0;
//        for (int i = 0; i < argTypes.length; ++i) {
//            if (argTypes[i] instanceof TypeVariable) {
//                argTypes[i] = actualTypeArguments[actualIndex++];
//                if (actualIndex >= actualTypeArguments.length) {
//                    break;
//                }
//            }
//        }

        //Type key = new ParameterizedTypeImpl(argTypes, SpELTest.class, rawType);

        //return parameterizedType;
    }


}
