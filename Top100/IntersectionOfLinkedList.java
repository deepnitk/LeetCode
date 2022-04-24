//HasSet solution
//TC:O(N)
//SC:O(N)
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
        ListNode temp1 = headA;
        while(temp1 != null){
            hs.add(temp1);
            temp1= temp1.next;
        }
        ListNode temp2 = headB;
        while(temp2!=null){
            if(hs.contains(temp2))
                return temp2;
            hs.add(temp2);
            temp2=temp2.next;
        }
        return null;
    }
}
