class Solution {
    public int[] finalPrices(int[] a) {
        Stack<Integer>s=new Stack<>();
        int n=a.length;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(s.size()>0 && s.peek()>a[i]){
                s.pop();
            }
            if(s.size()>0){
                ans[i]=a[i]-s.peek();
            }else{
                ans[i]=a[i];
            }
            s.push(a[i]);
        }
        return ans;
    }
}