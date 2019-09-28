package chenfu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/18 12:16
 */
public class ArrayTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List proxyList = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(list, args);
            }
        });
        proxyList.add(123);
        System.out.println(proxyList);

    }
}
