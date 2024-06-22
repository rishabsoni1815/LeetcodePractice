class Solution {
    
        public int numberOfSubarrays(int[] a, int k) {
            int n=a.length,l=0,r=0,ans=0,gap=0,osize=0;
            while(r<n){
                if(a[r]%2!=0) osize++;
                if(osize==k){
                    gap=0;
                    while(osize==k){
                        gap++;
                        if(a[l]%2!=0) osize--;
                        l++;
                    }
                }
                ans+=gap;
                r++;
            }
            return ans;
        }
    
    
/*
// still uses o(n) spac so optimise 
// what we can do is when my window has k odd elemenrs we will dec l till ocount==k let this be gap (these will be all evens btw 2 odds (prev in our approach) ) and now while r++ everytime add gap in ans this will be doing work of prev*next -> prev+prev+prev...+prev (next) times
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
    */
    
}