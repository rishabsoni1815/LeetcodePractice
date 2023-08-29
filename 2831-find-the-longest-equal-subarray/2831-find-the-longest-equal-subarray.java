class Solution {
    public int longestEqualSubarray(List<Integer> a, int k) {
        int n=a.size();
        Map<Integer,List<Integer>>h=new HashMap<>();
        for(int i=0;i<n;i++){
            if(h.containsKey(a.get(i))){
                h.get(a.get(i)).add(i);
            }else{
                List<Integer>t=new ArrayList<>();
                t.add(i);
                h.put(a.get(i),t);
            }
        }
        int ans=1;
        for(int u:h.keySet()){
            List<Integer>c=h.get(u);
            int i=1,j=0,l=c.size(),sum=0;
            while(i<l){
               sum+=c.get(i)-c.get(i-1)-1;
                while(j<i && sum>k){
                    sum-=(c.get(j+1)-c.get(j)-1);
                    j++;
                }
                ans=Math.max(ans,i-j+1);
                i++;
            }
        }
        return ans;
    }
}