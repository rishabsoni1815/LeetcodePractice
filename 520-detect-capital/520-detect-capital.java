class Solution {
    public boolean detectCapitalUse(String word) {
        int n=word.length();
        
            if(Character.isUpperCase(word.charAt(0))){
             if(n>1&&Character.isUpperCase(word.charAt(1)))   {
                     for(int i=1;i<n;i++){
                    if(Character.isUpperCase(word.charAt(i))==false){
                        
                       return false;
                    }
                    
                }
            }
                else{
                    for(int i=1;i<n;i++){
                    if(Character.isUpperCase(word.charAt(i))==true){
                        
                       return false;
                    }
                    
                }
                }
            }
        else{
                  for(int i=1;i<n;i++){
                    if(Character.isUpperCase(word.charAt(i))==true){
                        
                       return false;
                    }
                    
                }
           // return true;
        }
        return true;
    }
}