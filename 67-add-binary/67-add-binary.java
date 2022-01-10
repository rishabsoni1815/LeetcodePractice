class Solution {
    public String addBinary(String a, String b) {
        int n=a.length()-1,m=b.length()-1;
        StringBuilder ans = new StringBuilder();int c=0;
        while(n>=0||m>=0){
            int x=0;int y=0;
            if(n>=0)x=a.charAt(n)-'0';
            if(m>=0)y=b.charAt(m)-'0';
            int z=(x+y+c);
            if(z>=2){
                if(z==2){
                    z=0;c=1;
                }
                else {
                    z=1;c=1;
                }
            }else{
                c=0;
            }
            ans.append(z);
            n--;m--;
        }
        if(c>0){
            ans.append(c);
        }
        return ans.reverse().toString();
    }
}