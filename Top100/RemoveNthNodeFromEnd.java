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
//TC:O(N)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int lengthOfLL = 0;
        ListNode temp = head;
        if(head == null) {
            return null;
        }
        while (temp!=null) {
            lengthOfLL++;
            temp = temp.next;
        }
        temp =head;
        int nTHNodeFromStart = lengthOfLL - n;
        if (nTHNodeFromStart < 0) {
            return null;
        }
        if (nTHNodeFromStart == 0 ){
            return head.next;
        }
        ListNode prev = null;
        while(nTHNodeFromStart > 0 && temp != null){
            nTHNodeFromStart--;
            prev = temp;
            temp =temp.next;
        }
        if (temp!= null){
            prev.next = temp.next;
        }
        else {
            prev.next = null;
        }
        
        return head;
    }
}
