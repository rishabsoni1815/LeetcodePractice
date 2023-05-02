class Solution {
    public int arraySign(int[] a) {
        int x=0;
        for(int i:a){
            if(i<0) x++;
            if(i==0) return 0;
        }
        if(x%2==0) return 1;
        return -1;
    }
}