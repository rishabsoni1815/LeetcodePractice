class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        //doing from right as if doing from left then a array will be modified so ans willbe wrong
        if(n==0) return;
        if(m==0){ //System.out.println("j");
            for(int i=0;i<n;i++){
                a[i]=b[i];
                System.out.println(a[i]+" ");
            }
            return;
        }
      while(n>0&&m>0){
          if(a[m-1]<b[n-1]){
              a[n+m-1]=b[n-1];
              n--;
          }
          else{
              a[n+m-1]=a[m-1];
              m--;
          }
      }
        if(n>0){
            for(int i=n;i>0;i--){
                System.out.println(i+" "+a[i-1]);
                a[i-1]=b[i-1];
            }
        }
    }
}