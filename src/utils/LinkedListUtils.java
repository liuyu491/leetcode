package utils;

/*链表工具类*/
public class LinkedListUtils {
    public static ListNode createLinkedListFromArray(Integer[] array){
        ListNode vhead = new ListNode(0);
        ListNode cur = vhead;
        for (int i = 0; i < array.length; i++) {
            int v = array[i];
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return vhead.next;
    }

    public static String stringfyListNode(ListNode head){
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur!=null){
            sb.append(cur.val);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        ListNode listNode = createLinkedListFromArray(arr);
        System.out.println(stringfyListNode(listNode));
    }
}
