// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
	public static void main(String args[]) throws IOException { 
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int n = sc.nextInt();
			
			int arr[][] = new int[n][2];
          
        	for( int i=0 ; i<n ; i++ ){            
            	for( int j=0 ; j<2 ; j++ ){
                	arr[i][j] = sc.nextInt();
            	}
         	}
            
            solver solve = new solver();
			System.out.println( solve.max_non_overlapping(arr,n) ); 
			t--;
		}
	} 
}

// } Driver Code Ends


// ranges[i][0] is the start of ith range
// ranges[i][1] is the end of ith range

class solver
{
    static int max_non_overlapping(int a[][], int n){
        // code here
        
        // 1 5       2 3
        // 1 8       1 5
        // 2 3       3 5
        // 3 5       1 8
        Arrays.sort(a,(x,y)->((x[1]!=y[1] ? x[1]-y[1]:x[0]-y[0])));
        int c=1;
        int last=a[0][1];
        for(int i=1;i<n;i++){
            if(a[i][0]>=last){
                last=a[i][1];
                c++;
            }
        }
        return c;
        
        // 1  3      1  3
        // 2  8      2  8
        // 7  9      7  9
        // 10 11     10 11
        // 10 16     10 16
    }
}