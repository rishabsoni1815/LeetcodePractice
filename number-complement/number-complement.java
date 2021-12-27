class Solution {
    // public int findComplement(int n) {
    //   int x=1;
    //     for(int i=0;i<=(int)(Math.log(n)/Math.log(2));i++){
    //         n^=x;
    //         x=x<<1;
    //     }
    //     return n;
    // }
    
    // or by using fact that
    // 100110, its complement is 011001, the sum is 111111. So we only need get the min number large or equal to num, then do substraction
    
    public int findComplement(int num) 
    {
        int i = 0;
        int j = 0;
        
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        
        return i - num;
    }
}