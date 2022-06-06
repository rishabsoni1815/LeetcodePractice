/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    //following the process of linearising child and connecting it b/w list - {1->2->3->7->8->9->10->4->5->->6   then 1->2->3->7->8->9->11->12->10->4->5->->6}
    public Node flatten(Node head) {
        if(head==null) return null;
        Node temp=head;
        while(temp!=null){
            if(temp.child==null){
                temp=temp.next;
            }else{
                Node cur=temp.child;
                while(cur.next!=null){
                    cur=cur.next;
                }
                cur.next=temp.next;
                if(temp.next!=null) temp.next.prev=cur;
                temp.next=temp.child;
                temp.child.prev=temp;
                temp.child=null;
            }
        }
        return head;
    }
}