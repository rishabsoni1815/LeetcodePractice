class Solution {
    /*
    
    Assume sum is the sum of nums[] find a subset of nums[] which sum equals to sum/k. We use an array visited[] to record which element in nums[] is used. Each time when we get a cur_sum = sum/k, we will start from position 0 in nums[] to look up the elements that are not used yet and find another cur_sum = sum/k.
    
    */
    public boolean canPartitionKSubsets(int[] a, int k) {
        int n=a.length;
        int sum = Arrays.stream(a).sum();//to remove tle finding sum of array
        if(sum%k!=0) return false;
        boolean v[]=new boolean[n];
        return help(0,a[0],a,k,v,sum/k);
    }
    boolean help(int i,int sum,int a[],int k,boolean v[],int t){
        if(k==0 && sum==0) return true;
        if(sum>t) return false;
        if(sum==t) return help(0,0,a,k-1,v,t);
        for(int j=i+1;j<a.length;j++){
            if(v[j]==false){
                v[j]=true;
                if(help(j,sum+a[j],a,k,v,t)) return true;
                v[j]=false;
            }
        }
        return false;
    }
}