public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        // O(2n) sol. as j and i both moved n times
        // int n = s.length(), ans = 0;
        // int i=0,j=0;
        // HashSet<Character>h=new HashSet<>();
        // while(j<n){
        //     char c=s.charAt(j);
        //     if(!h.contains(c)){
        //         h.add(c);
        //         j++;
        //         ans=Math.max(ans,j-i);
        //     }else{
        //         h.remove(s.charAt(i)); 
        //         i++; 
        //     }
        // }
        // return ans;
        
        
        //optimised O(n)   --- TUF
        // storing the last index of element (rightest i.e closest to curr(right here) index ) to stop from doing l++ for each step
        HashMap<Character,Integer>h=new HashMap<>();
        int left=0,right=0,n=s.length(),len=0;
        while(right<n){
            if(h.containsKey(s.charAt(right))){
                left=Math.max(left,h.get(s.charAt(right)) +1 );//maybe last index is before left only so to counter that
            }
            
            h.put(s.charAt(right),right);
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}