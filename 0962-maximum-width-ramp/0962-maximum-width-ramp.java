class Solution {
    public int maxWidthRamp(int[] a) {
        int n=a.length;
        int in[]=new int[n];
        Stack<Integer>s=new Stack<>();//monotonic stack having elements in desc order (filled from right)
        for(int i=n-1;i>=0;i--){
            if(s.size()==0) s.add(i);
            else{
                if(a[s.peek()]<a[i]){
                    s.add(i);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            while(s.size()>0 && a[i]<=a[s.peek()]) {
                ans=Math.max(ans,s.pop()-i);
            }
        }
        return ans;
    }
}




