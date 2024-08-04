class Solution {
     public int lengthOfLIS(int[] a) {
    //o(nlogn) binary search -> by taking the smallest elements always in the list from index 0 and replace with the ele >= x not just > as we want lis (>) not (>=)  we can only get length of lis can't print it fo
          int n=a.length;
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(a[0]);
        for(int i=1;i<n;i++){
            if(ans.get(ans.size()-1)<a[i]){//not <= as lis-> a[i-1]<a[i] not a[i-1]<=a[i]
                ans.add(a[i]);
            }else{
                int u=lb(ans,a[i]);
                if(u!=-1)  ans.set(u,a[i]);
            }
        }
        return ans.size(); 
    }
    int lb(ArrayList<Integer>a,int t){
        int i=0;
        int j=a.size()-1;
        int ans=-1;
        while(i<=j){
            int m=(i+j)/2;
            if(a.get(m)>=t){//if we dont include t i.e. only do a.gwt(m)>t then there will be duplicates in arraylist as if eg -> [4,10,4,5] array list is 4,5 on index 2 and we replace 10 with 4 so this becomes 4,4 which is wrong so our should return 4,10 so check for ele >=t not just >t
                j=m-1;
                ans=m;
            }else{
                i=m+1;
            }
        }
        return ans;
    }
    
    
    // public int lengthOfLIS(int[] a) {
    //     //o(n^2) tabulation
    //     int n=a.length;
    //     int max=1;//as n>=1
    //     int dp[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         dp[i]=1;
    //         for(int j=0;j<i;j++){
    //             if(a[j]<a[i]) {
    //                 dp[i]=Math.max(dp[i],1+dp[j]);
    //             }
    //         }
    //         max=Math.max(max,dp[i]);
    //     }
    //printing lis---> traverse back with length and dec by 1 everytime we find len-1 
    // int cnt=max+1;
    //     int ans[]=new int[max];int k=max-1;
    //     for(int i=n-1;i>=0;i--){
    //         if(dp[i]==cnt-1){
    //             cnt--;
    //             ans[k]=a[i];
    //             k--;
    //         }
    //     }
    //     for(int i=0;i<max;i++) System.out.print(ans[i]+" ");
    //     return max;
    // }
}


//memoisation o(n^2)
// class Solution {
//     int ans=0;
//     public int lengthOfLIS(int[] a) {
//         ans=1;
//         int n=a.length;
//         Integer dp[]=new Integer[n];
//         help(n-1,a,dp);
//         return ans;
//     }
//     int help(int i,int a[],Integer dp[]){
//         if(i==0) return 1;
//         int max=1;
//         if(dp[i]!=null) return dp[i];
//         for(int j=0;j<i;j++){
//             int res=help(j,a,dp);//note have to call for all as we want to check all lis ending at all indces and get max of them
//             if(a[j]<a[i]){
//                 max=Math.max(max,1+res);
//             }
//         }
//         ans=Math.max(ans,max);
//         return dp[i]=max;
//     }
// }