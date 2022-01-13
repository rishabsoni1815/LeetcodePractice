class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points,(x,y)->(x[1]!=y[1])?(Integer.compare(x[1], y[1])):(Integer.compare(x[0], y[0])));
        // as for [[-2147483646,-2147483645],[2147483646,2147483647]] the x[0]-y[0] overflows so 
        // always write Integer.compare(x[0], y[0])
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}