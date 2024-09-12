class Solution {
    public int countConsistentStrings(String s, String[] w) {
        int h[]=new int[26];
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a']++;
        }
        int ans=0;
        for(int i=0;i<w.length;i++){
            boolean flag=false;
            for(int j=0;j<w[i].length();j++){
                if(h[w[i].charAt(j)-'a']==0) flag|=true; 
            }
            if(!flag) ans++;
        }
        return ans;
    }
}