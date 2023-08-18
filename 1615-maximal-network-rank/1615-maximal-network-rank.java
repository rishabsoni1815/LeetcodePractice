class Solution {
    public int maximalNetworkRank(int n, int[][] a) {
        HashMap<Integer,HashSet<Integer>>m=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(m.containsKey(a[i][0])){
                m.get(a[i][0]).add(a[i][1]);
            }else{
                m.put(a[i][0],new HashSet<Integer>());
                m.get(a[i][0]).add(a[i][1]);
            }
            if(m.containsKey(a[i][1])){
                m.get(a[i][1]).add(a[i][0]);
            }else{
                m.put(a[i][1],new HashSet<Integer>());
                m.get(a[i][1]).add(a[i][0]);
            }
        }
        /*
        int max=-1,smax=-1;
        for(int i=0;i<n;i++){
            if(c[i]>=max){
                smax=max;
                max=c[i];
            }else if(c[i]>smax){
                smax=c[i];
            }
        }
        //as have to check every max and for every max have to check every smax so n^2 have to be there so max smax doesn't work have to check all
        */
        int ans=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cur=0;
                if(m.containsKey(i)) cur+=m.get(i).size();
                if(m.containsKey(j)) cur+=m.get(j).size();
                if((m.containsKey(i) && m.get(i).contains(j))||(m.containsKey(j) && m.get(j).contains(i))) cur--;
                ans=Math.max(ans,cur);
            }
        }
        return ans;
    }
}