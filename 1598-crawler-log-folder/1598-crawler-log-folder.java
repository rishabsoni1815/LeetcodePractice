class Solution {
    public int minOperations(String[] a) {
        int n=a.length,depth=0;
        for(int i=0;i<n;i++){
            String cur=a[i];
            if(cur.charAt(0)=='.'){
                if(cur.charAt(1)=='.'){
                    if(depth>0) depth--;
                }
            }else{
                depth++;
            }
        }
        return depth;
    }
}