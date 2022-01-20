class Solution {
    public int longestConsecutive(int[] a) {
        if(a.length<=1) return a.length;
        int max=1,n=a.length;
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i<n;i++){
           h.add(a[i]);
        }
        for(int i=0;i<n;i++){
            if(!h.contains(a[i]+1)){
                int u=a[i]-1,cmax=1;
                while(h.contains(u)){
                    u--;
                    cmax++;
                }
               max=Math.max(max,cmax);
            }
            /*
                the idea of thinking is this the end of the lcs if it is then see all present less
                than it and to prevent o(n^2) see if a[i]+1 is present if it is then this elemnt
                can't be end as there is some other bigger end present 
                by this set can be used to supplement the size of max of all elements array approach
                {
                 approach of  o(max. of all emements) to find max and then check if while(max-1) is 
                 present if not then update cmax to 1 else cmax++
                }
                we can check all while(max-1) present in this set only by thinking of it as end of the final subsequence for more details check gfg article of this approach 
                Link --->   https://www.geeksforgeeks.org/longest-consecutive-subsequence/
            */
        }
        return max;
    }
}
        