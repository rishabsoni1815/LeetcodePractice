class Solution {
    public boolean isSubsequence(String s, String t) {
    int n = s.length();
    int m = t.length();
    
    int i = 0, j = 0;
    if(n==0) return true;
    while(i!=m&&j!=n)
    {
        if(j==n) return true;
        if(s.charAt(j)==t.charAt(i)) j++;
        i++;
    }
    
    return (j==n);
    }
}