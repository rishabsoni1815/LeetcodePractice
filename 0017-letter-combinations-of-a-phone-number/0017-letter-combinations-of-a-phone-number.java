class Solution {
    public List<String> letterCombinations(String s) {
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n=s.length();
        List<String>ans=new ArrayList<>();
        if(n==0) return ans;
        help(s,ans,"",0,n,map);
        return ans;
    }
    void help(String s,List<String>ans,String cur,int i,int n,String[] map){
        if(i>=n){
            ans.add(cur);
            return;
        }
        String cString=map[s.charAt(i)-'0'];
        for(int j=0;j<cString.length();j++){
            help(s,ans,cur+cString.charAt(j),i+1,n,map);
        }
    }
}