class Solution {
    public int largestRectangleArea(int[] a) {
        int l[]=help(a);
        int n=a.length;
        int ans=0;
        int i=n-1;
        Stack<Integer>s=new Stack<>();
        while(i>=0){
            while(s.size()>0 && a[s.peek()]>=a[i]){
                s.pop();
            }
            int r=n;
            if(s.size()>0) r=s.peek();
            int area=a[i]*((i-l[i]-1)+(r-i-1)+1);
            ans=Math.max(ans,area);
            s.add(i);
            i--;
        }
        return ans;
    }

    int[] help(int a[]) {
        int n = a.length;
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        int i = 0;
        Stack<Integer> s = new Stack<>();
        while (i < n) {
            while (s.size() > 0 && a[s.peek()] >= a[i]) {
                s.pop();
            }
            if (s.size() > 0)
                ans[i] = s.peek();
            s.add(i);
            i++;
        }
        return ans;
    }
}