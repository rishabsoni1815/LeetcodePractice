class Solution {
    public String intToRoman(int num) {
    StringBuilder ans = new StringBuilder();
        while(num>0){
            int x=num/1000;
            if(x>0){
                while(x-->0) ans.append("M");
                num%=1000;
            }
            x=num/100;
            if(x>0){
                if(x==4 || x==9){
                    if(x==4) {
                        ans.append("CD");
                    }
                    if(x==9) {
                        ans.append("CM");
                    }
                }else{
                    if(x<4){
                        while(x-->0) ans.append("C");
                    }else{
                        ans.append("D");
                        x-=5;
                        while(x-->0) ans.append("C");
                    }
                }
                num%=100;
            }
            x=num/10;
            if(x>0){
                if(x==4 || x==9){
                    if(x==4) {
                        ans.append("XL");
                    }
                    if(x==9) {
                        ans.append("XC");
                    }
                }else{
                    if(x<4){
                        while(x-->0) ans.append("X");
                    }else{
                        ans.append("L");
                        x-=5;
                        while(x-->0) ans.append("X");
                    }
                }
                num%=10;
            }
            
            x=num;
            if(x>0){
                if(x==4 || x==9){
                    if(x==4) {
                        ans.append("IV");
                    }
                    if(x==9) {
                        ans.append("IX");
                    }
                }else{
                    if(x<4){
                        while(x-->0) ans.append("I");
                    }else{
                        ans.append("V");
                        x-=5;
                        while(x-->0) ans.append("I");
                    }
                }
                num%=1;
            }
        }
        return ans.toString();
    }
}