class Data{
    public Data(int i, int j,int k) {
		this.index=i;
		this.inputt=j;
		this.proct=k;
	}
	int index;
    int inputt;
    int proct;
}
class Solution {
    public int[] getOrder(int[][] a) {
        int n = a.length;
        int[] ans = new int[n];
        Data tasks[]=new Data[n];
        for(int i=0;i<n;i++) {
        	tasks[i]=new Data(i,a[i][0],a[i][1]);
        }
        Arrays.sort(tasks,(x,y)->x.inputt-y.inputt);
        PriorityQueue<Data>p=new PriorityQueue<>((x,y)->x.proct==y.proct ? x.index-y.index:x.proct-y.proct);
        int i=0;
        int j=0;
        int time=0;
        while(j<n || !p.isEmpty()) {
           while(j<n&&tasks[j].inputt<=time) {
        	   p.add(tasks[j]);
        	   j++;
           }
           if(!p.isEmpty()) {
        	   Data temp=p.poll();
        	   time+=temp.proct;
        	   ans[i]=temp.index;
        	   i++;
           }
           else {
               time=tasks[j].inputt;
        	   continue;
           }
        }
        return ans;
    }
    
}