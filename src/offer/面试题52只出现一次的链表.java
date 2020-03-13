package offer;

import common.ListNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 17:31
 */
public class 面试题52只出现一次的链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null || p2 != null) {
            if (p1 == p2) return p1;
            // if (p1 == null) p1 = headB;
            // if (p2 == null) p2 = headA;
            // 当链表投重置的时候不应该再往下走了
            // [3] [2, 3]
            // p1 = p1.next;
            // p2 = p2.next;
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null || p2 != null) {
            // 要不然其中一个指针换头的时候就不再往后移
            // 要不然就在换头之后判断两个链表相不相等，不相等再一起往后移

            if (p1 == null) p1 = headB;
            if (p2 == null) p2 = headA;
            // 当链表投重置的时候不应该再往下走了
            // [3] [2, 3]
            // 我把链表移位之后再判断相不相等，相等直接 return 掉
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
            // p1 = p1 == null ? headB : p1.next;
            // p2 = p2 == null ? headA : p2.next;
        }
        return null;
    }
}
