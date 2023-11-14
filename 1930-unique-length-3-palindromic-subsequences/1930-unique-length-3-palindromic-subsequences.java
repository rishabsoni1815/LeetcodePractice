class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int a[]=new int[26];
        int b[]=new int[26];
        Arrays.fill(a,-1);
        Arrays.fill(b,-1);
        for(int i=0;i<n;i++){
            int y=s.charAt(i)-'a';
            if(a[y]==-1) a[y]=i;
           if(a[y]!=-1) b[y]=i;
        }
        int ans=0;
        for(int i=0;i<26;i++){//keeping a[i] and b[i] as 1st and last occurance of same alphabet and choosing all possible unique middle elements 
            if(a[i]!=-1&&b[i]!=-1&&a[i]!=b[i]){
                HashSet<Character>h=new HashSet<>();
                for(int ii=a[i]+1;ii<b[i];ii++){
                    h.add(s.charAt(ii));
                }
                ans+=h.size();
            }
        }
        return ans;
    }
}