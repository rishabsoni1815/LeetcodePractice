class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer>stack=new Stack<>();
        int n=s.length();
        char c[]=s.toCharArray();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            if(c[i]=='('){
                stack.push(i);
            }else if(c[i]==')'){
                if(stack.size()>0 && c[stack.peek()]=='('){
                    stack.pop();
                }else{
                    c[i]='*';//as it is invalid and we will remove it afterwords
                }
            }
        }
        while(stack.size()>0){
            c[stack.pop()]='*';//this is why we were putting index into stack
        }
        for(int i=0;i<n;i++){
            if(c[i]!='*'){
                ans.append(c[i]);
            }
        }
        return ans.toString();
    }
}