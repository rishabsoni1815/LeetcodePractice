class Solution {
    public int numSimilarGroups(String[] a) {
        //like no of islands we will mark string as visited my making a[i]=null
        int ans=0,n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]!=null){
                dfs(i,a);
                ans++;
            }
        }
        return ans;
    }
    void dfs(int k,String a[]){
        if(a[k]==null) return;
        String s=a[k];
        a[k]=null;
        for(int i=0;i<a.length;i++){
            if(a[i]!=null && isSimilar(a[i],s)){
                dfs(i,a);
            }
        }
    }
    boolean isSimilar(String a,String b){
        int k=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) k++;
        }
        if(k==0 || k==2) return true;
        return false;
    }
}