class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        int r=a.length;
        int c=a[0].length;
         int d=0;
       ArrayList<Integer>ans=new ArrayList<>();
       int left=0,right=c-1,up=0,down=r-1;
        //d=0->left , d=1->down , d=2-> left, d=3 ->up
       while(left<=right&&up<=down){
           if(d==0){
               for(int i=left;i<=right;i++){
                   ans.add(a[up][i]);
               }
                  up++;
           }else if(d==1){
               for(int i=up;i<=down;i++){
                   ans.add(a[i][right]);
               }
                  right--;
           }else if(d==2){
                 for(int i=right;i>=left;i--){
                   ans.add(a[down][i]);
               }
                  down--;
           }else if(d==3){                             //   up->
               for(int i=down;i>=up;i--){              //   .
                                                       //   .
                   ans.add(a[i][left]);                //   down->
                                                       //          ^     .....   ^
               }                                       //         left          right
                  left++;
           }
           d=(d+1)%4;
       }
       return ans;
    }
}