class Solution {
    public List<String> removeAnagrams(String[] a) {
        int n=a.length;
        List<String>ans=new ArrayList<>();
        ans.add(a[0]);
        int i=1;
        while(i<n){
            while(i<n && help(a[i],a[i-1])){
                i++;
            }
            if(i<n) ans.add(a[i]);
            i++;
        }
        return ans;
    }
    boolean help(String a,String b){
        int h[]=new int[26];
        for(int i=0;i<a.length();i++){
            h[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            h[b.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(h[i]!=0) return false;
        }
        return true;
    }
}