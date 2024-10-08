class Solution {
    public int minSwaps(String a) {
        Stack<Character>s=new Stack<>();
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            if(s.size()==0){
                s.push(c);
            }else if(c==']'){
                if(s.size()>0){
                    if(s.peek()=='[') s.pop();
                    else s.push(c);
                }
            } else s.push(c);
        }
        if((s.size()/2)%2==0) return (s.size()/2)/2;
        else return (s.size()/2)/2 + 1;
    }
}

