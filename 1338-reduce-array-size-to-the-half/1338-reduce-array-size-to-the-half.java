class Solution {
    public int minSetSize(int[] a) {
        HashMap<Integer,Integer>h=new HashMap<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->((x[1]==y[1])?(x[0]-y[0]):(y[1]-x[1])));
        for(int k:h.keySet()){
            q.add(new int[]{k,h.get(k)});
        }
        int m=n;
        int ans=0;
        while(m>(n/2)){
            int t[]=q.poll();
            // System.out.println(t[0]+" "+t[1]);
            m-=t[1];
            ans++;
        }
        return ans;
    }
}