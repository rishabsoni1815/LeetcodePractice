class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int minDeletions = 0;
        int bCount = 0;

        // minDeletions variable represents the deletions needed yet to make this string valid in past
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {//if comes bs then deletions are same as no need to delete b if any A does not come after this 
                bCount++;
            } else {
                // Two cases: remove 'a' or keep 'a', delete a-> min+1 is our new min and if keep a then means delete all the b ocdured so far 
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }

        return minDeletions;
    }
}