class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        var q = new LinkedList<Integer>();
        for (var student : students) q.offerLast(student);
        int cur = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                var student = q.pollFirst();
                if (student == sandwiches[cur]) {
                    cur++;
                } else q.offerLast(student);
            }
            if (q.size() == size) break;
        }
        return q.size();
    }
}