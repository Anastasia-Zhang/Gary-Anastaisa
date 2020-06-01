package lock;

import java.util.IdentityHashMap;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/19 17:38
 */
public class Volatile_op_noSafe {
    public static volatile int race = 0;
    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        // 定义 20 个线程，每个线程都对 race 进行 10000 个自增操作
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有的线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
