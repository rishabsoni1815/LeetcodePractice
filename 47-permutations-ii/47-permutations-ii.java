class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
        HashSet<Integer>s=new HashSet<Integer>();
        for(int j=i;j<n;j++){
            //process-> to place all elements one by one at ith position
            // here to avoid duplicates we will not place sma element at ith position again and again so using hashset to store whether we have placed some element before or not
            if(s.contains(a[j])==false) {
                s.add(a[j]);
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
}