class Solution {
    public String[] divideString(String s, int k, char f) {
        int n=s.length();
        String ans[]=new String[(int)Math.ceil(n/(double)k)];
        int in=0;
        StringBuilder c=new StringBuilder();
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<k;j++){
                if(j+k*i<s.length()) c.append(s.charAt(j+k*i));
                else c.append(f);
            }          
            ans[i]=c.toString();
            c=new StringBuilder();
        }
        return ans;
    }
}