class Solution {
    public String categorizeBox(int l, int w, int h, int m) {
        long v=l*h;
        String ans="",ans1="";
        if(l>=10000||w>=10000||h>=10000){
            ans="Bulky";
        }else if(v*w>=1000000000){
            ans="Bulky";
        }
        if(m>=100){
            ans1="Heavy";
        }
        
        if(ans.equals("Bulky")&&ans1.equals("Heavy")){
            return "Both";
        }else if(ans.equals("Bulky")==false&&ans1.equals("Heavy")==false){
            return "Neither";
        }else if(ans.equals("Bulky")&&ans1.equals("Heavy")==false){
            return "Bulky";
        }else {
            return "Heavy";
        }
    }
}