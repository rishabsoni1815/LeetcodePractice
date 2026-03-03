class Solution {
    public char findKthBit(int n, int k) {
        return help(new StringBuilder("0"),n,k,1);
    }
    char help(StringBuilder s,int n,int k,int i){
        if(i==n){
            return s.charAt(k-1);
        }
        StringBuilder temp=new StringBuilder(s);
        convert(s);
        temp.append(1);
        temp.append(s); 
        return help(temp,n,k,i+1);
    }
    StringBuilder convert(StringBuilder s){
        for(int i=0;i<s.length();i++){
            char nc='0';
            if(s.charAt(i)=='0') nc='1';
            s.setCharAt(i,nc);
        }
        return s.reverse();
    }
}