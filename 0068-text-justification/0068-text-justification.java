class Solution {
    public List<String> fullJustify(String[] w, int m) {
        int n=w.length;
        List<String>ans=new ArrayList<>();
        int i=0;
        while(i<n){
            int j=i,x=0,c=0;
            while(j<n && (c+x+w[j].length())<=m){
                x+=w[j].length();
                x+=c;
                c=1;
                j++;
            }
            if(j>=n){
                StringBuilder s=new StringBuilder();
                // System.out.println(i+" "+j);
                while(i<j && s.length()<m){
                    if(s.length()==0) s.append(w[i]);
                    else{
                        s.append(" "+w[i]);
                    }
                    i++;
                }
                while(s.length()<m) s.append(" ");
                ans.add(s.toString());
            }else{
                int y=0;
                if(j!=(i+1)) y=(m-x)/(j-i-1);
                int r=0;
                if(j!=(i+1)) r=(m-x)%(j-i-1);
                // System.out.println(i+" "+j+" "+x+" "+y+" "+r);
                StringBuilder s=new StringBuilder();
                for(int k=i;k<j;k++){
                    if(k==i) s.append(w[k]);
                    else{
                        for(int u=0;u<y;u++){
                            s.append(" ");
                        }
                        if(r>0) {
                            s.append(" ");
                            r--;
                        }

                        s.append(" "+w[k]);
                    }
                }
                while(i==j-1 && (m-x)>0) {
                            s.append(" ");
                            x++;
                        }
                ans.add(s.toString());
            }
            i=j;
        }
        return ans;
    }
}