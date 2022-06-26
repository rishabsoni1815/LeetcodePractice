class Solution {
    public int characterReplacement(String s, int t) {
        int n=s.length();
        int f[]=new int[26];
        int i=0,j=0,maxf=0,ans=-1;
        while(j<n){
            f[s.charAt(j)-'A']++;
            maxf=Math.max(maxf,f[s.charAt(j)-'A']);
            if((j-i+1)-maxf > t){
                f[s.charAt(i)-'A']--;
                i++;
            }
            ans=Math.max(ans,(j-i+1));
            j++;
        }
        return ans;
    }
}