class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        int freq[]=new int[256];
        for(int i=0;i<n;i++){
            freq[(int)s.charAt(i)]++;
        }
        ArrayList<Character> bucket[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++) bucket[i]=new ArrayList<>();
        for(int i=0;i<256;i++){
            bucket[freq[i]].add((char)(i));
        }
        StringBuilder ans=new StringBuilder();
        for(int i=n;i>=0;i--){
            for(char c:bucket[i]){
                for(int y=i;y>0;y--){
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}