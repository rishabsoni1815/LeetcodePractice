class Solution {
    public List<String> restoreIpAddresses(String s) {
         List<String> ans=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<3&&i<n-3;i++){          //these optimistations to avoid 1st part to be greater than 4
            for(int j=i+1;j<i+4&&j<n-2;j++){//these optimistations to avoid 2nd part to be greater than 4   
                for(int k=j+1;k<j+4&&k<n-1;k++){//these optimistations to avoid 3rd part to greater than 4
                    if(is(s,i,j,k,n)) ans.add(s.substring(0,i+1)+"."+s.substring(i+1,j+1)+"."+s.substring(j+1,k+1)+"."+s.substring(k+1));
                }
            }
        }
        return ans;
    }
    boolean is(String s,int i,int j,int k,int n){
        return valid(s.substring(0,i+1))&&
               valid(s.substring(i+1,j+1))&&
               valid(s.substring(j+1,k+1))&&
               valid(s.substring(k+1));
    }
    boolean valid(String s){
        int n=s.length();
        if(n<0||n>3) return false;//these optimistations to avoid 4th part to be greater than 4
        if(s.charAt(0)=='0'){
            return n==1;
        }
        if(Integer.valueOf(s)>255||Integer.valueOf(s)<=0) {
            return false;
        }
        return true;
    }
}