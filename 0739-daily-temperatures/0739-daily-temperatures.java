class Solution {
    public int[] dailyTemperatures(int[] a) {
        int n=a.length;
        int ans[]=new int[n];
        Stack<Integer>s=new Stack<>();
        int i=a.length-1;
        while(i>=0){
            while(s.size()>0 && a[s.peek()]<=a[i]){
                s.pop();
            }
            if(!s.isEmpty()) ans[i]=s.peek()-i;
            s.add(i);
            i--;
        }
        return ans;
    }
}