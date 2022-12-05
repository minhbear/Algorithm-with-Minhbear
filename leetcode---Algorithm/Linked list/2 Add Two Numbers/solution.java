class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cary = 0;
        ListNode currResult, result = new ListNode(0);
        currResult = result;

        while(l1 != null || l2 != null || cary != 0){
            if(l1 != null){
                cary += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                cary += l2.val;
                l2 = l2.next;
            }

            currResult.next = new ListNode(cary%10);
            cary = cary/10;
            currResult = currResult.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);ListNode l3 = new ListNode(4);ListNode l5 = new ListNode(3);
        l1.next = l3; l3.next = l5;
        ListNode l2 = new ListNode(5);ListNode l4 = new ListNode(6);ListNode l6 = new ListNode(4);
        l2.next = l4; l4.next = l6;
        ListNode result = addTwoNumbers(l1, l2);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}