// Brute force using HashSet'
//TC:O(N) SC:O(N1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode tempA = headA;
        while (tempA != null) {
            hs.add(tempA);
            tempA = tempA.next;
        }
        
        ListNode tempB = headB;
        while (tempB != null) {
            int val = tempB.val;
            if( hs.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        
        return null;
    }
}
