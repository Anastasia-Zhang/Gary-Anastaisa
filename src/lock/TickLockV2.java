package lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 14:01
 */
public class TickLockV2 {
    // 服务号
    private AtomicInteger serviceId = new AtomicInteger();
    // 排队号
    private AtomicInteger ticketId = new AtomicInteger();

    // 用于存储每一个线程的排队号
    private ThreadLocal<Integer> ticketIHolder = new ThreadLocal<>();

    // 获取锁，获取成功返回当前排队号用于释放锁
    public void lock(){
        // 获取锁的时候，将当前线程的排队号保存起来
        int currentTicketId = ticketId.incrementAndGet();
        ticketIHolder.set(currentTicketId);
        // 服务号和排队号相等的时候才能获得锁
        while (currentTicketId != serviceId.get()){
            // do nothing
        }
    }

    // 释放锁，传入的是当前持有的排队号, 也就是加锁后返回的排队号
    // 服务完成，把自己的服务号+1
    public void unlock(){
        int curTicketId = ticketIHolder.get();
        serviceId.compareAndSet(curTicketId, curTicketId + 1);
    }
}
