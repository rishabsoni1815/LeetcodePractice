class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] rb=nsr(heights);//Finding index of next smaller to the right 
        int[] lb=nsl(heights);//Finding index of next smaller to the left
        int maxArea=0,n=heights.length;
        for(int i=0;i<n;i++)
        {
            int w=rb[i]-lb[i]-1;//b/w both rb[i] and lb[i] ( width ) height is height[i]
            int area=w*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    
    public static int[] nsl(int[] nums)
    {
        int[] lb=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        st.push(0);//added first element (actually its index, i.e 0) so that ans. is consistent (take a test case) 
        lb[0]=-1;//-1 so that ans. is consistent (take a test case) 
        for(int i=1;i<nums.length;i++)
        {
            while(st.size()>0&&nums[i]<=nums[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                lb[i]=-1;//-1 so that ans. is consistent (take a test case) 
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
        st.push(nums.length-1);//adding last elemtent(its index actually i.e. n-1) so that ans. is consistent (take a test case) 
        
        //putting indx not value so that can do w=rb[i]-lb[i]-1 for length afterwards as index stored so can get length by this formula
        
        rb[nums.length-1]=nums.length;//next smallest to right for last element is n so that our ans. is consistent (take a test case)
        
        for(int i=nums.length-2;i>=0;i--)
        {
            while(st.size()>0&&nums[i]<=nums[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                rb[i]=nums.length;//not -1 so that ans. is consistent (take a test case) 
            }
            else{
                rb[i]=st.peek();
            }
            st.push(i);
        }
        return rb;
    }
}