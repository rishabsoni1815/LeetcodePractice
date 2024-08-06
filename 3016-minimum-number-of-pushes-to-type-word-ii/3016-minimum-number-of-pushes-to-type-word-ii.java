class Solution {
    public int minimumPushes(String s) {
        int h[]=new int[26];
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a']++;
        }
        Arrays.sort(h);
        int ans=0,cnt=0;
        for(int i=25;i>=0;i--){
            if(h[i]>0){
                cnt++;
                ans+=(((int)(Math.ceil(cnt/8.0)))*h[i]);
            }else break;
        }
        return ans;
    }
}