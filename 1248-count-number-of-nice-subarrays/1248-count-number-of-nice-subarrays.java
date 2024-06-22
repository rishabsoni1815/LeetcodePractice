class Solution {
    public int numberOfSubarrays(int[] a, int k) {
        int n=a.length;
        ArrayList<Integer>o=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(a[i]%2!=0) o.add(i);//index of odd elements
        }
        int ans=0,l=0,r=l+k-1;
        while(r<o.size()){//multiply dis btw l-1 th to l and dis btw r+1 to r 
            int prev=o.get(l)+1;
            if(l-1>=0) prev=(o.get(l)-o.get(l-1));
            int next=n-o.get(r);
            if(r+1<o.size()) next=(o.get(r+1)-o.get(r));
            ans+=(prev*next);
            l++;
            r++;
        }
        return ans;
    }
}