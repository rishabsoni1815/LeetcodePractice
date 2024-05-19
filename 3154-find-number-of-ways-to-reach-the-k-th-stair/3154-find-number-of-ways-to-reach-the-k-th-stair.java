class Solution {
    //as k can be 10^9 so using map instead of array having [k]
    
    public int waysToReachStair(int k) {
        HashMap<String,Integer>dp=new HashMap<>();
        return help(1,0,k,0,dp);
    }
    int help(int s,int j,int k,int flag,HashMap<String,Integer>dp){//s->Strain,j->jump,flag-> can we use step 1 or not(cant use consicutvely or on starin 0) 0->yes
        if(s>k+1) return 0;//up we can go s+1<<j but down only -1 so if > k+1 can never come back
        String cur=s+"&"+j+"&"+flag;
        if(dp.containsKey(cur)) return dp.get(cur);
        // if(s==k) return 1;//wrong as still we can go back and return (note in question) so just make ans acc to this
       
        int ans=(s==k ? 1:0 );
        if(flag==0 && s>0) ans=ans+help(s-1,j,k,1,dp);//can t use consicutively so false
        ans=ans+help(s+(1<<j),j+1,k,0,dp);
        dp.put(cur,ans);
        return ans;
    }
}