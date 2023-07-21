class Solution {
   public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    // if combining with i makes a longer increasing subsequence
                    if (len[j]+1 > len[i]) {
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    }
                    // if combining with i makes another longest increasing subsequence
                    else if (len[j]+1 == len[i]) {
                        cnt[i] += cnt[j];    
                    }  
                }
            }
            max_len=Math.max(max_len,len[i]);
        }
       for(int i=0;i<n;i++){
           if(len[i]==max_len){
               res+=cnt[i];
           }
       }
        return res;
    }
}