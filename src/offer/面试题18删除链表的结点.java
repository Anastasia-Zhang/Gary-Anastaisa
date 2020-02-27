package offer;

import common.ListNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/26 17:50
 */
public class 面试题18删除链表的结点 {
    public ListNode deleteNode(ListNode head, int val) {
        // 链表为空
        if (head == null) return null;
        // 链表只有一个结点
        if (head.next == null && head.val == val) return null;
        // 大于一个结点，删除链表头结点元素
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode preNode = head;
        ListNode node = head.next;

        // 结点大于三个的情况
        while (node.next != null){
            // preNode = node;
            if (node.val == val){
                preNode.next = node.next;
                return head;
            }
            preNode = node;
            node = node.next;
        }

        // 如果是删除最后一个结点
        if (node.val == val) {
            preNode.next = null;
        }
        return head;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        // 链表为空
        if (head == null) return null;
        // 如果要删除第一个结点
        if (head.val == val) return head.next;

        ListNode pre = null;
        ListNode cur = head;
        // 找到删除链表的前一个结点
        while (cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        // 是不是最后一个结点
        if (cur.next == null) pre.next = null;
        else pre.next = cur.next;
        return head;
    }
}
