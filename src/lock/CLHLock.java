package lock;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 15:17
 */
public class CLHLock {

    // 定义一个结点，默认的lock状态为true
    public static class CLHNode{
        private volatile boolean isLocked = true;
    }

    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();
    /**
     *   一个基于反射的工具类，它能对指定类的指定的volatile引用字段进行原子更新。
     *   通过调用AtomicReferenceFieldUpdater的静态方法newUpdater就能创建它的实例
     *   该方法接收三个参数：
     *     包含该字段的对象的类
     *     将被更新的对象的类
     *     将被更新的字段的名称
     */
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class,"tail");

    public void lock(){
        // 新建结点并将结点与当前线程保存起来
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        // 将新建结点设为尾部结点，并返回旧的结点（原子操作）旧的结点相当于当前结点的前驱结点
        CLHNode preNode = UPDATER.getAndSet(this, node);

    }
}
