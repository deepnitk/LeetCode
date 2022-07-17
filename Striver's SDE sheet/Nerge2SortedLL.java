//Brute force
//TC: o(n1 + n2)
//sc:o(n1+n2)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null )
            return l2;
        if (l2 == null) 
            return l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode sortedHead = new ListNode(0);
        ListNode newNode;
        if (head1.val > head2.val) {
            newNode = new ListNode(head2.val, null);
            head2 = head2.next;
        }
        else {
            newNode = new ListNode(head1.val, null);
            head1 = head1.next;
        }
        sortedHead.next = newNode;
        ListNode sorted = newNode;
        
        while (head1 != null && head2 != null) {
            ListNode node;
            if (head1.val > head2.val) {
                node = new ListNode(head2.val, null);
                head2 = head2.next;
            }
            else {
                node = new ListNode(head1.val, null);
                head1 = head1.next;
            }
            sorted.next = node;
            sorted = sorted.next;
        }
        while(head1 != null){
            ListNode node = new ListNode(head1.val, null);
            head1 = head1.next;
            sorted.next = node;
            sorted = sorted.next;
        }
        while(head2 != null){
            ListNode node = new ListNode(head2.val, null);
            head2 = head2.next;
            sorted.next = node;
            sorted = sorted.next;
        }
        return sortedHead.next;
    }
}

//Optimal solution with extra space
//TC: o(n1 + n2)
//sc:O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null )
            return l2;
        if (l2 == null) 
            return l1;
        
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        ListNode res = l1;
        
        while (l1 != null && l2 != null) {
            ListNode tmp = null;
            while (l1 != null && l1.val <= l2.val) {
                tmp = l1;
                l1 = l1.next;
            }
            tmp.next = l2;
            
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return res;
    }
}
