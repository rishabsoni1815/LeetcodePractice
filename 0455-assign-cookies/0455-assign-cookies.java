class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=g.length-1,i=s.length-1,c=0;
        while(j>=0 && i>=0){
            if(s[i]>=g[j]){
                i--;j--;
                c++;
            }else{
                j--;
            }
        }
        return c;
    }
}