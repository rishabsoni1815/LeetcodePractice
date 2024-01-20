class Solution {
    public int sumSubarrayMins(int[] a) {
          //if we find the number of elements till which i can expand in left and right i.e eg [2,3,4,0,5,6,1,2,3] for 1 the count of element till which it can expand (furst element lass than 1) is 3 and similar for right as well then contribution is (a[i]*(l+1)*(r+1)) in our stack we are maintaining l+1 and r+1 only and one edge case is when we have duplicates so for [2,2] the subarrays are [[2],[2,2],[2]] so for one of the side whe have to find smallest number less than or equal to 2 as contribution here is ((2*2)+(2*1)) = 5 so for left we are finding lesss than or equal to 2 here ( can be done for right too)
        // https://www.youtube.com/watch?v=5Hag64mLXac
        
        int n=a.length;
        int l[]=findLeft(a,n);
        int r[]=findRight(a,n);
        int ans=0;
        for(int i=0;i<n;i++){
            ans=(int)((((long)l[i]*r[i]*a[i])%1000000007)+ans)%1000000007;
        }
        return ans;
    }
    
    int [] findLeft(int a[],int n){
        Stack<int []>s=new Stack<>();//0->element,1->count
        int l[]=new int[n];
        for(int i=0;i<n;i++){
            int cnt=1;
            while(s.size()>0 && a[i]<=s.peek()[0]){//handling duplicates so less than or equal so including duplicates too as putting < will not count duplicates in ans
                cnt+=s.pop()[1];
            }
            s.push(new int[]{a[i],cnt});
            l[i]=cnt;
        }
        return l;
    }
    
    int [] findRight(int a[],int n){
        Stack<int []>s=new Stack<>();//0->element,1->count
        int r[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int cnt=1;
            while(s.size()>0 && a[i]<s.peek()[0]){
                cnt+=s.pop()[1];
            }
            s.push(new int[]{a[i],cnt});
            r[i]=cnt;
        }
        return r;
    }
}