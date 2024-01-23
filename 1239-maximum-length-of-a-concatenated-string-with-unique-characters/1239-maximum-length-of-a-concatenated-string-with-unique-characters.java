class Solution {
    public int maxLength(List<String> a) {
        //learn dp and dp with bitmask
        int n=a.size();
        int h=1<<26;
        return dfs(0,n,a,h);
    }
    int dfs(int i,int n,List<String>a,int h){
        if(i==n) return 0;
        int ch=h;
        String s=a.get(i);
        boolean flag=false;
        for(int j=0;j<s.length();j++){
            int x=s.charAt(j)-'a';
            int y=((1<<x)&ch);//checking if xth bit is set in ch
            if(y>0){
                flag=true;
                break;
            }
            ch=((1<<x)|ch);//setting xth bit of ch to 1
        }
        int res=0;
        if(flag==false) res= s.length()+dfs(i+1,n,a,ch);
        res=Math.max(res,dfs(i+1,n,a,h));
        return res;
    }
}