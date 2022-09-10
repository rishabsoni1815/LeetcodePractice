class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        int n=s.length();
        // 3-4*5
        // 3-20 -> -17
        // -1*5 -> -5
       return help(0,n-1,s);
    }
    List<Integer> help(int i,int j,String s){
        List<Integer>ans=new ArrayList<>();
        boolean flag=false;
        for(int k=i;k<=j;k++){
            if(s.charAt(k)=='+'||s.charAt(k)=='-'||s.charAt(k)=='*'){
                flag=true;
                List<Integer>l=help(i,k-1,s);
                List<Integer>r=help(k+1,j,s);
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
        return ans;
    }
}