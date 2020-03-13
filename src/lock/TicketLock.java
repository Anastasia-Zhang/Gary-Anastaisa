package lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 13:25
 */
public class TicketLock {
    // 公平锁的问题
    // 思路：当前线程获取锁的时候，就给线程分配一个递增的id作为排队号，排队号递增
    // 锁对应一个服务好。每当有线程释放锁，服务号递增。
    // 此时如果服务号与排队号一致，那么该线程就获得锁，
    // 由于排队号是递增的，所以就保证了最先请求获取锁的线程可以最先获取到锁，就实现了公平性。

    // 可以想象成银行办理业务排队，排队的每一个顾客都代表一个需要请求锁的线程，
    // 而银行服务窗口表示锁，每当有窗口开始服务（加锁），先检查顾客的排队号和服务号是否一致，一致的话把顾客的排队号加1
    // 每当有窗口服务完成就把自己的服务号加一，此时在排队的所有顾客中，只有自己的排队号与服务号一致的才可以得到服务。

    // 服务号
    private AtomicInteger serviceId = new AtomicInteger();
    // 排队号
    private AtomicInteger ticketId = new AtomicInteger();

    // 用于存储每一个线程的排队号
    // private ThreadLocal<Integer> ticketIHolder = new ThreadLocal<>();

    // 获取锁，获取成功返回当前排队号用于释放锁
    public int lock(){
        // incrementAndGet CAS自增操作，如果成功返回自增之前的值
        // 得到自增之前的排队号，排队号自增说明当前线程正在加锁（接收服务）
        int currentTicketId = ticketId.incrementAndGet();
        // 服务号和排队号相等的时候才能获得锁
        while (currentTicketId != serviceId.get()){
            // do nothing
        }

        return currentTicketId; // 有风险，可能被修改。一旦排队号被修改锁不能正常释放
    }

    // 释放锁，传入的是当前持有的排队号, 也就是加锁后返回的排队号
    // 服务完成，把自己的服务号+1
    public void unlock(int curTicketId){
        serviceId.compareAndSet(curTicketId, curTicketId + 1);
    }
}
