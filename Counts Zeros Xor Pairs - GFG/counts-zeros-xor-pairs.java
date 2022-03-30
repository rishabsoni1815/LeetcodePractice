// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

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
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    
		    Complete obj = new Complete();
		    long res = obj.calculate(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete{
    //1 1 3 4 4 
   
    // Function for finding maximum and value pair
    public static long calculate (int a[], int n) {
        Arrays.sort(a);
        int i=0;long ans=0;
        while(i<n){
            int cnt=1;
            while(i<(n-1) && a[i]==a[i+1]){
                cnt++;
                i++;
            }
            i++;
            ans+=((cnt*(cnt-1)/2));
        }
        return ans;
    }
    
    
}


