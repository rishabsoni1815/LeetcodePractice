class Solution {
    public int minCost(String s, int[] t) {
        int c=0,n=s.length();
        int i=0,j=1;
        while(i<n && j<n){
            if(s.charAt(i)==s.charAt(j)){
                if(t[i]<=t[j]){
                    c+=t[i];
                    i=j;
                    j++;
                }else{
                    c+=t[j];
                    j++;
                }
                // System.out.println(i+" "+j);
            }else{
                i=j;
                j++;
            }
        }
        return c;
    }
}
// "a a a  b b b a b b b b"
// [3,5,10,7,5,3,5,5,4,8,1]
// 3  
//    8
//           13
//             16
//                 20
//                     25
        
