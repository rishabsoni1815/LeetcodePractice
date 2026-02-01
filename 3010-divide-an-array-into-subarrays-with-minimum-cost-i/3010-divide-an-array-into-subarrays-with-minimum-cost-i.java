class Solution {
    public int minimumCost(int[] a) {
        int mini=-1,val=Integer.MAX_VALUE,sval=val;
        for(int i=1;i<a.length;i++){
            if(a[i]<val){
                sval=val;
                val=a[i];
            }else if(a[i]<sval){
                sval=a[i];
            }
        }
        return a[0]+val+sval;
    }
}