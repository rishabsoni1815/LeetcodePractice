class Solution {
    public List<String> commonChars(String[] a) {
        int h[]=new int[26];
        for(int i=0;i<a[0].length();i++){
            h[a[0].charAt(i)-'a']++;
        }
        
        int ans=0;
        for(int i=1;i<a.length;i++){
            int x[]=new int[26];
            for(int j=0;j<a[i].length();j++){
                x[a[i].charAt(j)-'a']++;
            }
            for(int ii=0;ii<26;ii++){
                h[ii]=Math.min(h[ii],x[ii]);
            }
        }
        List<String>res=new ArrayList<>();
        for(int i=0;i<26;i++){
            while(h[i]-->0){
                res.add(""+(char)(i+'a'));
            }
        }
        return res;
    }
}