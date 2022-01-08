class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        help(n,n,ans,"");
        return ans;
    }
   void help(int o,int c,List<String>ans,String s){
        if(c<o){
            return;
        }
       if(c==o&&c==0){
           ans.add(s);
       }
       if(o>0)help(o-1,c,ans,s+"(");
       if(c>0)help(o,c-1,ans,s+")");
    }
}