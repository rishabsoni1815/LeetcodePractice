class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 1, hi = A.length - 2;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] > A[mi + 1] && A[mi] > A[mi - 1] ) return mi;
            if (A[mi] < A[mi + 1] && A[mi] > A[mi - 1] )
                lo = mi + 1;
            else
                hi = mi- 1;
        }
        return lo;
    }
}