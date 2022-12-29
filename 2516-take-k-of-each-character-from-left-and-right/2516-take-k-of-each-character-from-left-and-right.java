class Solution {
    public int takeCharacters(String s, int k) {
        int n=s.length();
        int countA=0,countB=0,countC=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='a') countA++;
            else if(c=='b') countB++;
            else countC++;
        }
        if(countA<k || countB<k || countC<k) return -1;
        countA-=k;
        countB-=k;
        countC-=k;
        int winA=0,winB=0,winC=0,i=0,j=0,max=0;
        while(j<n){
            char c=s.charAt(j);
            if(c=='a') winA++;
            else if(c=='b') winB++;
            else winC++;
            while(i<n && (winA>countA || winB>countB || winC>countC)){
                char cc=s.charAt(i);
                if(cc=='a') winA--;
                else if(cc=='b') winB--;
                else winC--;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return n-max;
    }
}