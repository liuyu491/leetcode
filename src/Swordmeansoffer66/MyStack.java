package Swordmeansoffer66;

public class MyStack {

    private class ListNode{
        private ListNode next;
        private int val ;
        ListNode(int val){
            this.val = val;
        }
    }
    private ListNode tail  = null;
    private ListNode minNode = null;
    public void push(int node) {
        if(tail == null){
            tail = new ListNode(node);
            minNode = tail;
        }else{
            ListNode temp = new ListNode(node);
            temp.next = tail;
            tail = temp;
            minNode = findMin(tail);
        }
    }

    public void pop() {
        tail = tail.next;
    }

    public int top() {
        return tail.val;
    }

    public int min() {
        return minNode.val;
    }
    private ListNode findMin(ListNode tail){
        ListNode cur = tail;
        ListNode min = tail;
        while(cur!=null){
            cur = cur.next;
            if(cur!=null&&cur.val<min.val){
                min = cur;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        System.out.println(myStack.min());
        myStack.push(4);
        System.out.println(myStack.min());

    }
}
