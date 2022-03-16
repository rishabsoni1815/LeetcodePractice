class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>stack=new Stack<>();
        int n=pushed.length;
        int j=0;
        for(int i=0;i<n;i++){
            stack.push(pushed[i]);
            while(j<n && stack.size()>0 && popped[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }
        return j==n;
    }
}