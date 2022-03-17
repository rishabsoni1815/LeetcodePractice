class Solution {
    public int scoreOfParentheses(String s) {
        int i=0,n=s.length();
        Stack<Character>stack=new Stack<>();
        while(i<n){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(stack.size()>0 && stack.peek()=='('){
                    stack.pop();
                    stack.push('1');   
                }else{//adding all the A+B 
                    int cur=0;
                    while(stack.size()>0 && stack.peek()!='('){
                        cur+=(stack.pop()-'0');
                    }
                    stack.pop();
                    stack.push((char)(2*cur +'0'));
                }
            }
            i++;
        }
         int ans=0;
         while(stack.size()>0 && stack.peek()!='('){
               ans+=(stack.pop()-'0');
         }
        return ans;
    }
}