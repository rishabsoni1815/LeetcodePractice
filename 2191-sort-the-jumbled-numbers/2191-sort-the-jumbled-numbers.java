class Solution {
    public int[] sortJumbled(int[] h, int[] a) {
        int n=a.length;
        Integer ans[]=new Integer[n];
        for(int i=0;i<n;i++){
            ans[i]=i;
        }
        Arrays.sort(ans,(x,y)->(help(a[x],h)==help(a[y],h)) ? (x-y):(help(a[x],h)-help(a[y],h)));
        int c[]=new int[n];
        for(int i=0;i<n;i++){
            c[i]=a[ans[i]];//cant do a[i]=a[ans[i]] as a changes on the go so overrides
        }
        return c;

    }
    int help(int a,int h[]){
        String s=String.valueOf(a);
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            c[i]=(char)(h[c[i]-'0']+(int)'0');
        }
        return Integer.valueOf(String.valueOf(c));
    }
    
}