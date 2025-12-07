class Solution {
    public int countOdds(int l, int h) {
        int diff=h-l+1;
        if(diff%2==0) return diff/2;
        else{
            if(l%2==0){
                return diff/2;
            }else{
                return diff/2+1;
            }
        }
    }
}