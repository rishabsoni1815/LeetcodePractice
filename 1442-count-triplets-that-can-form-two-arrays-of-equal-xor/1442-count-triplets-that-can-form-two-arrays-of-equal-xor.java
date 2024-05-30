public class Solution {

    public int countTriplets(int[] arr) {
        int[] prefixXOR = new int[arr.length];
        prefixXOR[0] = arr[0];
        int size = prefixXOR.length;

        // Perform XOR on consecutive elements in the modified array
        for (int i = 1; i < size; i++) {
            prefixXOR[i] ^= (arr[i]^prefixXOR[i - 1]);
        }

        int count = 0;

        // Iterate through the modified array to count triplets
        for (int start = 0; start < size; start++) {
            for (int end = start + 1; end < size; end++) {
                if (prefixXOR[start] == prefixXOR[end]) {
                    // Increment the result by the count of valid triplets
                    count += end - start - 1;
                }else if(start==0 && prefixXOR[end]==0){//case for [0...j] xor till j is zero then we have triplets too but as pre[0]=a[0] so this have to handle seperately 
                    count+=end;
                }
            }
        }

        return count;
    }
}