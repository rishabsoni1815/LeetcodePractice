class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        if(n==0) return 0;
        int m=matrix[0].length;
        int max=0;
        int t[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    t[i][j]+=(matrix[i][j]-'0');
                if(matrix[i][j]=='0') {
                    t[i][j]=0;
                    continue;   
                }
                   if(i!=0) t[i][j]+=(t[i-1][j]);
            }
            max=Math.max(max,largestRectangleArea(t[i]));
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        int[] rb=nsr(heights);//Finding index of next smaller to the right 
        int[] lb=nsl(heights);//Finding index of next smaller to the left
        int maxArea=0,n=heights.length;
        for(int i=0;i<n;i++)
        {
            int w=rb[i]-lb[i]-1;
            int area=w*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    
    public static int[] nsl(int[] nums)
    {
        int[] lb=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        st.push(0);
        lb[0]=-1;
        for(int i=1;i<nums.length;i++)
        {
            while(st.size()>0&&nums[i]<=nums[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                lb[i]=-1;
            }
            else{
                lb[i]=st.peek();
            }
            st.push(i);
        }
        return lb;
    }
    public static int[] nsr(int[] nums)
    {
        int[] rb=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        st.push(nums.length-1);
        rb[nums.length-1]=nums.length;
        for(int i=nums.length-2;i>=0;i--)
        {
            while(st.size()>0&&nums[i]<=nums[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                rb[i]=nums.length;
            }
            else{
                rb[i]=st.peek();
            }
            st.push(i);
        }
        return rb;
    }
}