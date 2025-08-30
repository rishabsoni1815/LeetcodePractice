class Solution {
    public boolean isValidSudoku(char[][] a) {
        int n = a.length, m = a[0].length;
        for (int i = 0; i < n; i++) {
            if (!checkCol(a[i]))
                return false;
        }
        for (int i = 0; i < m; i++) {
            if (!checkRow(a, i))
                return false;
        }
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < m; j += 3) {
                if (!checkCube(a, i, j))
                    return false;
            }
        }
        return true;
    }

    boolean checkCol(char a[]) {
        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '.')
                continue;
            if (a[i] > '0' && a[i] <= '9' && !h.contains(a[i]))
                h.add(a[i]);
            else
                return false;
        }
        return true;
    }

    boolean checkRow(char a[][], int j) {
        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i][j] == '.')
                continue;
            if (a[i][j] > '0' && a[i][j] <= '9' && !h.contains(a[i][j]))
                h.add(a[i][j]);
            else
                return false;
        }
        return true;
    }

    boolean checkCube(char a[][], int ii, int jj) {
        HashSet<Character> h = new HashSet<>();
        for (int i = ii; i < ii + 3; i++) {
            for (int j = jj; j < jj + 3; j++) {
                if (a[i][j] == '.')
                    continue;
                if (a[i][j] > '0' && a[i][j] <= '9' && !h.contains(a[i][j]))
                    h.add(a[i][j]);
                else
                    return false;
            }
        }
        return true;
    }
}