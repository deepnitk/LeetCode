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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode sorted;
        if(temp1.val<=temp2.val){
            sorted = new ListNode(temp1.val, null);
            temp1=temp1.next;
        }
        else{
            sorted = new ListNode(temp2.val, null);
            temp2=temp2.next;
        }
        ListNode head = sorted;
        

        while(temp1!= null && temp2!=null){
            if(temp1.val<=temp2.val){
                sorted.next = temp1;
                sorted=sorted.next;
                temp1 = temp1.next;
            }
            else{
                sorted.next = temp2;
                sorted=sorted.next;
                temp2= temp2.next;
            }
        }
        
        if(temp1!=null)
            sorted.next = temp1;
        if(temp2!=null)
            sorted.next = temp2;
        
        return head;
        
      
    }
}
