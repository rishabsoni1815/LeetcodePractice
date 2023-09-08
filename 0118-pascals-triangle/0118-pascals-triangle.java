class Solution {
    public List<List<Integer>> generate(int n) {
        List<Integer>c=new ArrayList<Integer>();
        List<List<Integer>>ans=new ArrayList<>();
        c.add(1);
        ans.add(c);
        for(int i=0;i<n-1;i++){
            List<Integer>t=new ArrayList<Integer>();
            t.add(1);
            for(int j=0;j<c.size()-1;j++){
                t.add(c.get(j)+c.get(j+1));
            }
            t.add(1);
            c=t;
            ans.add(t);
        }
        return ans;
    }
}