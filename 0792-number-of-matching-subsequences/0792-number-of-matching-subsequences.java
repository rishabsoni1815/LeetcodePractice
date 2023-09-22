class Solution {
    public int numMatchingSubseq(String s, String[] w) {
        ArrayList<Integer> h[]=new ArrayList[26];
        for(int i=0;i<26;i++){
            h[i]=new ArrayList<>();
        }
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a'].add(i);
        }
        int ans=0;
        for(int i=0;i<w.length;i++){
            String c=w[i];int x=-1,cnt=0;
            for(int j=0;j<c.length();j++){
                int y=help(x,h[c.charAt(j)-'a']);
                // System.out.println(x+" "+y+" "+c);
                if(y>x && y!=-1){
                    cnt++;
                    x=y;
                }else{
                    break;
                }
            }
            if(cnt==c.length()) ans++;
        }
        return ans;
    }
    int help(int k,ArrayList<Integer>a){
        int n=a.size();
        int l=0,r=n-1,ans=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a.get(m)>k){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans==-1?-1:a.get(ans);
    }
}