class Solution {
    //one other approach in submission as thisis memorty exceede so try map
    public double soupServings(int n) {
        if(n>5000) return 1.0; //proof -> https://www.youtube.com/watch?v=XNLJS-uDIqU
        Map<Integer,Map<Integer,Double>> dp=new HashMap<>();
        double ans=help(n,0,0,dp);
        return ans;//direct do not array sum total only as 0.5 in base condition only 
    }
    double help(int n,int a,int b,Map<Integer,Map<Integer,Double>> dp){
        if(a>=n || b>=n){
            if(a>=n && b>=n){
                return 0.5;
            }
            if(a>=n && b<n){
                return 1.0;
            }
            return 0.0;
        }
        if (dp.containsKey(a) && dp.get(a).containsKey(b)) {
            return dp.get(a).get(b);
        }
        double ans=0.0;
        double x1=help(n,a+100,b,dp);
        double x2=help(n,a+75,b+25,dp);
        double x3=help(n,a+50,b+50,dp);
        double x4=help(n,a+25,b+75,dp);
        ans+=x1;ans+=x2;ans+=x3;ans+=x4;
        ans*=0.25;
        if(!dp.containsKey(a)){
            dp.put(a,new HashMap<Integer,Double>());
            dp.get(a).put(b,ans);
        }else{
            dp.get(a).put(b,ans);
        }
        return ans;
    }
}