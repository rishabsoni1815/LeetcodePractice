class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>s1=new Stack<>();
        Stack<Character>s2=new Stack<>();
        int n=s.length(),m=t.length();
        int i=0,j=0;
        while(i<n){
            char c=s.charAt(i);
            if(c!='#'){
                s1.push(c);
            }else{
                if(s1.size()>0){
                    s1.pop();
                }
            }
            i++;
        }
        
        while(j<m){
            char c=t.charAt(j);
            if(c!='#'){
                s2.push(c);
            }else{
                if(s2.size()>0){
                    s2.pop();
                }
            }
            j++;
        }
        
        while(s1.size()>0 && s2.size()>0){
            if(s1.pop()!=s2.pop()) return false;
        }
        if(s1.size()>0||s2.size()>0) return false;
        return true;
    }
}