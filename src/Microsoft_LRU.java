import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/12 16:01
 */
public class Microsoft_LRU {

}

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
// The cache is initialized with a positive capacity.
// Follow up:
// Could you do both operations in O(1) time complexity?
// Example:
// LRUCache cache = new LRUCache( 2 /* capacity */ );
// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4
// 存储数据的结点
class LinkedNode{
    int key;
    int value;
    // 其他信息
    public LinkedNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {

    HashMap<Integer, LinkedNode> map = new HashMap();
    int capacity;
    // 双向链表
    LinkedList<LinkedNode> linkedList = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    public int get(int key) {
        // 先去map中取数据
        LinkedNode node = map.get(key);
        if (node == null) return -1;
        // 调整链表结构,把该节点从链表中删除后再插入头结点
        linkedList.remove(node);
        linkedList.addFirst(node);
        return node.value;

    }



    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if (node != null){
            // 设置新的值
            node.value = value;
            // 把该节点从链表删除后再插入头结点
            linkedList.remove(node);
            linkedList.addFirst(node);
        } else {
            // 新建结点
            LinkedNode newNode = new LinkedNode(key, value);
            // 判断容量
            if (map.size() == capacity){
                // 删除最后的结点
                LinkedNode delNode = linkedList.pollLast();
                // 删除 map
                map.remove(delNode.key);
            }
            // 直接插入头部
            linkedList.addFirst(newNode);
            // 在 map 中加入结点
            map.put(key,newNode);
        }
    }
}



/**

 * Your LRUCache object will be instantiated and called as such:

 * LRUCache obj = new LRUCache(capacity);

 * int param_1 = obj.get(key);

 * obj.put(key,value);

 */
