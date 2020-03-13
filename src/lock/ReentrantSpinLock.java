package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 13:07
 */
public class ReentrantSpinLock {
    // 如果第二次获得锁的话采用第一次的方法，就无法进入，即使可以进入，释放锁的时候也会把第一次的锁也释放掉
    private AtomicReference<Thread> cas = new AtomicReference<>();
    // 引入计数器 要不要 volatile
    private int count = 0;
    public void lock(){
        Thread current = Thread.currentThread();
        // 判断当前线程是否已经获得了锁，若获得了锁，锁计数器 +1
        if (current == cas.get()) {
            count++;
            return;
        }
        while (!cas.compareAndSet(null, current)){
            // do nothing
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        // 判断申请释放锁的当前线程是否是自己的线程
        if (current == cas.get()){
            // 如果锁的计数器大于0 代表多个线程释放了该锁，通过count-1来模拟
           if  (count > 0){
               count--;
           } else {
               // count == 0 直接释放掉
               cas.compareAndSet(current, null);
           }
        }
    }
}
