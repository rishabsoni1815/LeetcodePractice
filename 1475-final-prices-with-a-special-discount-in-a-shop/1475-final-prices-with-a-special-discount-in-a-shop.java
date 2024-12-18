class Solution {
    public int[] finalPrices(int[] a) {
        int n=a.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++) ans[i]=a[i];
        Stack<Integer>s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(s.size()>0 && s.peek()>a[i]){
                s.pop();
            }
            if(s.size()>0) ans[i]-=s.peek();
            s.add(a[i]);
        }
        return ans;
    }
}