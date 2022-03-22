class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder ans=new StringBuilder();
        while(k>0){
            if((k - (n-1)*26) <=0){
                ans.append('a');
                k--;
            }else{
                char c=(char)(k - (n-1)*26 + 'a' - 1);
                ans.append(c);
                k-=(k - (n-1)*26);
            }
            n--;
        }
        return ans.toString();
    }
}