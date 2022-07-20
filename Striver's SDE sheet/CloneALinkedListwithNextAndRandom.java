/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Step 1: create deep copy of each node and make original .next = newNode;
        Node itr = head;
        Node front = head;
        while(itr != null) {
            front = itr.next;
            Node copiedNode = new Node(itr.val);
            itr.next = copiedNode;
            copiedNode.next = front;
            itr = front;
        }
        
        //Step 2: Point random Pointer of deep copy node here itr.next = copy of itr
        itr = head;
        while (itr != null) {
            if (itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }
        
        //Step 3: Take dummy node and point next nodes. Here copy is keeping track of new Nodes and             front is traversing the old nodes
        itr = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        
        while (itr != null) {
            front = itr.next.next;
            copy.next = itr.next;
            itr.next = front;
            copy = copy.next;
            itr = itr.next;
        }
        return dummy.next;
        
    }
}
