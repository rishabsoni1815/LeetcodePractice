class Solution {
    public int bagOfTokensScore(int[] a, int p) {
        int n=a.length;
        Arrays.sort(a);
        int i=0,j=n-1,ans=0,cans=0;
        while(i<=j){
            if(a[i]<=p){
                p-=a[i];
                cans++;
                i++;
            }else{
                if(cans==0) break;
                p+=a[j];
                cans--;
                j--;
            }
            ans=Math.max(ans,cans);
        }
        return ans;
    }
}