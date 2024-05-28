class Solution {
    public int longestNiceSubarray(int[] a) {
        int h[]=new int[33];//subarray all pairs and means not place should be having more than 1 bit set (in 32 bits array / representation)
        int n=a.length,i=0,j=0,ans=0;
        boolean take=true;
        while(j<n){
            add(a[j],h);
            take=check(h);
            while(i<=j && take==false){
                remove(a[i],h);
                i++;
                take=check(h);
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
    
    boolean check(int h[]){
        for(int i=0;i<33;i++){
            if(h[i]>1) return false;
        }
        return true;
    }
    
    void add(int x,int h[]){
        boolean res=true;
        for(int i=0;i<33;i++){
            if(((1<<i) & x) > 0){
                h[i]++;
            }
        }
    }
    
    void remove(int x,int h[]){
        boolean res=true;
        for(int i=0;i<33;i++){
            if(((1<<i) & x) > 0){
                h[i]--;
            }
        }
    }
}