class Solution {
    public int bestClosingTime(String s) {
        int n=s.length();
        int yc=0,nc=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='Y') yc++;
            else nc++;
        }
        int ans=0,min=yc,cnc=0,cyc=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='Y') cyc++;
            else cnc++;
            int p=cnc+(yc-cyc);
            if(p<min){
                min=p;
                ans=i+1;
            }
        }
        return ans;
    }
}