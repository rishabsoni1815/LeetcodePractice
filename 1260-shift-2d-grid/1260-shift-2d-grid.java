class Solution {
    public List<List<Integer>> shiftGrid(int[][] a, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=a.length;
        int m=a[0].length;
        k%=(n*m);
        int i=(n-(k/m)-1);
        int j=(m-(k%m));
        if(k%m==0) {
            j=0;
            i=n-(k/m);
        }
        if(k==0) {
            j=0;
            i=0;
        }
        int c=0;
        List<Integer>cur=new ArrayList<>();
        while(c<(n*m)){
            c++;
            // System.out.println(i+" "+j+" "+c);
            cur.add(a[i][j]);
            if(cur.size()==m) {
                ans.add(new ArrayList<>(cur));
                cur.removeAll(cur);
            }
            if(j+1 ==m) i=(i+1)%n;
            j=(j+1)%m;
        }
        return ans;
    }
}