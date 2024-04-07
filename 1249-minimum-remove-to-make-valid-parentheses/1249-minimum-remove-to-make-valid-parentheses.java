class Solution {
/*    public String minRemoveToMakeValid(String s) {//delte will take more complexity so we will just mark and in last make new string
        int n=s.length();
        Stack<Integer>c=new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<n;i++){//idea is to just keep track of unwanted braces in stack with there indices and remove at last
            if(s.charAt(i)=='('){
                c.push(i);
            }else if(s.charAt(i)==')'){
                if(c.size()>0 && sb.charAt(c.peek())=='('){
                    c.pop();    
                }else c.push(i);
            }
            sb.append(s.charAt(i));
        }
        while(c.size()>0){
            sb.deleteCharAt(c.pop());
        }
        return sb.toString();
    }
    */
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