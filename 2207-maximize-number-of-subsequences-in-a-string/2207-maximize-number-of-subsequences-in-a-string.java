class Solution {
    public long maximumSubsequenceCount(String a, String b) {
        int n=a.length();
        //2 cases-> at b.charAt(0) in first or b.charAt(1) to last
        
        long cnt1=1;//b.charAt(0) in first
        long ans1=0;
        for(int i=0;i<n;i++){
            if(a.charAt(i)==b.charAt(1)){
                ans1+=cnt1;
            }//first increase as we want to add the no. of b.charAt(0)'s that occur before i (i.e from 0 to i-1 or [0,i) or [0,i-1] )'
            if(a.charAt(i)==b.charAt(0)){
                cnt1++;
            }
        }
        
        long cnt2=1;//b.charAt(1) in last
        long ans2=0;
        for(int i=n-1;i>=0;i--){
            if(a.charAt(i)==b.charAt(0)){
                ans2+=cnt2;
            }
            if(a.charAt(i)==b.charAt(1)){
                cnt2++;
            }
        }
        return (long)Math.max(ans1,ans2);
    }
}