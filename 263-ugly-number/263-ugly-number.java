class Solution {
    public boolean isUgly(int num) {
        if(num==1) return true;
        if(num==0) return false;	
        while(num%5==0) num=num/5;
        while(num%2==0) num=num>>1;
        while(num%3==0) num=num/3;
        return num==1;  
    }
}