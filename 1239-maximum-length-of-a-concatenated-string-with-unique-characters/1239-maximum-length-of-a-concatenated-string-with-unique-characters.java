class Solution {
    public int maxLength(List<String> a) {
        int n=a.size();
        int c[]=new int[26];
        return dfs(0,n,a,c);
    }
    int dfs(int i,int n,List<String>a,int c[]){
        if(i==n) return 0;
        String s=a.get(i);
        int c1[]=new int[26];
        for(int j=0;j<26;j++) c1[j]=c[j];
        boolean flag=true;
        for(int j=0;j<s.length();j++){
            c[s.charAt(j)-'a']++;
            if(c[s.charAt(j)-'a']>1) {
                flag=false;
                break;
            }
        }
        int res=0;
        if(flag){
            res = s.length()+dfs(i+1,n,a,c);
        }
        res=Math.max(res,dfs(i+1,n,a,c1));
        return res;
    }
}