class Solution {
    public int minimumLength(String s) {
        int n=s.length(),i=0,j=n-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                char c=s.charAt(i);
                while(i<n && s.charAt(i)==c) i++;
                while(j>i && s.charAt(j)==c) j--;
                System.out.println(i+" "+j);
            }else{
                return j-i+1;
            }
        }
        return j-i+1;
    }
}