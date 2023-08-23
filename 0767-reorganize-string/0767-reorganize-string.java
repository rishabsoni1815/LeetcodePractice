class Solution {
    public String reorganizeString(String s) {
        int h[]=new int[26];
        int max=0;
        char maxv='a';
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a']++;
            if(h[s.charAt(i)-'a']>max){
                max=h[s.charAt(i)-'a'];
                maxv=s.charAt(i);
            }
        }
        int n=s.length();
        char c[]=new char[n];
        if(max>(n+1)/2) return "";
        int idx=0;
        while(max>0){
            c[idx]=maxv;
            idx+=2;
            max--;
        }
        for(int i=0;i<26;i++){
            if(i!=(maxv-'a')){
                while(h[i]>0){
                    if(idx>=n){
                        idx=1;
                    }
                    c[idx]=(char)(i+'a');
                    idx+=2;
                    h[i]--;
                }
            }
        }
        return String.valueOf(c);
    }
}