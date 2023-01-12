class Solution {
    public int[] countSubTrees(int n, int[][] e, String s) {
        int ans[]=new int[n];
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<e.length;i++){
            g.get(e[i][0]).add(e[i][1]);
            g.get(e[i][1]).add(e[i][0]);
        }
        HashSet<Integer>v=new HashSet<>();
        dfs(0,v,g,s,ans);
        return ans;
    }
    int[] dfs(int i,HashSet<Integer>v,ArrayList<ArrayList<Integer>>g,String s,int ans[]){
        v.add(i);
        int c=s.charAt(i)-'a';
        int a[]=new int[26];
        a[c]++;
        for(int nei:g.get(i)){
            if(v.contains(nei)==false){
                int x[]=dfs(nei,v,g,s,ans);
                for(int ii=0;ii<26;ii++){
                    a[ii]+=x[ii];
                }
            }
        }
        ans[i]=a[c];
        return a;
    }
}