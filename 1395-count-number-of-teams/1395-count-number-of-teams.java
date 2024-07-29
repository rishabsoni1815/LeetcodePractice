class Solution {
    public int numTeams(int[] a) {
        int n=a.length,ans=0;
        for(int i=0;i<n;i++){
            int ls=0,lb=0;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]) ls++;
                if(a[j]>a[i]) lb++;
            }
            int rs=0,rb=0;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[i]) rs++;
                if(a[j]>a[i]) rb++;
            }
            ans+=(ls*rb);
            ans+=(lb*rs);
        }
        return ans;
    }
}