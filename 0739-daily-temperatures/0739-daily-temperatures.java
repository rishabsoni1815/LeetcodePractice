class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer>s=new Stack<>();//kind of next greater element so applying that with putting indices in the stack to get distance for ans[i]
        int ans[]=new int[t.length];
        for(int i=t.length-1;i>=0;i--){
            while(s.size()>0 && t[i]>=t[s.peek()]){
                s.pop();
            }
            if(s.size()>0) ans[i]=s.peek()-i;
            s.push(i);
        }
        return ans;
    }
}