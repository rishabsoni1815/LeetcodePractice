class Solution {
    public int longestConsecutive(int[] a) {
        if(a.length<=1) return a.length;
        int max=1,n=a.length;
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i<n;i++){
           h.add(a[i]);
        }
        for(int i=0;i<n;i++){
            int cans=0;
            if(h.contains(a[i]+1)==false){
                int c=a[i];
                while(h.contains(c)){
                    h.remove(c);
                    c--;
                    cans++;
                }
            }
            max=Math.max(max,cans);
        }
        return max;
    }
}
        