class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] h, int[] v) {
        HashSet<Integer>h1=new HashSet<>();
        for(int j:h) h1.add(j);
        int max1=1;
        for(int i=0;i<h.length;i++){
            int cnt=1;
            int cur=h[i];
            if(!h1.contains(cur-1)){//h[i] can be start of new seq
                while(h1.contains(cur+1)){
                    cnt++;
                    cur++;
                    max1=Math.max(max1,cnt);
                }
            }
        }
        h1=new HashSet<>();
        for(int j:v) h1.add(j);
        int max2=1;
        for(int i=0;i<v.length;i++){
            int cnt=1;
            int cur=v[i];
            if(!h1.contains(cur-1)){//h[i] can be start of new seq
                while(h1.contains(cur+1)){
                    cnt++;
                    cur++;
                    max2=Math.max(max2,cnt);
                }
            }
        }
        int min=Math.min(max1,max2)+1;
        return min*min;
    }
}