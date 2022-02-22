class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        //make every string as Integer.valueOf() 
        
        /// heap 
    
    //2nd aproach - quicksort method of partition
          shuffle(nums);
        return quick(nums,0,nums.length-1,nums.length-k);//kth largest => n-k smallest in sorted array so have to do quick sort until pivot is n-k (run quick sort till n-k as pivot not n-k+1 as 0 based indexing in array while doing quicksort) as pivot n-k means on left of n-k are less than it and on right >= than pivot so when pivot is n-k it means a[k] is the kth largest or (n-k)th smallest 
    }
    String quick(String a[],int l,int r,int k){
       while(l<r){
            int p=partition(a,l,r);
             if(p>k) r=p-1;//if pivot is >k (we don't) need to make pivot an element which is >k that so r=p-1
            else if(p<k) l=p+1;
           else break;
       }
        return a[k];// returning a[k] as till 0 to k (n-k originally) array has less than pivot on left na don right > than pivot
    }
    int partition(String a[],int l,int r){
        String pivot=a[r];// rth as pivot
        int pindex=l;
        for(int i=l;i<r;i++){
            if(compare(a[i],pivot)<=0){    // if a[i]<=pivot then swap i.e. compare return <0
                swap(a,i,pindex);
                pindex++;
            }
        }
        swap(a,pindex,r);//at last placing a[r] on correct place
        return pindex;
    }
    void swap(String a[],int i,int j){
        String t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    int compare(String a,String b){
        // >0 if a is greater than b
        if(a.length()!=b.length()){
            if(a.length()>b.length()) return 1;
            return -1;
        }else{
            return a.compareTo(b);// returns >0 if a is greater than b if a.length = b.length if same returns 0
        }
    }
     private void shuffle(String a[]) {
        Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    
    private void exch(String[] a, int i, int j) {
        final String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}