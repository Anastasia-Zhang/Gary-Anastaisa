package lock;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 12:59
 */
public class SpinLock {
    // 自旋锁简单例子
    private AtomicReference<Thread> cas = new AtomicReference<>();
    public void lock(){
        Thread current = Thread.currentThread();
        while (!cas.compareAndSet(null, current)){
            // do nothing
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }

    // 分析：当第一个线程A获取锁的时候，如果能够成功获取到（当前线程为null的时候），
    // 不会进入 while 循环，此时会把当前线程由null变成线程A自己运行的线程
    // 线程 B 来获得锁，不满足 CAS 自旋直到A释放的锁
}
