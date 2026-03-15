/*

The challenge arises when we append a new value. This new value hasn't been affected by the previous multipliers and increments. To fix this, we store a "normalized" version of the value such that when the current global transformation is applied later, it yields the original value.

Approach
The Transformation Formula
At any point, the value at idx is calculated as:
Value=(stored_val[idx]⋅mul+sum)(mod10 
9
 +7)
The "Reverse" Append
When we append(val), we need to find a base such that:
val≡(base⋅mul+sum)(modM)
Rearranging for base:
base≡(val−sum)⋅mul 
−1
 (modM)
Here, mul 
−1
  is the Modular Multiplicative Inverse, calculated using Fermat's Little Theorem since 10 
9
 +7 is prime.
Modular Inverse
Since we are working under modulo M, division is replaced by multiplying by the modular inverse.
Using Fermat's Little Theorem:
a 
M−2
 ≡a 
−1
 (modM)

*/

class Fancy {
    private static final int MOD = 1000000007;
    private ArrayList<Long> val;
    private long a, b;

    public Fancy() {
        val = new ArrayList<>();
        a = 1;
        b = 0;
    }

    private long modPow(long x, long y, long mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % mod;
            }
            y = y / 2;
            x = (x * x) % mod;
        }
        return res;
    }

    public void append(int val) {
        long x = (val - b + MOD) % MOD;
        this.val.add((x * modPow(a, MOD - 2, MOD)) % MOD);
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }

    public void multAll(int m) {
        a = (a * m) % MOD;
        b = (b * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= val.size())
            return -1;
        return (int) ((a * val.get(idx) + b) % MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */