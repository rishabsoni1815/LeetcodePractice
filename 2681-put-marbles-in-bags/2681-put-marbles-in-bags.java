class Solution {
    public long putMarbles(int[] a, int k) {
        int n=a.length;
        if(n<=2) return 0;
        //https://www.youtube.com/watch?v=RyJpH8cghrE
        // its like putting partitions in array
        // a b | c d e | f i g
        // like this partition then we get b+c and e+f (a,g are already there in total sum) so counting all apairs sum ab,bc,cd,de,ef,fi,ig and getting largest k-1 for max and smallest for min 
        // note  - a,g are compulsary 
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            ans.add(a[i]+a[i+1]);
        }
        Collections.sort(ans);
        long max=a[0]+a[n-1],min=max;//coz a[0] and a[n-1] are compulsary
        //k-1 max
        for(int i=ans.size()-1;i>=(ans.size()-(k-1));i--){
            max+=ans.get(i);
        }
        //k-1 min
        for(int i=0;i<(k-1);i++){
            min+=ans.get(i);
        }
        return max-min;
    }
}