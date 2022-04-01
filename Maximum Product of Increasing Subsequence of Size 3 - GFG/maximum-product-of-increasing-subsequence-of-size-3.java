// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
	        
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.maxProductSubsequence(arr, N);
        	if(ans.get(0) == -1)
        	    System.out.println("Not Present");
        	else{
        	    for(int i: ans)
        	        System.out.print(i + " ");
        	    System.out.println();
        	}
        	
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    public static ArrayList<Integer> maxProductSubsequence (int a[], int n) {
        //Complete the function
        TreeSet<Integer>h=new TreeSet<>();
        long dp[]=new long[n];
        for(int i=0;i<n;i++){
            Integer t=h.lower(a[i]);
            if(t!=null){
                dp[i]=t;
            }
            h.add(a[i]);
        }
        long ans=Long.MIN_VALUE;long max=-1L;
        ArrayList<Integer>ansList=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            long p=(long)a[i]*(long)max*(long)dp[i];
            if(dp[i]!=0 && p>ans && max!=-1 && max>a[i]){
                ansList.removeAll(ansList);
                ansList.add((int)dp[i]);
                ansList.add(a[i]);
                ansList.add((int)max);
                ans=p;
            }
            max=Math.max(a[i],max);
        }
        if(ansList.size()==0) ansList.add(-1);
        return ansList;
    }
    
    
}

