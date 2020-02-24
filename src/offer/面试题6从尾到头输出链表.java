package offer;

import common.ListNode;

import java.util.Stack;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/22 14:38
 */
public class 面试题6从尾到头输出链表 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }

        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            res[index++] = stack.pop();
        }
        return res;
    }



    public void reversePrint2(ListNode head) {
        if (head != null){
            if (head.next != null){
                reversePrint2(head.next);
            }
            System.out.println(head.val);
        }
    }
}
