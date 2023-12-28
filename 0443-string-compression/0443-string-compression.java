class Solution {
    public int compress(char[] a) {
        int n=a.length;
        int i=0,j=0,c=1;
        while(j<n){
            j++;
            while(j<n && a[j]==a[j-1]){
                c++;
                j++;
            }
            i=fill(i,a,j-1,c);
            c=1;
        }
        return i;
    }
    int fill(int i,char a[],int j,int c){
        if(c==1){
            a[i]=a[j];
            i++;
            return i;
        }else{
            a[i]=a[j];
            i++;
            String s=String.valueOf(c);
            for(int y=0;y<s.length();y++){
                a[i]=s.charAt(y);
                i++;
            }
            return i;
        }
    }
}