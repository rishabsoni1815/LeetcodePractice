class Solution {
    public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,Integer>pro=new HashMap<>();
        for(int i=0;i<c.length;i++) pro.put(i,p[i]);
        Integer a[]=new Integer[p.length];
        for(int i=0;i<p.length;i++){
            a[i]=i;
        }
        Arrays.sort(a,(x,y)->(c[x]-c[y]));
        int ans=0,j=0,n=p.length;
        // for(int i=0;i<n;i++){
        //     System.out.println(a[i]+" "+c[a[i]]+" "+pro.get(a[i]));
        // }
        while(j<n && k>0){
            while(j<n && w>=c[a[j]]){
                q.add(pro.get(a[j]));
                j++;
            }
            if(q.size()>0) w+=q.poll();
            k--;
            // System.out.println(w+" k: "+k);
        }
        while(k-->0 && q.size()>0) w+=q.poll();
        return w;
    }
}