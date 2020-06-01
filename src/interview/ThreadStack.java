package interview;

import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/30 23:28
 */
//问答题1：下面的代码在绝大部分时间内都运行得很正常，请问在什么情况下会出现问题？问题的根源在哪里？尽可能多的说出原因！程序理论上因该怎么写？
public class ThreadStack {
    LinkedList list = new LinkedList();
    public synchronized void push(Object x) {
        synchronized(list) {
            list.addLast( x );
            notify();
        }
    }

    public synchronized Object pop()
            throws Exception {
        synchronized(list) {
            // while 如果该线程if之后可能容器会为0因此使用while
            if( list.size() <= 0 ) {
                wait();
            }
            return list.removeLast();
        }
    }
}
