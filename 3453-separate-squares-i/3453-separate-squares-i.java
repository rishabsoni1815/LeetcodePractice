class Solution {
    public double separateSquares(int[][] a) {
        int n = a.length;
        double total = 0;
        for (int c[] : a) {
            total +=  ((double)c[2] * c[2]);
        }
        double l = 0.0, r = (double) (1e9), ans = r;
        while (!equal(l, r)) {
            double mid = (r + l) / 2.0;
            double area = check(mid, a, n, total);
            double half = total / 2.0;
            if (lessEqual(area, half)) {
                ans=mid;
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    boolean equal(double a, double b) {
        double diff = (double) (Math.abs(a - b));
        return diff <= (0.000001);
    }

    boolean lessEqual(double a, double b) {
        double diff = (double) (b - a);
        return diff >= 0.00001;
    }

    boolean greaterEqual(double a, double b) {
        double diff = (double) (a - b);
        return diff >= 0.00001;
    }

    boolean greater(double a, double b) {
        double diff = (double) (a - b);
        return diff > (0.00001);
    }

    boolean less(double a, double b) {
        double diff = (double) (b - a);
        return diff > (0.00001);
    }

    double check(double mid, int a[][], int n, double total) {
        double cur = 0.0;
        for (int i = 0; i < n; i++) {
            if (less(mid,a[i][1]))
                continue;
            else if (lessEqual(a[i][1], mid) && greaterEqual(a[i][1]+a[i][2], mid)) {
                double side = mid-(double)a[i][1];
                cur += (side * (double)a[i][2]);
            } else {
                cur += ((double)a[i][2] * a[i][2]);
            }
        }
        return cur;
    }
}