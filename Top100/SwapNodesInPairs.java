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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode currentNode = dummyNode;
        
        while(currentNode.next != null && currentNode.next.next != null) {
            ListNode firstNode = currentNode.next;
            ListNode secondNode = currentNode.next.next;
            firstNode.next = secondNode.next;
            currentNode.next = secondNode;
            currentNode.next.next = firstNode;
            currentNode = currentNode.next.next;
        }
        
        return dummyNode.next;
    }
}
