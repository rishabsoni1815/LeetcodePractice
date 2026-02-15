class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int r = 0;
        while (i >= 0 || j >= 0 || r > 0) {
            if (i >= 0) {
                if (a.charAt(i) == '1')
                    r++;
                i--;
            }
            if (j >= 0) {
                if (b.charAt(j) == '1')
                    r++;
                j--;
            }
            if (r > 1) {
                if (r == 2)
                    ans.append('0');
                else
                    ans.append('1');
                r = 1;
            } else {
                if (r == 1)
                    ans.append('1');
                else
                    ans.append('0');
                r = 0;
            }
        }
        return ans.reverse().toString();
    }
}