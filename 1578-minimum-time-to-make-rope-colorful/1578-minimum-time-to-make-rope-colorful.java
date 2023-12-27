class Solution {
    public int minCost(String s, int[] a) {
        int ans=0,n=s.length();
        for(int i=1;i<n;){
            if(s.charAt(i)==s.charAt(i-1)){
                if(a[i-1]<a[i]){
                    ans+=a[i-1];
                    i++;
                }else{
                    ans+=a[i];
                    a[i]=a[i-1];//as a[i] is removed and for a[i+1] now a[i-1] will be a[i-2] not a[i-1] as for a[i+1] a[i-1] which is a[i] is removed so a[i]=a[i-1] so that a[i-1] for a[i+1] is now a[i-2] 
                    i++;
                }
            }else i++;
        }
        return ans;
    }
}