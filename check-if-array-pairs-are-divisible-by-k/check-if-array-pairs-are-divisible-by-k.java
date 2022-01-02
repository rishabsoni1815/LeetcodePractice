class Solution {
    public boolean canArrange(int[] arr, int k) {
        // if (a+b)%k==0 then if a%k=x then b%k=k-x proof-> ( a=nk+x,b=mk+k-x find a+b ) 
        int[] frequency = new int[k];
        
        for(int num : arr){
            num %= k;
            if(num < 0) num += k;
            frequency[num]++;
        }
        
        if(frequency[0]%2 != 0) return false; // speacial case as f[0]!=f[k-0] wont matter as rem. can't be k so cond. actually is that nos. divible by k should be even so f[0]%2==0 should be always true
        
        for(int i = 1; i <= k/2; i++)
            if(frequency[i] != frequency[k-i]) return false;
			
        return true;
    }
}