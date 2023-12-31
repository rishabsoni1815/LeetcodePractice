class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int h[]=new int[26];
        Arrays.fill(h,-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            if(h[s.charAt(i)-'a']==-1) h[s.charAt(i)-'a']=i;
            else{
                max=Math.max(max,i-h[s.charAt(i)-'a']);
            }
        }
        return max-1;
    }
}