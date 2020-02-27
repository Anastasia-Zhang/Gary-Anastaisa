package offer;

import common.ListNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/26 20:15
 */
public class 面试题25合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0); // 新建一个头结点
        ListNode p = node;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        // 遍历完看那个还有剩余的结点，若有剩余的结点就将其加到末尾
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return node.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 递归做法
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode mergeHead = null;
        if (l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
