class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        help(n,n,ans,"");
        return ans;
    }
    void help(int l,int r,List<String>ans,String s){
        if(l>r || l<0 || r<0) return;
        if(l==0&&r==0) {
            ans.add(s);
            return;
        }
        help(l-1,r,ans,s+"(");
        help(l,r-1,ans,s+")");
    }
}