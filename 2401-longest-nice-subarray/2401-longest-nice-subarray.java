class Solution {
    
    //can optimise this using facr that or can be used for add operation xor can be used for remove operation and if we check & of used bits and current element if it is !=0 this means my bits collided with curr and if it is equal to 0 after & this means bits didnt colided(pos of set bits is diff in used bits and cur element) as if they collided some 1|0 would have returned 1 (i.e. result wikl be !=0)
    
    public int longestNiceSubarray(int[] a) {
        int n=a.length,i=0,j=0,ans=0;
        int used=0;
        while(j<n){
            while(i<=j && ((used & a[j]) != 0)){//checking if including a[j] makes our overall condition satisfied or not
                used^=a[i];//xor makes 1->0 and 0->0 for used
                i++;
            }
            used|=a[j];
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
    
    
    
    // public int longestNiceSubarray(int[] a) {
    //     int h[]=new int[33];//subarray all pairs and means not place should be having more than 1 bit set (in 32 bits array / representation)
    //     int n=a.length,i=0,j=0,ans=0;
    //     boolean take=true;
    //     while(j<n){
    //         add(a[j],h);
    //         take=check(h);
    //         while(i<=j && take==false){
    //             remove(a[i],h);
    //             i++;
    //             take=check(h);
    //         }
    //         ans=Math.max(ans,j-i+1);
    //         j++;
    //     }
    //     return ans;
    // }
    
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