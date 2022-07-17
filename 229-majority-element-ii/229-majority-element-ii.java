class Solution {
    public List<Integer> majorityElement(int[] a) {
        /*
         as we know at max there can be 2 majority elements  because it should be > floor(N/3) times and if you mod(%) any num with 3 at max u can get 2 as remainder 
         so, we do this as n/2 but do it as considering 2 numbers when count1=0 then set number1,count1 and if count2 is 0 then set count2 and number2 if doesnt matches any one then do count1-- and count2
         
        */
        int number1=-1;
        int number2=-1;
        int count1=0,count2=0,n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]==number1){
                count1++;
            }else if(a[i]==number2){
                count2++;
            }else if(count1==0){
                number1=a[i];
                count1=1;
            }else if(count2==0){
                number2=a[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        List<Integer>ans=new ArrayList<>();
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(a[i]==number1){
                count1++;
            }else if(a[i]==number2){
                count2++;
            }
        }
        if(count1>(n/3)) ans.add(number1);
        if(count2>(n/3)) ans.add(number2);
        return ans;
    }
}