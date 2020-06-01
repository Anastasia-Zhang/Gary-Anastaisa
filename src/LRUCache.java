import org.omg.CORBA.ObjectHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/8 15:26
 */
public class LRUCache {
    // 最近最少使用算法
    // 初始化一个容量 有 put 和 get 操作
    // put :
    // （1）如果 put 的元素已经在链表当中了，
    // 那么就把链表当中最旧的元素删除，把最新的元素添加到表头
    // (2) 如果 put 的元素不存在，那么先看缓冲器是否满了，若缓冲区满，则淘汰掉链表最末尾的元素，将新的数据插入到开头的结点
    // get : 不存在返回 -1， 存在返回value，删掉
    // 基本的数据结构 双向链表（查找删除方便） + HashMap （实现 O(1））的查找
    Map<String, LRUNode> cacheMap = new HashMap<>();
    LRUNode head;
    LRUNode tail;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    /** put 值
     * 如果已经存在于链表之中了（根据key来判断），覆盖旧值，我们需要把这个结点从链表中久的数据删除，然后把新的数据插入到链表的头部
     * 如果不存在，我们我们需要判断下缓存区是否已满，如果满的话，则把链表尾部的节点删除，之后把新的数据插入到链表头部。如果没有满的话，直接把数据插入链表头部即可
     * @param key key
     * @param value valeu
     */
    public void put(String key, Object value){
        if (key == null || value == null) {
            throw new RuntimeException("插入无效的 key-value 值");
        }
        LRUNode node = cacheMap.get(key);
        // 如果 key 存在，找到这个元素，删掉，将新元素插入头部
        // 如果 key 不存在，判断缓存是否满，满了之后删掉链表尾部元素
        if (node != null) {
            // 更新值 !! 因为查找的是key相等，可能插入相同的key 不同的值，想想 HashMap 的源码
            node.value = value;
            // 把他从链表中删除插入到头结点
            deleteAndInsert(node);
        } else {
            // 原先没有元素
            LRUNode newNode = new LRUNode(key, value);
            if (head == null) {
                // 无元素，直接新建结点插入
                head = newNode;
                tail = newNode;
            } else {
                // 判断缓冲区是不是满
                if (cacheMap.size() >= capacity) {
                    // 缓冲区满了 删除尾结点，插入新节点
                    cacheMap.remove(tail.key); // 不能忘记缓存和链表要同步！！
                    tail = tail.pre;
                    tail.next = null; // 不能忘记！！
                    //insertFirstNode(newNode);
                } //else {
                // 缓冲区不满，直接插到头部
                insertFirstNode(newNode);
                //}

            }
            // 最后放在缓冲里面
            cacheMap.put(key, newNode);
        }
    }

    /** put 值
     * 如果有这个数据，就返回该数据，并且调整该数据再链表中的位置（删掉原有的位置，插入到表头
     * 如果不存在，返回-1
     * @param key key
     */
    public Object get(String key){
        LRUNode node = cacheMap.get(key);
        if (node == null) return -1;
        deleteAndInsert(node);
        return node.value;
    }


    private void insertFirstNode(LRUNode node){
        node.next = head;
        head.pre = node;
        head = node;
    }

    private void deleteAndInsert(LRUNode node){
        // LRUNode cur = head;
        // 删除指定的结点
        // 你是傻子吗？？双向链表你还遍历个啥
//        while (cur != null && !cur.key.equals(node.key)){
//            cur = cur.next;
//        }
        // 删除当前结点
        // 判断是否是头部和尾部两个特殊位置
        if (node == head) {
            return;
        }
        else if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 插入头结点
        insertFirstNode(node);
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put("1",1);
        cache.put("2",1);
        System.out.println(cache.get("1"));
        cache.put("3",3);
        System.out.println(cache.get("2"));
    }

}

// HashMap + 双向链表
class LRUNode{
    String key;
    Object value;
    LRUNode next;
    LRUNode pre;

    public LRUNode(String key, Object value){
        this.key = key;
        this.value = value;
    }
}
