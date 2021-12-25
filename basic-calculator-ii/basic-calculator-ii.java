class Solution {
    public int calculate(String s) {
        int n=s.length();
        char sign='+';
        int i=0;
        Stack<Integer>ans=new Stack<>();
        while(i<n){
            if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
                int val=0;
                while(i<n&&(s.charAt(i)<='9'&&s.charAt(i)>='0')){
                    val=val*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(sign=='+'){
                    ans.push(val);
                }else if(sign=='-'){
                    ans.push(-val);
                }else if(sign=='*'){
                    ans.push(val*ans.pop());
                }else{
                    ans.push(ans.pop()/val);
                }
            }else if(s.charAt(i)!=' '){
                sign=s.charAt(i);
            }
            i++;
        }
        int y=0;
        while(ans.size()>0)y+=ans.pop();
        return y;
    }
}