class Solution {
    public int subarraysWithKDistinct(int[] a, int k) {
        //guessing ==k is difficult so use <=k as window from j to i has total k distinct but any subarray of this window can ahave <=k not >k so use this 
        return atMost(a,k)-atMost(a,k-1);
    }
    int atMost(int a[],int k){
        int n=a.length,i=0,j=0,ans=0;
        HashMap<Integer,Integer>h=new HashMap<>();
        while(j<n){
            h.put(a[j],h.getOrDefault(a[j],0)+1);
            while(i<=j && h.size()>k){// <=j for k=1 in start i==j==0 so <= not <
                h.put(a[i],h.get(a[i])-1);
                if(h.get(a[i])==0) h.remove(a[i]);
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
}
