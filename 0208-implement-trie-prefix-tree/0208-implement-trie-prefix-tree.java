class Trie {
    Node node;
    public Trie() {
        node=new Node(26);
    }
    public void add(Node node,int i,String s){
        if(i>=s.length()) {
            node.end=true;
            return;
        }
        char c=s.charAt(i);
        if(node.a[c-'a']==null){
            node.a[c-'a']=new Node(26);
        }
        add(node.a[c-'a'],i+1,s);
    }
    public void insert(String word) {
        add(node,0,word);
    }
    
    public boolean search(String word) {
        Node cur=this.node;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.a[c-'a']!=null){
                cur=cur.a[c-'a'];
            }else{
                return false;
            }
        }
        return cur.end==true;
    }
    
    public boolean startsWith(String word) {
        Node cur=this.node;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.a[c-'a']!=null){
                cur=cur.a[c-'a'];
            }else{
                return false;
            }
        }
        return true;
    }
}
class Node{
    Node a[];
    boolean end;
    Node(int n){
        a=new Node[n];
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */