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
        if(head==null) return null;
        Node temp=head;
        while(temp!=null){
            Node copy=new Node(temp.val);
            Node nNext=temp.next;
            temp.next=copy;
            copy.next=nNext;
            temp=nNext;
        }
        temp=head;

        while(temp!=null){
            Node cur=temp.next;
            Node nNext=cur.next;
            if(temp.random!=null) cur.random=temp.random.next;
            temp=temp.next.next;
        }

        temp=head;
        Node dhead=head.next;
        while(temp!=null){
            Node cur=temp.next;
            Node nNext=cur.next;
            if(nNext!=null) cur.next=cur.next.next;
            temp.next=nNext;
            temp=nNext;
        }
        return dhead;
    }
}