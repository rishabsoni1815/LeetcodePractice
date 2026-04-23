class Solution {
    int cnt=0;
    public String longestWord(String[] a) {
        int n=a.length;
        Trie t=new Trie(26);
        cnt=0;
        Arrays.sort(a);
        int ans=0;
        String s="";
        for(int i=0;i<a.length;i++){
            cnt=0;
            t.insert(a[i]);
            // System.out.println(cnt+" "+a[i]+" "+s);
            if(cnt==a[i].length()-1) {
                if(ans<a[i].length()){
                    ans=a[i].length();
                    s=a[i];
                }
            }
        }
        return s;
    }
    class Trie{
        Node node;
        int n;
        Trie(int n){
            this.n=n;
            node=new Node(n);
        }
        void insert(String s){
            Node cur=node;
            for(int i=0;i<s.length();i++){
                if(cur.c[s.charAt(i)-'a']!=null){
                    cur=cur.c[s.charAt(i)-'a'];
                }else{
                    cur.c[s.charAt(i)-'a']=new Node(n);
                    cur=cur.c[s.charAt(i)-'a'];
                }
                if(cur.end==true) cnt++;
            }
            cur.end=true;
        }
        boolean isWord(String s){
            Node cur=null;
            for(int i=0;i<s.length();i++){
                if(node.c[s.charAt(i)-'a']!=null){
                    cur=node.c[s.charAt(i)-'a'];
                }else{
                    node.c[s.charAt(i)-'a']=new Node(n);
                    cur=node.c[s.charAt(i)-'a'];
                }
            }
            return cur.end;
        }
    }
    class Node{
        Node c[];
        boolean end;
        Node(int n){
            c=new Node[n];
        }
    }
}