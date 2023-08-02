class Solution {
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=a.length;
        help(n,0,ans,a);
        return ans;
    }
    void help(int n,int i,List<List<Integer>>ans,int a[]){
        if(i==n){
            List<Integer>tt=new ArrayList<>();
            for(int y:a)tt.add(y);
            ans.add(tt);
            return;
        }
        for(int j=i;j<n;j++){
            swap(i,j,a);
            help(n,i+1,ans,a);
            swap(i,j,a);
        }
    }
    void swap(int i,int j,int a[]){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}