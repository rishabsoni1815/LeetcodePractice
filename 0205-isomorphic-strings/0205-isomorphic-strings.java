class Solution {
    
    /*
    
    The idea is that we need to map a char to another one, for example, "egg" and "add", we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'. Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.

So we use two arrays here h1 and h2, initialized space is 256 (Since the whole ASCII size is 256, 128 also works here). Traverse the character of both s and t on the same position, if their mapping values in h1 and h2 are different, means they are not mapping correctly, returen false; else we construct the mapping, since m1 and m2 are both initialized as 0, we want to use a new value when i == 0, so i + 1 works here.
    
    */
    
    public boolean isIsomorphic(String s, String t) {
        int h1[]=new int[256];
        int h2[]=new int[256];
        for(int i=0;i<s.length();i++){
            if(h1[s.charAt(i)]!=h2[t.charAt(i)]){
                return false;//initilially all are zero so this works there too
            }else{
                h1[s.charAt(i)]=i+1;
                h2[t.charAt(i)]=i+1;
            }
        }
        return true;
    }
}