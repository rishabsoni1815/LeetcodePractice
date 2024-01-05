class Solution {
    public int lengthOfLIS(int[] a) {
        int n=a.length;
        ArrayList<Integer>c=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(c.size()==0) c.add(a[i]);
            else if(c.size()>0 && a[i]>c.get(c.size()-1)){
                c.add(a[i]);
            }else if(c.size()>0 && a[i]<c.get(c.size()-1)){
                int x=find(a[i],c);
                c.set(x,a[i]);
            }
        }
        return c.size();
    }
    int find(int x,ArrayList<Integer>a){
        int ans=0,l=0,r=a.size()-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a.get(m)>=x){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
}