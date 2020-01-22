package common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    private static ListNode initListNode(int[] listData){
            ListNode head = new ListNode(listData[0]);
            ListNode p = head;
            for(int i = 1; i < listData.length; i ++){
                p.next = new ListNode(listData[i]);
                p = p.next;
            }
        return head;
    }
}
