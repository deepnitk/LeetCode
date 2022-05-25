//Divide and Conquer Tech
//TC: O(NLOGK)

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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        else if (k == 1) {
            return lists[0];
        }
        ListNode head, h1, h2, ptr;
        head = h1 = h2 = null;
        //Merge 1st half
        h1 = merge(lists, 0, k/2);
        if (k/2 + 1 <= k-1) {
            //Merge 2nd half
            h2 = merge(lists, k/2+1, k-1);
        }

        //Merge h1 and h2 to head
        return mergeTwoSortedList(h1, h2);
    }

    public ListNode mergeTwoSortedList(ListNode l1 , ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode res = l1;
        while (l1 != null && l2 != null) {
            ListNode tmp = null;
            while(l1 != null && l1.val <= l2.val) {
                tmp = l1;
                l1 = l1.next;
            }
            tmp.next = l2;
            // Swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return res;

    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }

        int k = right - left + 1;
        ListNode head, h1, h2, ptr;
        head = h1 = h2 = null;
        h1 = merge(lists, left, left+k/2-1);
        h2 = merge(lists, left + k/2, right);

        return mergeTwoSortedList(h1, h2);
    }
}

