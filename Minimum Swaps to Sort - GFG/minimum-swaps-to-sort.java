// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int a[])
    {
        // Code here
        int n=a.length;
        int b[]=new int[n];
        for(int i=0;i<n;i++) {
            b[i]=a[i];
        }
        HashMap<Integer,Integer>h=new HashMap<>();
        Arrays.sort(b);
        for(int i=0;i<n;i++) h.put(b[i],i);
        int ans=0;
        int i=0;
        while(i<n){
            if(a[i]==b[i]){
                i++;
            }else{
                int x=h.get(a[i]);
                int t=a[i];
                a[i]=a[x];
                a[x]=t;
                ans++;
            }
        }
        return ans;
    }
}