class Solution {
    public int findKthLargest(int[] a, int k) {
        int n=a.length;
        if(n==1) return a[0];
        k=n-k;
        int nas=qSort(a,0,n-1,k);
        // for(int i=0;i<n;i++) System.out.print(a[i]+" ");
        // System.out.println();
        return nas;
    }
    int qSort(int a[],int i,int j,int k){
        // System.out.println(i+" "+j);
        if(i<=j){
            int p=getPartition(a,i,j);//p is at right place sort i...p-1 and p+1...j
            
        //     for(int ii=0;ii<a.length;ii++) System.out.print(a[ii]+" ");
        // System.out.println(" pivot - "+p+" "+a[p]);
            
            if(p==k) return a[p];        
            int y=qSort(a,i,p-1,k);
            if(y!=-1) return y;
            y=qSort(a,p+1,j,k);
            if(y!=-1) return y;
        }
        return -1;
    }
    int getPartition(int a[],int i,int j){
        int pivot=j;//last index as pivot
        int cur=i,l=i;
        while(l<=j && cur<=j){
            if(a[cur]<=a[pivot]){//swap l and cur
                int temp=a[l];
                a[l]=a[cur];
                a[cur]=temp;
                l++;
            }
            cur++;
        }
        return l-1;
    }
}