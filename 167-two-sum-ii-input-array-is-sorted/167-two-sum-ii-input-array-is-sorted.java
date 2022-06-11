class Solution {
    public int[] twoSum(int[] n, int t) {
        int a[]=new int[2];
        int s=n.length;
        int i=0,j=s-1;
        while(i<j){
            if(n[i]+n[j]==t) {
                a[0]=i+1;
                a[1]=j+1;
                return a;
            }
            if(n[i]+n[j]<t){
                i++;
            }
             if(n[i]+n[j]>t){
                j--;
            }
        }
        return a;
    }
}