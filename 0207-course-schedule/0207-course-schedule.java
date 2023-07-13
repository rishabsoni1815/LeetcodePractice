class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
   List<Integer> [] g=new ArrayList[numCourses];//represent array of List<Integer> important 
                    //        ^ 
                    //        |
             //     not ArrayList<Integer>[numCourses]
    int[] indegree = new int[numCourses];
    for(int i=0;i<numCourses;i++){
        g[i]=new ArrayList<>();
    }
   for(int t[]:prerequisites){
       g[t[0]].add(t[1]);
       indegree[t[1]]++;
   }
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
        int i=0;
    while (!q.isEmpty()) {
      int node = q.remove();
        i++;
        for(int s:g[node]){
            indegree[s]--;
            if(indegree[s]==0) q.add(s);
        }
    }
    return (i == numCourses);
  }
}