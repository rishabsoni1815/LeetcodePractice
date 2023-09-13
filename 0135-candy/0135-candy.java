class Solution {
    /*
    
    Do it in two directions.
The first loop makes sure children with a higher rating get more candy than its left neighbor; the second loop makes sure children with a higher rating get more candy than its right neighbor.
    
    */
    
    
   public int candy(int[] ratings) {
      int n = ratings.length;
      int[] res = new int[n];
      Arrays.fill(res, 1);
      for(int i = 1; i < n; i++){
        if(ratings[i] > ratings[i - 1]){
          res[i] = res[i - 1] + 1;            
        }  
      }    
      
      for(int i = n - 2; i >=0; i--){
        if(ratings[i + 1] < ratings[i]){
          res[i] = Math.max(res[i+1] + 1, res[i]);    
        }
      }
      
      int sum = 0;
      for(int r: res) sum += r;
      
      return sum;
    }
}