class Solution {
    public int[] canSeePersonsCount(int[] a) {
        //https://leetcode.com/problems/number-of-visible-people-in-a-queue/solutions/1363940/cjavapython-monotonic-stack-visualize-pi-bo86
        //able to see all eme in the monotonic inc stack (from right to i) and also if stack is not empty even if the stack top is greater tan me still i can see him so +1
        int n=a.length;
        int i=n-1;
        Stack<Integer>s=new Stack<>();
        int ans[]=new int[n];
        while(i>=0){
            int cnt=0;
            while(s.size()>0 && s.peek()<a[i]){//all these are smaller to a[i] so preple right to a[i] can't see them so popping but a[i] can see so cnt++
                s.pop();
                cnt++;
            }
            if(s.size()>0){
                cnt++;//even if now stack top is > me but still can see him stleast
            }
            s.add(a[i]);
            ans[i]=cnt;
            i--;
        }
        return ans;
    }
}