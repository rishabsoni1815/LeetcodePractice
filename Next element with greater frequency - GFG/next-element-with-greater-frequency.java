// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends

class Pair{
    int f;
    int i;
    Pair(int f,int i){
        this.f=f;
        this.i=i;
    }
}
class solver
{
    static int[] print_next_greater_freq(int a[], int n)
    {
       HashMap<Integer,Integer>h=new HashMap<>();
        int ans[]=new int [n];
        for(int i=0;i<n;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        Stack<Pair>s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(s.size()>0&&s.peek().f<=h.get(a[i])){
                s.pop();
            }
            if(s.size()>0){
                ans[i]=a[s.peek().i];
            }else{
                ans[i]=-1;
            }
            s.add(new Pair(h.get(a[i]),i));
        }
        return ans;
    }
}

