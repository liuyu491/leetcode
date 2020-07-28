package Swordmeansoffer66;

import utils.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur!=null){
            cur.next = pre;
            if(next!=null){
                next = next.next;
            }

        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
