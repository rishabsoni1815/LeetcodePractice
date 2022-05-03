class Solution {
    public int findUnsortedSubarray(int[] a) {
        int n=a.length;
        int l=n,r=0;
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<n;i++){
            while(s.size()>0&&a[s.peek()]>a[i]){
                l=Math.min(l,s.pop());
            }
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(s.size()>0&&a[s.peek()]<a[i]){
                r=Math.max(r,s.pop());
            }
            s.push(i);
        }
        return r-l>0 ? r-l+1 : 0;
    }
}