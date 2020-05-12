package ListNode;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // 使用最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        // 头结点
        ListNode dumpy = new ListNode(0);
        ListNode node = dumpy;
        // 先把 listNode 里面的每一个 ListNode 加入 优先级队列
        for (ListNode list : lists) {
            if (list != null) queue.offer(list);
        }
        // 循环处理 如果队列一直不为空
        while (!queue.isEmpty()) {
            // 取出比较小的链表的头结点
            node = queue.poll();
            dumpy.next = node;
            queue.offer(node.next);
        }
        return dumpy.next;
    }
}
