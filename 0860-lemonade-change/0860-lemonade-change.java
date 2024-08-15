class Solution {
    public boolean lemonadeChange(int[] a) {
        int cnt5=0,cnt10=0;
        for(int i=0;i<a.length;i++){
            int t=a[i]-5;
            if(t==15){
                boolean flag=false;
                if(cnt10>0 && cnt5>0){
                    cnt10--;
                    cnt5--;
                    flag=true;
                }else if(cnt5>=3){
                    cnt5-=3;
                    flag=true;
                }
                if(flag==false) return false;
            }
            if(t==10){
                boolean flag=false;
                if(cnt10>0){
                    cnt10--;
                    flag=true;
                }else if(cnt5>=2){
                    cnt5-=2;
                    flag=true;
                }
                if(flag==false) return false;
            }
            if(t==5){
                boolean flag=false;
                if(cnt5>0){
                    cnt5--;
                    flag=true;
                }
                if(flag==false) return false;
            }
            if(a[i]==10) cnt10++;
            if(a[i]==5) cnt5++; 
        }
        return true;
    }
}