class Solution {
    public String intToRoman(int num) {
        String ans="";
        while(num>0){
            int x=num/1000;
            if(x>0){
                while(x-->0) ans+='M';
                num%=1000;
            }
            x=num/100;
            if(x>0){
                if(x==4 || x==9){
                    if(x==4) {
                        ans+="CD";
                    }
                    if(x==9) {
                        ans+="CM";
                    }
                }else{
                    if(x<4){
                        while(x-->0) ans+='C';
                    }else{
                        ans+='D';
                        x-=5;
                        while(x-->0) ans+='C';
                    }
                }
                num%=100;
            }
            x=num/10;
            if(x>0){
                if(x==4 || x==9){
                    if(x==4) {
                        ans+="XL";
                    }
                    if(x==9) {
                        ans+="XC";
                    }
                }else{
                    if(x<4){
                        while(x-->0) ans+='X';
                    }else{
                        ans+='L';
                        x-=5;
                        while(x-->0) ans+='X';
                    }
                }
                num%=10;
            }
            
            x=num;
            if(x>0){
                if(x==4 || x==9){
                    if(x==4) {
                        ans+="IV";
                    }
                    if(x==9) {
                        ans+="IX";
                    }
                }else{
                    if(x<4){
                        while(x-->0) ans+='I';
                    }else{
                        ans+='V';
                        x-=5;
                        while(x-->0) ans+='I';
                    }
                }
                num%=1;
            }
        }
        return ans;
    }
}