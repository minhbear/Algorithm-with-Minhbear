import java.util.Stack;

class _234_Palindrome_LinkedList{
    //Palindrome / ˈpalənˌdrōm / : đầu cuối giống nhau

    //This is not accept in program object orinted but for solution of this exercise
    //We declare one class inside another class. 
    //NOTE: DO NOT DECLARE LIKE THIS WHEN YOU PROGRAM ONE PROGRAMMING THAT IS OBJECT ORINTED !!!!
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Idea: We will use two pointer, one pointer is slow will go one step, one poiter is fast is go two step.
     * When fast go t the end of the list node or go out of the list so the slow are in the middle of the linklist
     * That time we will reverse all the node start from the slow to the end of the list so linklist will have two part is the head and the tail
     * Exp: 3 -> 2 -> 1 -> 1 -> 2 -> 3
     * when we traverse that fast is go to the end of the list or go out the end of the list
     * we will have pointer in there position
     * 3  ->  2  ->  1  ->  1  ->  2  ->  3  -> null
     *                    slow                  fast
     * We will reverse the list start from slow to the end and we have
     * 3  ->  2  ->  1  ->  3  ->  2  ->  1
     *                    slow
     * we asign fast to the head of the list again and we travle the list when slow is null
     * fast = fast.next; slow = slow.next
     * if we see the different value of fast and slow THAT IS FALSE
     * after travel is finsish so we return true    
     * 
     * 1 0 1 -> 1 1 0
     */

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){ //Odd node, let right half smaller
            slow = slow.next; 
        }

        slow = reverse(slow);
        fast = head;

        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    //reverse listNode
    static ListNode reverse(ListNode head) {
        ListNode preNode = null;
        while(head != null){
            ListNode next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }

        return preNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
        // ListNode n4 = new ListNode(1);
        n1.next = n2; 
        n2.next = n3; 
        // n3.next = n4;

        System.out.println(isPalindrome(n1));
    }
}