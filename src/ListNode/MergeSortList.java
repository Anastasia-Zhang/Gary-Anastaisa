package ListNode;

import common.ListNode;

public class MergeSortList {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pre = null;
        ListNode head = null;
        while (l1 != null && l2 != null) {
            ListNode node = null;
            if (l1.val <= l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (pre == null) {
                pre = node;
                head = node;
            }
            else {
                pre.next = node;
                pre = node;
            }
        }
        // l1 链表遍历完 l2 链表没有遍历完
        if (l1 == null) {
            pre.next = l2;
        }
        if (l2 == null) {
            pre.next = l1;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
