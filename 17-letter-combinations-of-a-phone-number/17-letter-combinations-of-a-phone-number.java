class Solution {
    List<String>ans=new ArrayList<>();
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        h("",digits,0,digits.length());
        return ans;
    }
      void h(String c,String s,int i,int n){
           if(i>=n){
               ans.add(c);
               return;
           }
           int index=s.charAt(i)-'0';
           for(int j=0;j<map[index].length();j++){
               h(c+map[index].charAt(j),s,i+1,n);
           }
       }
}