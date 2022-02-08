class Solution {
    /*
    
    We actually know a little better. In the final tree, value of non-leaf nodes are from maximum leaf values from left and right subtrees.
    
If in the final tree, the maximum value from the array is at deepest level of the tree, its value will be used multiple times for multiple parent nodes, which is obviously not ideal.

So the finding here is we should place the smallest value from array at deepest level. Smallest value here means the product of pair arr[i] and arr[i + 1] where the product is smallest.

What happens to the pair after that? The smaller of the pair will never be used again and we can simply discard it.

The O(N^2) solution is to go through the array, find the index i so that arr[i] * arr[i + 1] (or a[i-1] is the smallest (arr[i] * arr[i + 1] is added to the result) and discard the less of the pair. Keep doing so until arr size is 1.
    
    
    */
    public int mctFromLeafValues(int arr[])
    {
        List<Integer> A = new ArrayList<>();
        for(int d: arr) A.add(d);
        
        int res = 0;
        while(A.size() != 1)
        {
            int minIndex = A.indexOf(Collections.min(A));
            
            if(minIndex > 0 && minIndex < A.size()-1)
                res += A.get(minIndex) * Math.min(A.get(minIndex-1), A.get(minIndex+1));   
            
            else if(minIndex == 0)
                res += A.get(minIndex) * A.get(minIndex+1);
            
            else
                res += A.get(minIndex) * A.get(minIndex-1);
            
            A.remove(minIndex);
        }
        return res;
    } 
}