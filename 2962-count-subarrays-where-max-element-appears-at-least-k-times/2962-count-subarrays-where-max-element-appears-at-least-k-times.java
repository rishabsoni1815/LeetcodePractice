class Solution {
    public long countSubarrays(int[] a, int k) {
        int n=a.length;
        long ans=0,max=-1;
        for(int i=0;i<n;i++){
            max=Math.max(max,a[i]);
        }
        int i=0,j=0,c=0;
        while(i<n||c>=k){
            if(i<n && a[i]==max){
                c++;
            }
            if(c>=k){
                ans+=(long)(n-i);
            }
            // System.out.println(i+" "+j+" "+c+" f "+ans);
            while(j<=i && c>=k){
                // System.out.println(j+" s");
                if(a[j]==max){
                    c--;
                }
                j++;
                if(c<k) break;
                ans+=(long)(n-i);
            }
            // System.out.println(i+" "+j+" "+c+" "+ans);
            i++;
        }
        return ans;
    }
}