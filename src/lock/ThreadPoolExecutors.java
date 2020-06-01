package lock;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/16 14:23
 */
public class ThreadPoolExecutors {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    private class ThreadPoolRunnable implements Runnable {
        // 大约每5秒中来执行任务
        private String command;

        public ThreadPoolRunnable(String s) {
            this.command = s;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " " + command
                    + " Start. Time = " + new Date());
            processCommand();
            System.out.println(Thread.currentThread().getName() + " " + command
                    + " End. Time = " + new Date());
        }

        private void processCommand() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return this.command;
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutors myRunnable = new ThreadPoolExecutors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
              CORE_POOL_SIZE,
              MAX_POOL_SIZE,
              KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        // 创建10个执行的任务
        // 其中核心线程数为5也就是说只有五个线程能够并发执行，剩下的线程来了会被加入等待队列
        // 只有五个核心线程中的1个线程执行完任务，这个线程就再去等待队列当中去取线程
        for (int i = 0; i < 10; i++){
            executor.execute(myRunnable.new ThreadPoolRunnable("" + i));
        }

        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}






