class Solution {
    public int evalRPN(String[] a) {
        int n=a.length;
        //if next is operation do that with pre elemtns else new ele will be processed with operand after that
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<n;i++){
            String c=a[i];
            if(isOp(c)){
                int x=s.pop();
                int y=s.pop();
                if(c.equals("+")) s.add(y+x);
                else if(c.equals("/")) s.add(y/x);
                else if(c.equals("-")) s.add(y-x);
                else s.add(y*x);
            }else{
                s.add(Integer.valueOf(c));
            }
        }
        return s.pop();
    }
    boolean isOp(String c){
        return c.equals("+") ||c.equals("*")||c.equals("/")||c.equals("-");
    }
}

