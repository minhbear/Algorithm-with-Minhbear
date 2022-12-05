public class solution {

    static public class ListNode {
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

    static public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        if(head.next == null) return head;
        else{
            ListNode curr = head;
            while(curr.next != null){
                if(curr.val == curr.next.val){
                    curr.next = curr.next.next;
                }else{
                    curr = curr.next;
                }
            }

            return head;
        }
    }

    static void printNode(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode result = deleteDuplicates(n1);
        printNode(result);
    }
}
