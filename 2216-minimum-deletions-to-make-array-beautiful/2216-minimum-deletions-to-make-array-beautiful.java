class Solution {
    public int minDeletion(int[] a) {
        int n=a.length;
        int i=0;
        Stack<Integer>s=new Stack<>();
        int ans=0;
        while(i<n){
            int x=s.size();
            if(x%2!=0){
                if(a[i]==s.peek()){
                    ans++;
                }else{
                    s.push(a[i]);
                }
            }else{
                s.push(a[i]);
            }
            i++;
        }
        if(s.size()%2!=0) ans++;
        return ans;
    }
}