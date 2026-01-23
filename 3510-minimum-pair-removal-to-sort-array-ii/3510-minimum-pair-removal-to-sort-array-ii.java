class Solution {
    public int minimumPairRemoval(int[] a) {
        TreeSet<Node>set=new TreeSet<>((x,y)-> (x.nextSum!=y.nextSum) ? (Long.compare(x.nextSum,y.nextSum)) : (Integer.compare(x.idx,y.idx)));
        int bad=0;
        Node prev=null;
        for(int i=0;i<a.length;i++){
            Node node=new Node((long)a[i],(long)a[i],i);
            if(i<a.length-1) node.nextSum+=a[i+1];
            node.prev=prev;
            if(prev!=null) prev.next=node;
            prev=node;
            if(i<a.length-1 && a[i]>a[i+1]) bad++;
            if(i<a.length-1) set.add(node);//tail cant be in set since its next is null so no next sum
        }
        int cnt=0;
        while(bad>0){
            Node min=set.first();
            bad = update(min,set,bad);
            cnt++;
        }
        return cnt;
    }
    int update(Node min,TreeSet<Node>set,int bad){
        Node left=min.prev;
        Node right=min.next;
        Node farRight=right.next;
        
        if(min.val>right.val) bad--;
        if(left!=null && left.val>min.val) bad--;
        if (farRight != null && right.val > farRight.val) bad--;
        
        set.remove(min);
        if(left!=null) set.remove(left);
        set.remove(right);

        long nsum=min.nextSum+right.nextSum-right.val;
        min.val=min.nextSum;
        min.nextSum=nsum;
        if(left!=null) left.nextSum=left.val+min.val;
        min.next=farRight;
        if(farRight!=null) farRight.prev=min;

        if(min.next!=null && min.val>min.next.val) bad++;
        if(left!=null && left.val>left.next.val) bad++;

        if(left != null) set.add(left);
        if(min.next != null) set.add(min);//tail cant be in set since its next is null so no next sum

        return bad;
    }
    class Node{
        long val;
        long nextSum;
        Node prev;
        Node next;
        int idx;
        Node(long val,long nextSum,int idx){
            this.val=val;
            this.nextSum=nextSum;
            this.idx=idx;
        }
    }
}