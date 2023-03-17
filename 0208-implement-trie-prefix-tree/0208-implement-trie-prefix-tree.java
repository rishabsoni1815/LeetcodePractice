class Trie {
    Node root=new Node();
    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
            Node curr=root;
        for(int i=0;i<word.length();i++){
            char f=word.charAt(i);
            if(curr.child[f-'a']==null){
                curr.child[f-'a']=new Node();
            }
            curr=curr.child[f-'a'];
        }
        curr.isWord=curr.isWord+1;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node r=getNode(word);
        return r == null ? false : r.isWord>0; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNode(prefix)!=null;
    }
    public boolean delete (String word){
            Node r=getNode(word);
            if(r==null) return false;
            r.isWord=r.isWord-1;
            return true;
    }
    public Node getNode(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char f=word.charAt(i);
            if(curr.child[f-'a']==null) return null;
            curr=curr.child[f-'a'];
        }
        return curr;
    }
    class Node{
        int isWord;
        Node child[]=new Node[26];
        Node(){
            isWord=0;
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */