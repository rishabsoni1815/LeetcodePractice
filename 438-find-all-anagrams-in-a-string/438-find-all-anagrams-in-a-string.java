class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return ans;
        int h[]=new int[26];
        for(int i=0;i<p.length();i++){
            h[p.charAt(i)-'a']++;
        }
        int i=0,j=0,c=p.length(),n=s.length();
        while(j<n){
            if(h[s.charAt(j)-'a']>=1){
                c--;
            }
            h[s.charAt(j)-'a']--;
            if(j-i+1<p.length()){
                j++;
            }else{
                if(c==0) ans.add(i);
                if(h[s.charAt(i)-'a']>=0) c++;
                h[s.charAt(i)-'a']++;
                i++;
                j++;
            }
        }
        return ans;
    }
}