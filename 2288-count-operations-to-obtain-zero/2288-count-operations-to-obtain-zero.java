class Solution {
    public int countOperations(int a, int b) {
        if(a==0 || b==0) return 0;
        if(a>=b){
            return a/b + countOperations(a%b,b);
        }else{
            return b/a + countOperations(a,b%a);
        }
    }
}