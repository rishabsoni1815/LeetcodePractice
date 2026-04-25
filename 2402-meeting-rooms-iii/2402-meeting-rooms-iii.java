
class Solution {

    public int mostBooked(int n, int[][] a) {

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        // Free rooms
        PriorityQueue<Integer> free =
                new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            free.add(i);

        // Busy rooms
        PriorityQueue<long[]> busy =
                new PriorityQueue<>(
                        (x, y) -> {
                            if (x[0] == y[0])
                                return Long.compare(x[1], y[1]);
                            return Long.compare(x[0], y[0]);
                        });

        int[] freq = new int[n];

        for (int[] meeting : a) {

            int start = meeting[0];
            int end = meeting[1];

            long duration = end - start;

            // Free finished rooms
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= start) {

                free.add((int) busy.poll()[1]);
            }

            if (!free.isEmpty()) {

                int room = free.poll();

                busy.add(new long[]{end, room});

                freq[room]++;

            } else {

                long[] earliest = busy.poll();

                long newEnd =
                        earliest[0] + duration;

                int room =
                        (int) earliest[1];

                busy.add(new long[]{newEnd, room});

                freq[room]++;
            }
        }

        int ans = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {

            if (freq[i] > max) {

                max = freq[i];
                ans = i;
            }
        }

        return ans;
    }
}