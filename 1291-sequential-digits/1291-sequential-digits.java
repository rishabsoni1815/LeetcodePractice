class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s="123456789";
        List<Integer>ans=new ArrayList<>();
        int n=String.valueOf(low).length();
        while(n<=s.length()){
            for(int j=n;j<=s.length();j++){
                String cur=s.substring(j-n,j);
                int x=Integer.valueOf(cur);
                if(x>=low && x<=high) ans.add(x);
                else if(x>high) return ans;
            }
            n++;
        }
        return ans;
    }
}