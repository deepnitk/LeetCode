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

//Dummy node at both head, in longer LL MOVE dummy node to l1-l2 pos
//TC:O(2M)
//SC:O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        ListNode temp1 = headA;
        while(temp1 != null){
           l1++;
            temp1= temp1.next;
        }
        temp1 = headA;
        int l2 = 0;
        ListNode temp2 = headB;
        while(temp2!=null){
            l2++;
            temp2=temp2.next;
        }
        temp2 = headB;
        int initialShift = Math.abs(l1-l2);
        if(l1>l2){
            while(initialShift > 0){
                temp1=temp1.next;
                initialShift--;
            }
        }
        else {
            while(initialShift > 0){
                temp2=temp2.next;
                initialShift--;
            }
        }
        while(temp1!=null){
            if(temp1==temp2) return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
}

//Optimal Solution

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while(a!=b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
