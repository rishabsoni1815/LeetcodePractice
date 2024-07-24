class Solution {
    public int[] sortJumbled(int[] h, int[] nums) {
        int n=nums.length;
        int ans[][]=new int[n][3];
        for(int i=0;i<n;i++){
            String now=convert(nums[i],h);
            ans[i][0]=Integer.valueOf(now);
            ans[i][1]=i;
            ans[i][2]=nums[i];
        }
        Arrays.sort(ans,(x,y)->((x[0]==y[0])?(x[1]-y[1]):(x[0]-y[0])));
        for(int i=0;i<n;i++){
            nums[i]=ans[i][2];
        }
        return nums;
    }
    String convert(int k,int h[]){
        String s=String.valueOf(k);
        char a[]=s.toCharArray();
        for(int i=0;i<s.length();i++){
            char c=a[i];
            a[i]=(char)(h[c-'0']+'0');
        }
        return String.valueOf(a);
    }
}