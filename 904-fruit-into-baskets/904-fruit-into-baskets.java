class Solution {
    public int totalFruit(int[] a) {
     return largestSubstringWithAtMostKUniqueCharacters(a,2);
    }
    int largestSubstringWithAtMostKUniqueCharacters(int a[],int k){
        int n=a.length;
        int i=0,j=0;
        HashMap<Integer,Integer>h=new HashMap<>();
        int ans=0,c=0;//c-> count of unique
        while(j<n){
            h.put(a[j],h.getOrDefault(a[j],0)+1);
            if(h.get(a[j])==1) c++;
            if(c<=k){
                ans=Math.max(ans,j-i+1);
                j++;
            }else if(c>k){//k=2 here
                while(c>k){
                    h.put(a[i],h.get(a[i])-1);
                    if(h.get(a[i])==0) c--;
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}