class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; ++ i) {
            while(A[i] >= 1 && A[i] <= n && A[i] != A[A[i]-1])
                swap(i, A[i] - 1,A);//swapping until the swapped element also goes to its position
        }
        
        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;
        
        return n + 1;
    }
    void swap(int i,int j,int A[]){
        int t=A[i];
        A[i]=A[j];
        A[j]=t;
    }
}