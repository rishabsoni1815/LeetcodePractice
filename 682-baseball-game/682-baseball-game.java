class Solution {
    public int calPoints(String[] a) {
         Stack<Integer>stk=new Stack<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            String cur=a[i];
            if(cur.length()==1){
                if(cur.charAt(0)=='+'){
                    int f=stk.pop();
                    int s=stk.pop();
                    stk.push(s);
                    stk.push(f);
                    stk.push(s+f);
                }else if(cur.charAt(0)=='D'){
                    stk.push(2*stk.peek());
                }else if(cur.charAt(0)=='C'){
                    stk.pop();
                }else{
                    stk.push(Integer.valueOf(cur));
                }
            }else{
                stk.add(Integer.valueOf(cur));
            }
        }
        int ans=0;
        for(int tt:stk){
            ans+=tt;
        }
        return ans;
    }
}