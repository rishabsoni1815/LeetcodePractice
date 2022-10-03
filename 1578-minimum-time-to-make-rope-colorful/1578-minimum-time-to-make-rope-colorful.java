class Solution {
    public int minCost(String s, int[] t) {
        int c=0,n=s.length();
        int i=0,j=1;
        while(i<n && j<n){
            if(s.charAt(i)==s.charAt(j)){
                if(t[i]<=t[j]){
                    c+=t[i];
                    i=j;//not i++ as i and j may have diff grt>1 
                    j++;
                }else{
                    c+=t[j];
                    j++;
                }
            }else{
                i=j;//not i++ as i and j may have diff grt>1 
                j++;
            }
        }
        return c;
    }
}
