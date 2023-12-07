class Solution {
    public String largestOddNumber(String a) {
        for(int i=a.length()-1;i>=0;i--){
            if((a.charAt(i)-'0')%2!=0) return a.substring(0,i+1);
        }
        return "";
    }
}