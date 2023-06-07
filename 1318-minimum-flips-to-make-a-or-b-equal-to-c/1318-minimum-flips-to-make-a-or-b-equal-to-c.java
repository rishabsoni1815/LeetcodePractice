class Solution {
    public int minFlips(int a, int b, int c) {
        // 0,0,0 = 0
        // 0,1,0 = 1
        // 1,0,0 = 1
        // 1,1,0 = 2 
        // 0,0,1 = 1
        // 0,1,1 = 0
        // 1,0,1 = 0
        // 1,1,1 = 0
        int ans=0;
        while(a!=0 || b!=0 || c!=0){
            boolean t1=false,t2=false,t3=false;//true means bit is set (i.e. 1)
            if(a%2!=0) t1=true;
            if(b%2!=0) t2=true;
            if(c%2!=0) t3=true;
            if(t1){
                if(t2){
                    if(t3==false) ans+=2;
                }else{
                    if(t3==false) ans++;
                }
            }else{
                if(t2){
                    if(t3==false) ans++;
                }else{
                    if(t3==true) ans++;
                }
            }
            if(a>0) a=a>>1;
            if(b>0) b=b>>1;
            if(c>0) c=c>>1;
        }
        return ans;
    }
}
/*

// method 2 ->
// Step 1: a | b is what we have while c is what we want. An XOR operation finds all different bits, i.e. (a | b) ^ c sets the bits where flip(s) is needed. Then we count the set bits.
// Step 2: There is only one case when two flips are needed: a bit is 0 in c but is 1 in both a and b. An AND operation finds all common 1 bits, i.e. a & b & ((a | b) ^ c) sets the common 1 bits in a, b and the must-flip bits found in Step 1.

// TC -> O(1) as In Java, Integer.bitCount() also uses a precomputed table of bit counts for every possible 16-bit integer value  
    public int minFlips(int a, int b, int c) {
         return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));   
    }

*/