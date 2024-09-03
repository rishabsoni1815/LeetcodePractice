class Solution {
    public int getLucky(String a, int k) {
        StringBuilder s=new StringBuilder();
        for(int i=0;i<a.length();i++){
            s.append(a.charAt(i)-'a'+1);
        }
        while(k-->0){
            int sum=0;
            for(int i=0;i<s.length();i++){
                sum+=(s.charAt(i)-'0');
            }
            s=new StringBuilder();
            s.append(sum);
        }
        return Integer.valueOf(s.toString());
    }
}