class Solution {
    public String decodeString(String a) {
        int n=a.length();
        Stack<Character>s=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            char c=a.charAt(i);
            if(c==']'){
                StringBuilder t=new StringBuilder();
                while(s.size()>0 && isChar(s.peek())){
                    t.append(s.pop());
                }
                s.pop();//remove '['
                int num=0,x=0;
                while(s.size()>0 && isNumber(s.peek())){
                    num=((s.pop()-'0')*(int)(Math.pow(10,x)) + num);
                    x++;
                }
                while(num-->0){
                    String put=t.toString();
                    for(int j=put.length()-1;j>=0;j--){
                        s.add(put.charAt(j));
                    }
                }
            }
            else s.add(c);
        }
        while(s.size()>0){
            ans.append(s.pop());
        }
        return ans.reverse().toString();
    }
    boolean isChar(char c){
        return c>='a' && c<='z';
    }
    boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}