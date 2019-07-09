package utils;

import edu.tongji.comm.spel.SpELTest;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-07-01
 */
public class ReflectUtils {

    public static Type getType(Method method) throws NoSuchMethodException {
        //Type type1 = method.getGenericReturnType();// 获取返回值类型

        ResolvableType resolvableType = ResolvableType.forMethodReturnType(method);
        Type type2 = resolvableType.getType();
        //判断获取的类型是否是泛型类型
        if (type2 instanceof ParameterizedType) {
            System.out.println(type2);
            Type[] typesto = ((ParameterizedType) type2).getActualTypeArguments();// 强制转型为带参数的泛型类型，
            // getActualTypeArguments()方法获取类型中的实际类型，如map<String,Integer>中的
            // String，integer因为可能是多个，所以使用数组
            for (Type item : typesto) {
                System.out.println("泛型类型" + item);
            }
        }
        return type2;
    }
}
