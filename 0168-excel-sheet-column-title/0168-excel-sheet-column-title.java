class Solution {
    public String convertToTitle(int a) {
       // a--;//not one time as every time our system is added by number one when one cycle is completed as if __ two letter word is there for 1 index 0-26 is compensated but for next also there system starts from 1 so have to compensate for that so evey time decrease by one
        StringBuilder s=new StringBuilder("");
        while(a>0){
            a--;
            int x=a%26;
            s.append((char)(x+'A'));
            a/=26;
        }
        return s.reverse().toString();
    }
}