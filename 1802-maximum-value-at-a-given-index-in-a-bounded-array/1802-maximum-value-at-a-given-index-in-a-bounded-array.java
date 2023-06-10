class Solution {
    public int maxValue(int n, int id, int s) {
        s-=n;//giving 1 to all as min is 1 not 0 (written nums[i] is a positive integer)
        int ans=0,i=0,j=s;
        while(i<=j){
            int m=(i+(j-i)/2);
            if(help(m,n,id,s)){
                ans=m;
                i=m+1;
            }else{
                j=m-1;
            }
        }
        return Math.max(1,ans+1);//ans+1 as alerady we did s-=n in first
    }
    //The sum of arithmetic sequence {a, a+1, ....b},equals to (a + b) * (b - a + 1) / 2.
    boolean help(int m,int n,int id,int s){
        long res=0L;
        int l=Math.max(0,m-id);
        res=((long)(m+l)*(m-l+1)/2);
        int r=Math.max(0,m-((n-1)-id));
        res+=((long)(m+r)*(m-r+1)/2);//not m-r as sequence is [a,a-1,a-2....b] i.e [a,...b+2,b+1,b]
        res-=m;//while adding res we added m twice 
        return res<=s;
    }
}