class Solution {
    public List<Integer> findWordsContaining(String[] s, char x) {
        List<Integer>ans=new ArrayList<>();
        int i=0;
        for(String c:s){
            if(has(c,x)){
                ans.add(i);
            }
            i++;
        }
        return ans;
    }
    boolean has(String s,char c){
        for(int i=0;i<s.length();i++){
            if(c==s.charAt(i)) return true;
        }
        return false;
    }
}