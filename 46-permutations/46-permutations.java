class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        int n=nums.length;
        h(0,nums,nums.length);
        return ans;
    }
    void h(int i,int a[],int n){
        if(i==n){
           List<Integer>temp=new ArrayList<>();
            for(int ii=0;ii<n;ii++){
                temp.add(a[ii]);
            }
            ans.add(new ArrayList<>(temp));
        }
        for(int j=i;j<n;j++){
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
            h(i+1,a,n);
            t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
    }
}