class Solution {
    public int numSteps(String s) {
        //lets do on the go as carry
        int carry=0,n=s.length(),i=n-1,ans=0;
        while(i>0){//as we want 1 at last (do dry run)
            int x=s.charAt(i)-'0';
            x+=carry;
            if(x%2==0){
                ans++;
            }else{
                //fisrt convert this 1 to zero then divide so ans+=2;
                ans+=2;
                carry=1;
            }
            i--;
        }
        return ans+carry;
    }
}