class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0, i = startPos[0], j = startPos[1], x = homePos[0], y = homePos[1];
        while (i != x) {
            if(x-i >0) i++;
            if(x-i <0) i--;
            res += rowCosts[i];
        }
        while (j != y) {
            if(y-j >0) j++;
            if(y-j <0) j--;
            res += colCosts[j];
        }
        return res;
    }
}