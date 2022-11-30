class Solution {
    public boolean uniqueOccurrences(int[] a) {
        int h[]=new int[100000];
        for(int i=0;i<a.length;i++){
            h[a[i]+1001]++;
        }
        HashSet<Integer>s=new HashSet<>();
        for(int k:h){
            if(k!=0 && s.add(k)==false) return false;
        }
        return true;
    }
}