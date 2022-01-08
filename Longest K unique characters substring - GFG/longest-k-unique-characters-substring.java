// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code 
        HashMap<Character,Integer>h=new HashMap<>();
        int i=0,n=s.length(),ans=-1,j=0;
        while(i<n){
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
            if(h.size()==k){
                ans=Math.max(ans,i-j+1);
            }else if(h.size()>k){
                while(j<n&&h.size()>k){
                    h.put(s.charAt(j),h.get(s.charAt(j))-1);
                    if(h.get(s.charAt(j))==0) h.remove(s.charAt(j));
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
}