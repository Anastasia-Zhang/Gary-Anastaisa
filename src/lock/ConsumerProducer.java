package lock;

import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/4/5 14:57
 */
// 生产者和消费者线程同步
public class ConsumerProducer<T> {
    private final LinkedList<T> list = new LinkedList<>();

    private final int MAX = 10;
    private int count = 0;

    public LinkedList<T> getList() {
        return list;
    }

    public int getMAX() {
        return MAX;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void put(T t) throws InterruptedException {
        while (list.size() == MAX) {
            wait();
        }
        list.add(t);
        count++;
        System.out.println(Thread.currentThread().getName() + "生产, 当前容器剩余 " + getCount());
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (0 == list.size()) {
            this.wait();
        }
        T t = list.removeLast();
        count--;
        System.out.println(Thread.currentThread().getName() + "消费, 当前容器剩余 " + getCount());
        notifyAll();
        return t;
    }

    public static void main(String[] args) {
        ConsumerProducer<String> cp = new ConsumerProducer<>();

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
               while (true) {
                   try {
                       cp.put("");
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }, "c_thread_" + i).start();
        }

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        cp.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "p_thread_" + i).start();
        }
    }

}
