class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
            }else{
                if(stack.size()>0 && stack.peek()=='('){
                    stack.pop();
                }else{
                    ans++;
                }
            }
        }
        ans+=stack.size();
        return ans;
    }
}