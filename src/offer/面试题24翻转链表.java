package offer;

import common.ListNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/26 19:47
 */
public class 面试题24翻转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            // ListNode node = cur; // 操作错误，引用关系，对于 node 的操作 也都是对cur 的操作
            // 保存三个结点：当前结点，前一个结点 后一个结点
            // 保存后一个结点，用于防止链表断开
            // 操作的是当前结点而不是他后面的结点
            ListNode node = cur.next;
            // 将当前结点的指针指向前一个结点
            cur.next = pre;
            // 把前一个移动到当前结点
            pre = cur;
            // 当前结点等于后一个结点
            cur = node;
        }
        return pre;
    }

    // 递归解法：
    /**
     * 这个函数的作用是返回以head为头结点的翻转链表
     * @param head 链表的头结点
     * @return 该链表翻转后的链表
     */
    public ListNode reverseNode(ListNode head){
        // 递归出口
        if (head == null || head.next == null) return head;
        // 反转 head 后面的链表 原链表：1->2->3->4 head = 1 翻转后 1->2<-3<-4
        ListNode reversedHead = reverseList(head.next);
         // 获取翻转链表的尾部
        ListNode reversedTail = head.next;
        // 处理翻转后链表尾部和头结点之间的关系
        reversedTail.next = head;
        head.next = null;
        return reversedHead;
    }

}
