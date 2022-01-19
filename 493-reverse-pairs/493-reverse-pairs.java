class Solution {
    public int reversePairs(int[] nums) {
        // merge function of mergesort like we did in https://www.geeksforgeeks.org/counting-inversions/
       return mergeSort(nums,0,nums.length-1);
        // time = O(nlogn)+O(n) ( merge fn) +O(n) (finding a[i]>2*a[j])
    }
    int mergeSort(int nums[],int low,int high){
        //explain - tuf --> https://www.youtube.com/watch?v=S6rsAlj_iB4&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=18
        if(low>=high) return 0;
        int mid=low+(high-low)/2;
        int inversions=mergeSort(nums,low,mid);
        inversions+=mergeSort(nums,mid+1,high);
        inversions+=merge(nums,low,mid,high);
        return inversions;
    }
    int merge(int nums[],int low,int mid,int high){//time = O(n)+O(n) not O(n^2)
        int count=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++){// not O(n^2) as j is not updating always and start there only when i++
            while(j<=high&&nums[i]>(2*(long)nums[j])){//as if nums[i]>2*nums[j] then all k in nums < j will also be <= 2*nums[i] as sorted array
                j++;
            }
            count+=(j-(mid+1));
        }
        ArrayList<Integer>temp=new ArrayList<Integer>();
        int left=low,right=mid+1;
        while(left<=mid&&right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }else{
                temp.add(nums[right++]);
            }
        }
        while(left<=mid){
            temp.add(nums[left++]);            
        }
        while(right<=high){
            temp.add(nums[right++]);            
        }
       for(int i=low;i<=high;i++){
           nums[i]=temp.get(i-low);
       }
        return count;
    }
}