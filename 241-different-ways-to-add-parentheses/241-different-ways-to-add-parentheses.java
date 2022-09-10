class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        int n=s.length();
        HashMap<String,List<Integer>>dp=new HashMap<>();//memoise strings
       return help(0,n-1,s,dp);
    }
    List<Integer> help(int i,int j,String s,HashMap<String,List<Integer>>dp){
        List<Integer>ans=new ArrayList<>();
        boolean flag=false;
        String cdp=i+"#"+j;
        if(dp.containsKey(cdp)) return dp.get(cdp);
        for(int k=i;k<=j;k++){
            if(s.charAt(k)=='+'||s.charAt(k)=='-'||s.charAt(k)=='*'){
                flag=true;
                List<Integer>l=help(i,k-1,s,dp);
                List<Integer>r=help(k+1,j,s,dp);
                for(int ll:l){
                    for(int rr:r){
                        if(s.charAt(k)=='*') ans.add(ll*rr);
                        if(s.charAt(k)=='-') ans.add(ll-rr);
                        if(s.charAt(k)=='+') ans.add(ll+rr);
                    }
                }
            }
        }
        if(flag==false){
            int cur=Integer.valueOf(s.substring(i,j+1));
            ans.add(cur);
        }
        dp.put(cdp,ans);
        return ans;
    }
}