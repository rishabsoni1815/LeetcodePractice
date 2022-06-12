class Solution {
    public int maximumUniqueSubarray(int[] a) {
        int n=a.length;
        int sum=0,ans=0;
        int i=0,j=0;
        HashMap<Integer,Integer>h=new HashMap<>();
        while(i<n && j<n){
            while(j<n && h.containsKey(a[j])==false){
                h.put(a[j],1);
                sum+=a[j];
                ans=Math.max(ans,sum);
                j++;
            }
            sum-=a[i];
            h.put(a[i],h.get(a[i])-1);
            if(h.get(a[i])==0) h.remove(a[i]);
            i++;
        }
        return ans;
    }
}