class Solution {
    public double maxAverageRatio(int[][] a, int e) {
        PriorityQueue<Fraction> q = new PriorityQueue<>(
            (x, y) -> Double.compare(y.gain(), x.gain())  // max heap by gain
        );

        for (int[] cls : a) {
            q.add(new Fraction(cls[0], cls[1]));
        }

        while (e-- > 0) {
            Fraction f = q.poll();
            f.a++;
            f.b++;
            q.add(f); // push back with updated gain
        }

        double ans = 0;
        while (!q.isEmpty()) {
            Fraction f = q.poll();
            ans += (f.a * 1.0) / f.b;
        }
        return ans / a.length;
    }
}

class Fraction {
    int a, b;

    Fraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    double gain() {
        return ((a + 1) * 1.0 / (b + 1)) - (a * 1.0 / b);
    }
}
