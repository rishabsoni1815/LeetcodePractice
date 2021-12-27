class Solution {
    public int findComplement(int n) {
      int x=1;
        for(int i=0;i<=(int)(Math.log(n)/Math.log(2));i++){
            // System.out.println(x+" "+n+" "+(int)(Math.log(n)/Math.log(2)));
            n^=x;
            x=x<<1;
        }
        return n;
    }
}