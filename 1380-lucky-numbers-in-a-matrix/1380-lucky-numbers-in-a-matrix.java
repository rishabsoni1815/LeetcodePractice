class Solution {
    public List<Integer> luckyNumbers (int[][] a) {
        int rm[]=new int[a.length];
        int cm[]=new int[a[0].length];
        Arrays.fill(rm,Integer.MAX_VALUE);
        Arrays.fill(cm,Integer.MIN_VALUE);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                rm[i]=Math.min(rm[i],a[i][j]);
                cm[j]=Math.max(cm[j],a[i][j]);
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]==rm[i] && a[i][j]==cm[j]){
                    ans.add(a[i][j]);
                }
            }
        }
        return ans;
    }
}