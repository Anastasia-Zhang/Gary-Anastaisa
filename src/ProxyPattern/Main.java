package ProxyPattern;

import ProxyPattern.Apple;
import ProxyPattern.DynamicAgent;
import ProxyPattern.Fruit;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/11 15:00
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //注意一定要返回接口，不能返回实现类否则会报错
        Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
        // 如果光将代理的内部类拿出来，那么当前类就为代理类，直接在main方法内返回代理对象
        // Friut fruit = Proxy.newProxyInstance(Reflect.class.getClassLoader(), new class[] {Friut}, new MyHandler(new ProxyPattern.Apple()));
        fruit.show();
        String path = "E:/$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Fruit.class.getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
