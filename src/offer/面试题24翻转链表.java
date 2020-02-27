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
}
