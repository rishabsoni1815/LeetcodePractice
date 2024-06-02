class Solution {
    public int minimumDifference(int[] a, int k) {
        //idea is to have sliding window and keep inc size of it till and is >k when ever and goes <k as now the AND will keep desc (property of and it gives >= values) so we stop window and dec size until and >k 
        //now we cant decrease size of window like -a[i] as we do in sliding window neither |a[l] works here so we have to maintain bit count and count and from that and decrese window by iupdating count there
        //as for all elemetns and to be 1 at kth bit then we should not have any 0 on this kth pos so we will maintain set bit count
        
        int n=a.length;
        int i=0,j=0,ans=Integer.MAX_VALUE;
        int h[]=new int[32];
        while(j<n){
            //add jth element
            addEle(a[j],h);
            ans=Math.min(ans,Math.abs(k-getAnd(h,j-i+1)));
            
            while(i<=j && getAnd(h,j-i+1)<=k){//get and from h
                ans=Math.min(ans,Math.abs(k-getAnd(h,j-i+1)));
                //remove ith element
                remove(a[i],h);
                i++;
            }
            
            ans=Math.min(ans,Math.abs(k-getAnd(h,j-i+1)));
            // System.out.println(getAnd(h,j-i+1)+" "+i+" "+j);
            j++;
        }
        return ans;
        
    }
    
    void remove(int x,int h[]){
         for(int i=0;i<32;i++){
            if((x & (1<<i)) > 0) {
                h[i]--;//decrease unset count
            }
        } 
    }
    
    void addEle(int x,int h[]){
        for(int i=0;i<32;i++){
            if((x & (1<<i)) > 0) {
                // System.out.println(i+" isset "+x);
                h[i]++;//increase unset count
            }
        }
    }
    
    int getAnd(int h[],int n){
        int ans=0;
        for(int i=0;i<32;i++){
            // System.out.print(h[i]+" ");
            if((n-h[i]) == 0){//means has all set bits
                ans|=(1<<i);
            }
        }
        // System.out.println();
        return ans;
    }
}