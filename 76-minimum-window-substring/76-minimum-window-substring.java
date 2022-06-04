class Solution {
    public String minWindow(String s, String p) {
        int n=s.length();
        int m=p.length();
        int req[]=new int[256];
        int h[]=new int[256];
        int count=0,reqcount=0;
        for(int i=0;i<p.length();i++){
            req[p.charAt(i)-'A']++;
        }
        for(int i:req){
            if(i>0) reqcount++;
        }
        int i=0,j=0,ansi=0,ansj=0,ans=Integer.MAX_VALUE;
        //increasing window until reqcount!=count and after that decreasign window size from front until reqcount==count
        while(i<n && j<n){
            if(j<n && reqcount>count){
                char c=s.charAt(j);
                int x=c-'A';
                h[x]++;
                if(h[x]==req[x]) count++;
                j++;
            }
            if(count==reqcount){
                while(i<n &&i<j && reqcount==count){
                    int x=s.charAt(i)-'A';
                    h[x]--;
                    if(req[x]>0 && h[x]<req[x]) count--;
                    i++;
                }
                if((j-i+2)<ans) {
                    ans=(j-i+2);
                    ansi=i-1;//as bcoz of above while loop i is 1 ahead the satrt so j-i+2 not j-i+1 for length
                    ansj=j;
                }
            }
        }
        return s.substring(ansi,ansj);   
    }
}