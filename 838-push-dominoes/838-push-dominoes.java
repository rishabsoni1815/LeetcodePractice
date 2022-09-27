class Solution {
    public String pushDominoes(String s) {
        char c[]=s.toCharArray();
        int n=s.length();
        int i=0,j=0;
        while(j<n){
            if(c[j]=='.') {
                j++;// case 1. meeting `.`, then skip it
                continue;
            }
            if(c[i]=='R'&&c[j]=='L'){
                // case 4. left end is R and right end is L
                // if we have odd number of dots between them (let's say m dots), 
                // then we can only add (m / 2) Ls and (m / 2) Rs. 
                // p.s `/` here is integer division. e.g. 3 / 2 = 1
                // e.g. R...L -> RR.LL 
                // if we have even number of dots between them (let's say m dots), 
                // then we can only add (m / 2) Ls and (m / 2) Rs. 
                // e.g. R....L -> RRRLLL
                int m=(j-i-1)/2;
                for(int k=1;k<=m;k++){
                    c[i+k]='R';
                    c[j-k]='L';
                }
            }else if(c[i]=='R'&&c[j]=='R'){
                // case 2. both end is equal, i.e. d[r] == d[l]
                // then fill all the dots between both end 
                // e.g. L....L -> LLLLLL
                // e.g. R....R -> RRRRRR
                for(int k=i;k<=j;k++) c[k]='R';
            }else if(c[i]=='L'&&c[j]=='L'){
                // case 2. both end is equal, i.e. d[r] == d[l]
                // then fill all the dots between both end 
                // e.g. L....L -> LLLLLL
                // e.g. R....R -> RRRRRR
                for(int k=i;k<=j;k++) c[k]='L';
            }else if(c[i]=='.'&&c[j]=='L'){
                // case 2.1 if the left end is . and the right end is L, 
                // i.e. d[l] == '.' && d[r] == 'L'
                // then we need to fill them from `l` to `r` in this case
                for(int k=i;k<=j;k++) c[k]='L';
            }
            i=j;
            j++;
        }
        if(c[i]=='R') 
                for(int k=i;k<n;k++) c[k]='R';
        // case 5. if the left dominoe is `R`, then fill all 'R' till the end
        // e.g. LL.R. -> LL.RR
        return String.valueOf(c);
    }
}