class Solution {
    /// heap 
    
    //2nd aproach - quicksort method of partition
    public int findKthLargest(int[] nums, int k) {
        //shuffle(nums); to random quicksort
        
        return quick(nums,0,nums.length-1,nums.length-k);//kth largest => n-k smallest in sorted array so have to do quick sort until pivot is n-k (run quick sort till n-k as pivot not n-k+1 as 0 based indexing in array while doing quicksort) as pivot n-k means on left of n-k are less than it and on right >= than pivot so when pivot is n-k it means a[k] is the kth largest or (n-k)th smallest 
    }
    int quick(int a[],int l,int r,int k){
       while(l<r){
            int p=partition(a,l,r);
             if(p>k) r=p-1;//if pivot is >k (we don't) need to make pivot an element which is >k that so r=p-1
            else if(p<k) l=p+1;//this binary search technique will further optimise can do simple also
           else break;
       }
        return a[k];// returning a[k] as till 0 to k (n-k originally) array has less than pivot on left na don right > than pivot
    }
    int partition(int a[],int l,int r){
        int pivot=a[r];// rth as pivot
        int pindex=l;
        for(int i=l;i<=r;i++){
            if(a[i]<=pivot){    
                swap(a,i,pindex);
                pindex++;
            }
        }
        return pindex-1;//as on last turn pindex will be pindex++
    }
    void swap(int a[],int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
      private void shuffle(int a[]) {
        Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);//The nextInt(int n) is used to get a random number between 0(inclusive) and the number passed in this argument(n), exclusive.
            swap(a, ind, r);
        }
    }
}