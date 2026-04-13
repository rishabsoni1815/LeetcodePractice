class Solution {
    public int getMinDistance(int[] a, int t, int s) {
        ArrayList<Integer>ans=new ArrayList<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]==t) ans.add(i);
        }
        int y=Integer.MAX_VALUE;
        for(int i=0;i<ans.size();i++){
            y=Math.min(y,Math.abs(ans.get(i)-s));
        }
        return y;
    }
}