package ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/11 14:58
 */
public class DynamicAgent {
    // 实现InvocationHandler接口，并且可以初始化被代理类的对象
    // 将自定义的 InvocationHandler 封装到代理类里，将创建的代理类对象返封装到一个方法内
    static class MyHandler implements InvocationHandler {
        private Object proxy;
        public MyHandler(Object proxy) {
            this.proxy = proxy;
        }

        //自定义invoke方法
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>before invoking");
            //真正调用方法的地方
            Object ret = method.invoke(this.proxy, args);
            System.out.println(">>>>after invoking");
            return ret;
        }
    }

    //返回一个被修改过的对象
    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                new MyHandler(proxy));
    }
}
