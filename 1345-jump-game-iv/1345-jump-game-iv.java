class Solution {
    public int minJumps(int[] a) {
        int n = a.length;
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!h.containsKey(a[i])) {
                h.put(a[i], new ArrayList<>());
            }
            h.get(a[i]).add(i);
        }
        boolean v[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        v[0] = true;
        int ans = 0;
        while (q.size() > 0) {
            int s = q.size();
            while (s-- > 0) {
                int i = q.poll();
                if (i == a.length - 1)
                    return ans;
                if (i - 1 >= 0 && v[i - 1] == false) {
                    v[i - 1] = true;
                    q.add(i - 1);
                }
                if (i + 1 < a.length && v[i + 1] == false) {
                    v[i + 1] = true;
                    q.add(i + 1);
                }
                if (h.containsKey(a[i])) {
                    for (int idx : h.get(a[i])) {
                        if (idx != i && v[idx] == false) {
                            v[idx] = true;
                            q.add(idx);
                        }
                    }
                    h.remove(a[i]);//as even if this is visited we will still iterate over h.get(a[i] so remove a[i] from map )
                }
            }
            ans++;
        }
        return ans;
    }
}