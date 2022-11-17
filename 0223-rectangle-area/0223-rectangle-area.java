class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area=(bx2-bx1)*(by2-by1)+(ax2-ax1)*(ay2-ay1);
        int overlap=0;
        int l=Math.max(bx1,ax1);
        int r=Math.min(bx2,ax2);
        int t=Math.min(ay2,by2);
        int d=Math.max(by1,ay1);
        if(r>l && t>d){
            overlap=(r-l)*(t-d);
        }
        return area-overlap;
    }
}