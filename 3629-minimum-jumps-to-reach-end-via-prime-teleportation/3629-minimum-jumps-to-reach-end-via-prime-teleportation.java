class Solution {
    public int minJumps(int[] a) {
        HashMap<Integer, List<Integer>> h = new HashMap<>();
        int n = a.length, max = 0;
        for (int i = 0; i < a.length; i++) {
            if (!h.containsKey(a[i])) {
                h.put(a[i], new ArrayList<>());
            }
            h.get(a[i]).add(i);
            max = Math.max(max, a[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> v = new HashSet<>();
        HashSet<Integer> usedPrime = new HashSet<>();
        v.add(0);
        q.add(0);
        int ans = 0;
        while (q.size() > 0) {
            int s = q.size();
            while (s-- > 0) {
                int c = q.poll();
                // System.out.println(c+" "+ans+" "+isPrime(a[c]));
                if (c == n - 1)
                    return ans;
                if (c - 1 >= 0 && !v.contains(c - 1)) {
                    v.add(c - 1);
                    q.add(c - 1);
                }
                if (c + 1 < n && !v.contains(c + 1)) {
                    q.add(c + 1);
                    v.add(c + 1);
                }
                if (isPrimeAndNotUsed(a[c], usedPrime)) {
                    for (int y = 1; y <= max; y++) {
                        if (h.containsKey(a[c] * y)) {
                            List<Integer> idx = h.get(a[c] * y);
                            for (int cidx : idx) {
                                if (!v.contains(cidx)) {
                                    q.add(cidx);
                                    v.add(cidx);
                                }
                            }
                        }
                        if (y * a[c] > max)
                            break;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    boolean isPrimeAndNotUsed(int a, HashSet<Integer> usedPrime) {
        if (a < 2)
            return false;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0)
                return false;
        }
        if (!usedPrime.contains(a)) {//to avoid checking all prime multiples since array has duplicates
            usedPrime.add(a);
        } else
            return false;

        return true;
    }
}