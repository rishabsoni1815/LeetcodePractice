class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] e) {
        
        ArrayList<ArrayList<Integer>>g=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        ArrayList<TreeSet<Integer>>list=new ArrayList<>();
        int in[]=new int[n];
        Queue<Integer>q=new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            g.add(new ArrayList<>());
            ans.add(new ArrayList<>());
            list.add(new TreeSet<Integer>());
        }
        
        for(int i=0;i<e.length;i++){
            in[e[i][1]]++;
            g.get(e[i][0]).add(e[i][1]);
        }
        
        
        for(int i=0;i<in.length;i++){
            if(in[i]==0) {
                q.add(i);
            }
        }
 
        while(q.size()>0){
            int s=q.size();
            for(int j=0;j<s;j++){
                int cur=q.poll();
                for(int nei:g.get(cur)){
                   list.get(nei).add(cur);
                   for(int ele:list.get(cur)){
                       list.get(nei).add(ele);
                   }
                    in[nei]--;
                    if(in[nei]==0){
                       q.add(nei);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int ele:list.get(i)){
                ans.get(i).add(ele);//already sorted in treset in asc order
            }
        }
        return ans;
    }
}