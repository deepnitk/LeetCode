// Optimal approach
//tc: o(n)
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
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        //Stop fast at last or 2nd last pos
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the LL from MID + 1 pos
        slow.next = reverseList(slow.next);
        
        slow = slow.next;
        
        ListNode dummy = head;
        
        while (slow != null) {
            if (dummy.val != slow.val) {
                return false;
            }
            slow= slow.next;
            dummy = dummy.next;
        }
        
        return true;
    }
    
    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
