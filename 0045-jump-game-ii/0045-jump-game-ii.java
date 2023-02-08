class Solution {
    public int jump(int[] a) {
        //like Jump game I only there we do -> greedy is whereever max we can go there let's say first index say we can go till 5th then when going through 1 to 5 if we get a better right going pos. (a[i]+i > cur_reach) then update cur_reqach and let's go there here diff. is --> we will go there and update cur_reach but we will first find cur_reach of all max b/w 1 to 5 and then in 1 step go to there we will not go until we have max. we can reach using all from 1 to 5 
        int n=a.length;
        if(n==1) return 0;
        int ans=1;
        int cmax=a[0];
        int cur_reach=a[0];
       // https://www.youtube.com/watch?v=A-Mc_0WsoaM
        int i=0;
        while(cur_reach<n-1){
            if(i+a[i]>cmax){
                cmax=i+a[i];
            }
            if(i==cur_reach){
                cur_reach=cmax;
                ans++;
            }
            i++;
        }
        return ans;
    }
}