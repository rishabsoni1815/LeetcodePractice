class Solution {
    public int minIncrementForUnique(int[] a) {
        Arrays.sort(a);
        int ans=0,c=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]<=c){
                if(a[i]==c) c++;
                else {
                    ans+=(c-a[i]);
                    c++;
                }
            }else{
                c=a[i]+1;
            }
        }
        return ans;
    }
}