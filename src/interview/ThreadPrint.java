package interview;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrint {


    private AtomicInteger value = new AtomicInteger(0);
    private static final int SYC_VALUE = 30;

    // 定义3个任务，三个任务分别打印XYZ
    private class RunnableX implements Runnable {
        @Override
        public void run(){
            while (value.get() < SYC_VALUE){
                if (value.get() % 3 == 0){
                    System.out.println("X");
                    value.getAndIncrement();
                }
            }
        }
    }

    private class RunnableY implements Runnable {
        @Override
        public void run(){
            while (value.get() < SYC_VALUE){
                if (value.get() % 3 == 1){
                    System.out.println("Y");
                    value.getAndIncrement();
                }
            }
        }
    }

    private class RunnableZ implements Runnable {
        @Override
        public void run(){
            while (value.get() < SYC_VALUE){
                if (value.get() % 3 == 2){
                    System.out.println("Z");
                    value.getAndIncrement();
                }
            }
        }
    }

    public static void main(String[] args){
        ThreadPrint print = new ThreadPrint();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(print.new RunnableX());
        service.execute(print.new RunnableY());
        service.execute(print.new RunnableZ());
        service.shutdown();
    }
}


