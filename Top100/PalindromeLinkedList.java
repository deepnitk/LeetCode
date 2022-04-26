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
    public boolean isPalindrome(ListNode head) {
        //get middle node of Linked List
        ListNode middleNode = getMiddleNode(head);
        //point middleNode to reverse of 2nd half of linked list(which starts with middle node's next)
        middleNode.next = reverseList(middleNode.next);
        //move middle node to 2nd half
        middleNode= middleNode.next;
        while(middleNode !=null){
            if(head.val != middleNode.val){
                return false;
            }
            head=head.next;
            middleNode=middleNode.next;
        }
        return true;
    }
    
    private ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummy = null;

        while(head != null){
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}
