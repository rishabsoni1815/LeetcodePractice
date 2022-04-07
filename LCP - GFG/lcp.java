// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            
            String s[] = new String[n];
            for(int i=0;i<n;i++)
            {
                s[i] = sc.next();
            }
            Solution T = new Solution();
            System.out.println(T.lcp(s,n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String lcp(String a[],int n)
    {
        // Write your code here
        
         if(a.length==0) return "-1";
        String s=a[0];
        int ans=a[0].length();
        for(int i=1;i<a.length;i++){
            int j=0,k=0;
            while(j<s.length()&&k<a[i].length()){
                if(s.charAt(j)==a[i].charAt(k)){
                    j++;
                    k++;
                }else{
                    break;
                }
            }
            ans=Math.min(ans,k);
        }
        if(ans==0) return "-1";
        return s.substring(0,ans);
    }
}
