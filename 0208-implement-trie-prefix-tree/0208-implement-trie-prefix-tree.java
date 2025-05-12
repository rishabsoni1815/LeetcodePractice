class Trie {
    TrieNode tree;
    public Trie() {
        tree=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp=tree;
        for(int i=0;i<word.length();i++){
            if(temp.node[word.charAt(i)-'a']==null){
                temp.node[word.charAt(i)-'a']=new TrieNode();
                temp=temp.node[word.charAt(i)-'a'];
            }else temp=temp.node[word.charAt(i)-'a'];
        }
        temp.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode temp=tree;
        for(int i=0;i<word.length();i++){
            if(temp.node[word.charAt(i)-'a']!=null){
                temp=temp.node[word.charAt(i)-'a'];
            }else return false;
        }
        return temp.isWord==true;
    }
    
    public boolean startsWith(String word) {
        TrieNode temp=tree;
        for(int i=0;i<word.length();i++){
            if(temp.node[word.charAt(i)-'a']!=null){
                temp=temp.node[word.charAt(i)-'a'];
            }else return false;
        }
        return true;
    }
}

class TrieNode{
    TrieNode node[]=new TrieNode[26];
    boolean isWord;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */