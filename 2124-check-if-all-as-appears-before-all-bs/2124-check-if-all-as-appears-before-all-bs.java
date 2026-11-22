class Solution {
    public boolean checkString(String s) {
        boolean found=false;
        for(char c:s.toCharArray()){
            if(c=='b') found=true;
            if(found && c=='a') return false;
        }
        return true;
    }
}