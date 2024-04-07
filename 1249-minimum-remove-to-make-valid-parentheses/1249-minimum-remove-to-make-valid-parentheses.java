class Solution {
    public String minRemoveToMakeValid(String s) {
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
}