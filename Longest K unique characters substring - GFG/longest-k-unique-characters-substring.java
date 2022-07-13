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
    public int longestkSubstr(String s, int t) {
        // code here
        int h[]=new int[26];
        int i=0,j=0,n=s.length(),k=0,max=0;
        while(j<n){
            h[s.charAt(j)-'a']++;
            if(h[s.charAt(j)-'a']==1){
                k++;
            }
            if(k<t){
                j++;
            }
            if(k==t){
                max=Math.max(max,j-i+1);
                j++;
            }
            else if(k>t){
                while(k>t){
                    if(h[s.charAt(i)-'a']>0){
                        h[s.charAt(i)-'a']--;
                        if(h[s.charAt(i)-'a']==0){
                            k--;
                        }
                    }
                    i++;
                }
                j++;
            }
        }
        return max==0?-1:max;
    }
}