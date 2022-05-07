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
//TC:O(2N)

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

//Optimal
//TC:O(N)

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        
        for(int i = 1;i<=n;i++){
            fast=fast.next;
        }
        
        while(fast.next!=null){
            slow=slow.next;
            fast= fast.next;
        }
        
        slow.next = slow.next.next;
        
        
        return dummyNode.next;
    }
}
