class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int min=Integer.MAX_VALUE;
        for(int y:right) min=Math.min(min,y);
        
        int max=Integer.MIN_VALUE;
        for(int y:left) max=Math.max(max,y);
        
        if(left.length==0 && right.length==0) return 0;
        if(left.length==0) return n-min;
        if(right.length==0) return max;
        
        return Math.max(n-min,max);
    }
}