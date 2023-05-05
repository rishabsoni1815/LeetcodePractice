class Solution {
    public int maxVowels(String s, int k) {
        int n= s.length();
        int x=0,max=0;
        for(int i=0;i<n;i++){
            if(i<k){
                if(isVowel(s.charAt(i))){
                    x++;
                }
            }else{
                max=Math.max(max,x);
                if(isVowel(s.charAt(i-k))){
                    x--;
                }
                if(isVowel(s.charAt(i))){
                    x++;
                }
            }
        }
        max=Math.max(max,x);
        return max;
    }
    boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }
}