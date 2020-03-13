package offer;

import java.util.HashMap;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/4 18:46
 */
public class 面试题35复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        // 复制中心节点，用 hashMap 存储旧节点和新节点之间的关系
        if (head == null) return null;
        // key : 旧的结点的值 value: 新的结点的值
        HashMap<Node, Node> nodeMap = new HashMap<>();
        // 遍历旧的结点，复制各个结点并用 next 指针连接起来
        // 这里要记录遍历结点的前驱结点，用于处理上一个结点的 next 指针
        Node pre = null;
        Node preOld = null;
        Node cur = head;
        while (cur != null){
            // 新建结点
            Node newNode = new Node(cur.val);
            // 处理上一个结点的 next 指针
            if (pre != null) pre.next = newNode;
            // 将新节点和旧节点加入到 map 当中
            if (preOld != null) nodeMap.put(preOld, pre);
            pre = newNode;
            preOld = cur;
            cur = cur.next;
        }
        nodeMap.put(preOld, pre); // 处理最后的结点
        // 设置 random 指针
        // 遍历旧的链表
        cur = head;
        while (cur != null){
            // 直接从 map 中取值
            Node copyNode = nodeMap.get(cur);
            copyNode.random = nodeMap.get(cur.random);
            cur = cur.next;
        }

        //map中存的是(原节点，拷贝节点)的一个映射
//        Map<Node, Node> map = new HashMap<>();
//        for (Node cur = head; cur != null; cur = cur.next) {
//            map.put(cur, new Node(cur.val));
//        }
//        //将拷贝的新的节点组织成一个链表
//        for (Node cur = head; cur != null; cur = cur.next) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//        }

        return nodeMap.get(head);
    }

    public Node copyRandomList2(Node head) {

        if (head == null) return null;

        // 创建新节点，将新节点放在原来结点的后面
        Node cur = head;
        while (cur != null){
            Node newNode = new Node(cur.val);
            Node nextNode = cur.next;
            cur.next = newNode;
            newNode.next = nextNode;
            cur = nextNode;
        }

        // cur = head;
        // while (cur != null){
        //     System.out.println(cur.val);
        //     cur = cur.next;
        // }

        // 设置 random 指针 （注意不能和拆链表放在一块，放在一块的话万一 random 指针指向前面的结点，那前面的结点拆掉了就会造成错误）
        cur = head;
        while (cur != null){
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // 拆链表
        cur = head;
        Node nodeCopy = head.next; // 只要head 不变就可以
        Node temp = null;
        while (cur.next != null){
            // 以下代码只把旧的链表连接起来了，没有把新的链表连起来
            // cur.next = cur.next.next;
            // cur = cur.next;
            // 因此还是要每个链表都遍历
            temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return nodeCopy;
    }
}
