class Solution {
    public int findRotateSteps(String s, String k) {
        int n=s.length();
        HashMap<Character,ArrayList<Integer>>m=new HashMap<>();
        for(int i=0;i<n;i++){
            if(m.containsKey(s.charAt(i))){
                m.get(s.charAt(i)).add(i);
            }else{
                ArrayList<Integer>c=new ArrayList<>();
                c.add(i);
                m.put(s.charAt(i),c);
            }
        }
        Integer dp[][]=new Integer[k.length()][n];
        return help(0,0,m,s,k,dp);
    }
    int help(int i,int p,HashMap<Character,ArrayList<Integer>>m,String s,String k,Integer dp[][]){
        if(i==k.length()) return 0;
        if(dp[i][p]!=null) return dp[i][p];
        int min=Integer.MAX_VALUE;
        for(int nei:m.get(k.charAt(i))){
            int x=Math.min(Math.abs(nei-p),s.length()-Math.abs(nei-p));
            min=Math.min(min,x+help(i+1,nei,m,s,k,dp)+1);
        }
        return dp[i][p]=min;
    }
}