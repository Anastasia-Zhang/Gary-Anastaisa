package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/16 13:59
 */
public class Atomic_ABC {
    private AtomicInteger ai = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = 3 * 10; // 最大并发数

    // 定义三个任务
    private class RunnableA implements Runnable{
        @Override
        public void run() {
            // 线程 A --> 打印A
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 0){
                    System.out.println("A");
                    ai.getAndIncrement();
                }
            }
        }
    }

    private class RunnableB implements Runnable{
        @Override
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 1){
                    System.out.println("B");
                    ai.getAndIncrement();
                }
            }
        }
    }
    private class RunnableC implements Runnable{
        @Override
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 2){
                    System.out.println("C");
                    ai.getAndIncrement();
                }
            }
        }
    }

    public static void main(String[] args) {
        Atomic_ABC atomic_abc = new Atomic_ABC();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 1000000000; i++){
            service.execute(atomic_abc.new RunnableA());
            service.execute(atomic_abc.new RunnableB());
            service.execute(atomic_abc.new RunnableC());
        }
        service.shutdown();
    }

}
